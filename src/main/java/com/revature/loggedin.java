package com.revature;

import java.util.List;
import java.util.Scanner;

public class loggedin {
	public void loginView(persondao PersonDao){
		int choice;
		System.out.print("Username: ");
		Scanner logginginfo = new Scanner(System.in);
		String  Username1 = logginginfo.nextLine();
		System.out.print("Password: ");
		String  PassWord1 = logginginfo.nextLine();
		User loggedin = PersonDao.getUser(Username1,PassWord1); 
		if(loggedin != null && loggedin.isVerified() == true) {
			 		if(loggedin.getAuthority() == 1) {
			 			int loggedinuserchoice =0;
			 			while(loggedinuserchoice != 5) {
		 				Account ac = PersonDao.getAccount(loggedin.getAccountNumber());
						System.out.println("\n\nWelcome " + loggedin.getUsername());
						System.out.println("Balance: " + ac.getBalance());
						System.out.println("1. Withdraw\n2. Deposit\n3. Transfer Funds\n4. Apply for joint\n5. Main Menu");
						loggedinuserchoice = logginginfo.nextInt(); 
						switch(loggedinuserchoice) {
							case 1: System.out.print("Enter withdraw amount: ");
									Scanner withdrawamount = new Scanner(System.in);  // Create a Scanner object
									if (withdrawamount.hasNextInt()) { 
										int amount = withdrawamount.nextInt();
										int accountnum = loggedin.getAccountNumber();
										if(amount <= ac.getBalance()) {
											PersonDao.update1(-amount, accountnum, ac );
										}
										else
											System.out.println("Cannot Withdraw more than is on your account");
									}
									break;
							case 2: System.out.print("Enter Deposit amount: ");
									Scanner DepositAmount = new Scanner(System.in);  // Create a Scanner object
									if (DepositAmount.hasNextInt()) { 
										int amount = DepositAmount.nextInt();
										int accountnum = loggedin.getAccountNumber();
										if(amount >= 0) {
											PersonDao.update1(amount, accountnum, ac );
										}
										else
											System.out.println("Cannot Deposit negative money");
									}
									break;
							case 3:
							Account receiver = new Account();
									int Receivernum = 0;
											int amount = 0;
												System.out.print("Enter Receiving Account number: ");		
												Scanner Transfer = new Scanner(System.in);  // Create a Scanner object
													if (Transfer.hasNextInt()) { 
														Receivernum = Transfer.nextInt();
														System.out.println(ac.toString());
														receiver = PersonDao.getAccount(Receivernum);
									}
													System.out.println(ac.toString());
													System.out.print("Enter Transfer amount: ");
													System.out.println(ac.toString());
													Transfer = new Scanner(System.in);  // Create a Scanner object
													System.out.println(ac.toString());
													if (Transfer.hasNextInt()) { 
														System.out.println(ac.toString());
															amount = Transfer.nextInt();
															System.out.println(ac.toString());
															int acnumber2 = loggedin.getAccountNumber();
										System.out.println(ac.toString());
										if(amount >= 0 && amount <= ac.getBalance() && acnumber2 != Receivernum) {
											PersonDao.update1(-amount, acnumber2, ac );//subtract money from account
											PersonDao.update1(amount, Receivernum, receiver );//give money to account
										}
										else
											System.out.println("Cannot Transfer this amount = " + amount +" "+ ac.getBalance());
									}
									break;
						}//end of switch	
			 			}//end of while
			 		}//end of if
					else if(loggedin.getAuthority() == 2){
						System.out.println("Hello " + loggedin.getUsername());
						System.out.println("1. View Users\n2.View user by name\n3.view unverified users \n4.verify user");
						int  loggedinuserchoice = logginginfo.nextInt(); 
						switch(loggedinuserchoice) {
						case 1: System.out.println(PersonDao.getAll());
						break;
						case 2: 
							String nam = "Frank";
							User lookup = PersonDao.getNamedUser(nam);
							System.out.println(lookup);
							Account ac2 = PersonDao.getAccount(lookup.getAccountNumber());
							System.out.println("Balance: " + ac2.getBalance());
						break;
						case 3:System.out.println(PersonDao.getAllUnverified());
						break;
						case 4: System.out.println("Which account name do you want to verify");
						Scanner verificationname = new Scanner(System.in);
						String nameverify;
							nameverify = verificationname.nextLine();
							System.out.print(nameverify);
							int acnum = PersonDao.gethighestaccountnum();
							PersonDao.updateverified(acnum+1,nameverify);
							PersonDao.insert(new Account(0,acnum+1));
						
						break;
						}
					}
					//- [] Bank admins should be able to view and edit all accounts. This includes:
				    //  - [x] Approving/denying accounts
				    //  - [x] Withdrawing, depositing, transferring from all accounts
				    //   - [] Canceling accounts
					else if (loggedin.getAuthority() == 3){
						System.out.println("Hello " + loggedin.getUsername());
						System.out.println("1. View Users\n2.View user by name\n3.view unverified users "
								+ "\n4.verify user\n5. Withdraw from user\n6. Deposit to user\n7. Transfer between users\n8. Delete user");
						int  loggedinuserchoice = logginginfo.nextInt(); 
						switch(loggedinuserchoice) {
						case 1: System.out.println(PersonDao.getAll());
						break;
						case 2: System.out.print("Enter Username for lookup: ");		
								Scanner namelookup = new Scanner(System.in);  // Create a Scanner object
								if (namelookup.hasNext()) { 
									String nam = namelookup.nextLine();
									User lookup = PersonDao.getNamedUser(nam);
									System.out.println(lookup);
									Account ac2 = PersonDao.getAccount(lookup.getAccountNumber());
									System.out.println("Balance: " + ac2.getBalance());
								}
						break;
						case 3:System.out.println(PersonDao.getAllUnverified());
						break;
						case 4: System.out.println("Which account name do you want to verify");
								Scanner verificationname = new Scanner(System.in);
								String nameverify;
								nameverify = verificationname.nextLine();
								System.out.print(nameverify);
								int acnum = PersonDao.gethighestaccountnum();
								PersonDao.updateverified(acnum+1,nameverify);
								PersonDao.insert(new Account(0,acnum+1));
						break;
						case 5: System.out.println("Which account name do you want to withdraw from");
								Scanner acname = new Scanner(System.in);
								String namewithdraw;
								nameverify = acname.nextLine();
								System.out.print("Enter withdraw amount: ");
								Scanner withdrawamount = new Scanner(System.in);  // Create a Scanner object
								User namedUser = PersonDao.getUser(nameverify);
								Account nameaccount = PersonDao.getAccount(namedUser.getAccountNumber());
								if (withdrawamount.hasNextInt()) { 
									int amount = withdrawamount.nextInt();
									int accountnum = namedUser.getAccountNumber();
									if(amount <= nameaccount.getBalance()) {
										PersonDao.update1(-amount, accountnum, nameaccount );
									}
								else
									System.out.println("Cannot Withdraw more than is on your account");
								}
						break;
						case 6: System.out.println("Which account name do you want to deposit to");
						Scanner acname2 = new Scanner(System.in);
						String namewithdraw2;
						String nameverify2 = acname2.nextLine();
						System.out.print("Enter withdraw amount: ");
						Scanner withdrawamount2 = new Scanner(System.in);  // Create a Scanner object
						User namedUser2 = PersonDao.getUser(nameverify2);
						Account nameaccount2 = PersonDao.getAccount(namedUser2.getAccountNumber());
						if (withdrawamount2.hasNextInt()) { 
							int amount = withdrawamount2.nextInt();
							int accountnum = namedUser2.getAccountNumber();
							if(amount >= 0) {
								PersonDao.update1(amount, accountnum, nameaccount2 );
							}
						else
							System.out.println("Cannot Deposit this amount1");
						}
						break;
						case 7: 
								int amount = 0;
								System.out.println("Which account name do you want to withdraw from");
								Scanner transferwithdraw = new Scanner(System.in);
								String nametransferwithdraw = transferwithdraw.nextLine();
								System.out.print("Enter withdraw amount: ");
								Scanner transferwithdrawamount = new Scanner(System.in);
								if (transferwithdrawamount.hasNextInt()) { 
									amount = transferwithdrawamount.nextInt();
								}
								User transferwithdrawUser = PersonDao.getUser(nametransferwithdraw);
								Account transferwithdrawaccount = PersonDao.getAccount(transferwithdrawUser.getAccountNumber());
								System.out.println("Which account name do you want to deposit to");
								Scanner transferdeposit = new Scanner(System.in);
								String nametransferdeposit = transferdeposit.nextLine();
								User transferdepositUser = PersonDao.getUser(nametransferdeposit);
								Account transferdepositaccount = PersonDao.getAccount(transferdepositUser.getAccountNumber());
									int accountnum = transferwithdrawUser.getAccountNumber();
									int accountnum2 = transferdepositUser.getAccountNumber();
									if(amount <= transferwithdrawaccount.getBalance() && amount >=0) {
										PersonDao.update1(-amount, accountnum, transferwithdrawaccount );
										PersonDao.update1(amount, accountnum2, transferdepositaccount );
									}
								else
									System.out.println("Cannot transfer this amount");
							break;
						case 8:  System.out.print("Enter Username for deletion: ");		
						Scanner namedelete = new Scanner(System.in);  // Create a Scanner object
						if (namedelete.hasNext()) { 
							String nam = namedelete.nextLine();
							User lookup = PersonDao.getNamedUser(nam);
							int number = lookup.getAccountNumber();
							PersonDao.deleteAccount(number);
						}
							break;
						}
					}
			 		}

		else System.out.print("Account doesnt exist or is unverified");
		
}
}