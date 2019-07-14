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
		if(loggedin != null) {
			Account ac = PersonDao.getAccount(loggedin.getAccountNumber());
			 //logged in user info
			 //	- [] Customers should be able to apply for joint accounts.
			 //	- [x] Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts.
			 //	- [x] All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.  
					if(loggedin.getAuthority() == 1) {
						System.out.println("\n\nWelcome " + loggedin.getUsername());
						System.out.println("Balance: " + ac.getBalance());
						System.out.println("1. Withdraw\n2. Deposit\n3. Transfer Funds\n4. Apply for joint");
						int  loggedinuserchoice = logginginfo.nextInt(); 
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
							case 3: System.out.print("Enter Receiving Account number: ");
							Account receiver = new Account();
							int Receiver = 0;
							Scanner ReceivingAccount = new Scanner(System.in);  // Create a Scanner object
							if (ReceivingAccount.hasNextInt()) { 
								Receiver = ReceivingAccount.nextInt();
								receiver = PersonDao.getAccount(Receiver);
							}
							System.out.print("Enter Transfer amount: ");
							Scanner TransferAmount = new Scanner(System.in);  // Create a Scanner object
						    if (TransferAmount.hasNextInt()) { 
						    	int amount = TransferAmount.nextInt();
						    	int accountnum = loggedin.getAccountNumber();
						    	if(amount >= 0 && amount <= ac.getBalance()) {
							    	PersonDao.update1(-amount, accountnum, ac );
							    	PersonDao.update1(amount, Receiver, receiver );
						    	}
					    	else
					    		System.out.println("Cannot Transfer this amount");
						    }
							break;
								/*case 4: System.out.println("Enter account number to join");
								Scanner jointApply = new Scanner(System.in);  // Create a Scanner object
								int apply;
								if (jointApply.hasNextInt()) { 
									apply = jointApply.nextInt();
									receiver = PersonDao.getAccount(Receiver);
								}*/
							}	
						}
					//	- [] Employees of the bank should be able to view all of their customers information. This includes:
				    //   - [x] Account information
				    //   - [] Account balances
				    //   - [] Personal information
				 	//- [] Employees should be able to approve/deny open applications for accounts.
					else if(loggedin.getAuthority() == 2){
						System.out.println("Hello " + loggedin.getUsername());
						System.out.println("1. View Users\n2.View user by name\n3.view unverified users\n4.verify user");
						int  loggedinuserchoice = logginginfo.nextInt(); 
						switch(loggedinuserchoice) {
						case 1: System.out.println(PersonDao.getAll());
						break;
						case 2:
						case 3:
						case 4:}
					}
					//- [] Bank admins should be able to view and edit all accounts. This includes:
				    //  - [] Approving/denying accounts
				    //  - [] Withdrawing, depositing, transferring from all accounts
				    //   - [] Canceling accounts
					else if (loggedin.getAuthority() == 3){
						
					}
		else System.out.print(loggedin);
		}
	
}
}