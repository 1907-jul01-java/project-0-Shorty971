package com.revature;

import java.util.Scanner;

class User {
	
	private  String Username;
	private  String Password;
	private  int Authority;
	private  int AccountNumber;
	private  boolean Verified;
	private  int Id;
	
	public  int getId() {
		return Id;
	}
	public void setId(int int1) {
		Id = int1;
	}
	public  boolean isVerified() {
		return Verified;
	}
	public void setVerified(boolean verified) {
		Verified = verified;
	}
	public  String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public  String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public  int getAuthority() {
		return Authority;
	}
	public void setAuthority(int authority) {
		Authority = authority;
	}
	public  int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountnumber) {
		AccountNumber = accountnumber;
	}
	 
	ConnectionUtil connection = new ConnectionUtil();
	persondao PersonDao = new persondao(connection.getconnection());
		
	User(String username, String password, int authority, int accountnumber, boolean verified) {
		Username = username;
		Password = password;
		Authority = authority;
		AccountNumber = accountnumber;
		Verified = verified;
	 }
	User(int id,String username, String password, int authority, int accountnumber, boolean verified) {
		Id = id;
		Username = username;
		Password = password;
		Authority = authority;
		AccountNumber = accountnumber;
		Verified = verified;
	 }
	User() {
		Username = null;
		Password = null;
		Authority = 0;
		AccountNumber = 0;
		Verified = false;
	}

	@Override
	public String toString() {
		return "\nUsername=" + Username  + ", Accountnumber = " + AccountNumber + ", Verified = " + Verified ;
	}
	
	public void usermenu(Scanner sc) {
	Account ac = PersonDao.getAccount(this.getAccountNumber());
	int loggedinuserchoice = 0;
 	while(loggedinuserchoice != 4) {
 		welcomeuser(ac);
 		loggedinuserchoice = sc.nextInt(); 
		switch(loggedinuserchoice) {
		case 1: userwithdraw(ac);
		break;
		case 2:userdeposit(ac);
		break;
		case 3:	usertransfer(ac);
		break;
		}//end of switch	
 	}
 	}

	public void empmenu(Scanner logginginfo) {
		int loggedinuserchoice =0;
	 	while(loggedinuserchoice != 5) {
		welcomeemp();
		loggedinuserchoice = logginginfo.nextInt(); 
		switch(loggedinuserchoice) {
		case 1: System.out.println(PersonDao.getAllgeneral());
		break;
		case 2: userlookup();
		break;
		case 3:System.out.println(PersonDao.getAllUnverified());
		break;
		case 4: userverify();
		break;
		}
	 	}
		
	}
	
	private void welcomeemp() {
		System.out.println("\n\nHello " + this.getUsername());
		System.out.println("1. View Users\n2. View user by name\n3. View unverified users \n4. Verify user\n5. Main Menu");
	}
	private void userverify() {
		System.out.println("Which account name do you want to verify");
		Scanner verificationname = new Scanner(System.in);
		String nameverify;
		nameverify = verificationname.nextLine();
		User lookupverify = PersonDao.getNamedUser(nameverify);
		if(lookupverify.getUsername() != null) {
			int acnum = PersonDao.gethighestaccountnum();
			PersonDao.updateverified(acnum+1,nameverify);
			PersonDao.insert(new Account(0,acnum+1));
			System.out.println("Account verified succesfully");
		}
		else {
			System.out.println("Pending account with this name does not exist");
		}
		
	}
	private void userlookup() {
		System.out.println("Enter username you want to view");
		Scanner viewname = new Scanner(System.in);
		String nameview = viewname.nextLine();
		User lookup = PersonDao.getNamedUser(nameview);
		if(lookup.getUsername() != null) {
			System.out.println(lookup);
			Account ac2 = PersonDao.getAccount(lookup.getAccountNumber());
			System.out.println("Balance: " + ac2.getBalance());
		}
		else
			System.out.println("Account with this username does not exist");
	}

		
	public void admmenu(Scanner logginginfo) {
		int loggedinuserchoice =0;
	 	while(loggedinuserchoice != 9) {
			admwelcome();
			loggedinuserchoice = logginginfo.nextInt(); 
			switch(loggedinuserchoice) {
			case 1: System.out.println(PersonDao.getAll());
			break;
		//	case 2: userlookup();
		//	break;
			case 3:	System.out.println(PersonDao.getAllUnverified());
			break;
		//	case 4: userverify();
		//	break;
			case 5: admwithdraw();
			break;
			case 6: admdeposit();
			break;
			case 7: admtransfer();
			break;
			case 8: admdelete();
			break;
			}
		}
	}
	
	private void welcomeuser(Account ac) {
		System.out.println("\n\nWelcome " + this.getUsername());
		System.out.println("Account number " + this.getAccountNumber());
		System.out.println("Balance: " + ac.getBalance());
		System.out.println("1. Withdraw\n2. Deposit\n3. Transfer Funds\n4. Main Menu");					    	
	}
	
	private void admwelcome() {
		System.out.println("\n\nHello " + this.getUsername());
		System.out.println("1. View Users\n2. View user by name\n3. View unverified users " + "\n4. Verify user\n5. Withdraw from user\n6. Deposit to user\n7. Transfer between users\n8. Delete user\n9. Main Menu");
	}
	
	private void usertransfer(Account ac) {
		Account receiver = new Account();
		int Receivernum = 0;
		int amount = 0;
		System.out.print("Enter Receiving Account number: ");		
		Scanner Transfer = new Scanner(System.in);  // Create a Scanner object
		if (Transfer.hasNextInt()) { 
			Receivernum = Transfer.nextInt();
			receiver = PersonDao.getAccount(Receivernum);
		}
		System.out.print("Enter Transfer amount: ");
		Transfer = new Scanner(System.in);  // Create a Scanner object
		if (Transfer.hasNextInt()) { 
			amount = Transfer.nextInt();
			int acnumber2 = this.getAccountNumber();
			if(amount >= 0 && amount <= ac.getBalance() && acnumber2 != Receivernum) {
				PersonDao.update1(-amount, acnumber2, ac );//subtract money from account
				PersonDao.update1(amount, Receivernum, receiver );//give money to account
			}
			else
				System.out.println("Cannot Transfer this amount = " + amount +" "+ ac.getBalance());
		}
	}
	private void userwithdraw(Account ac) {
		System.out.print("Enter withdraw amount: ");
		Scanner withdrawamount = new Scanner(System.in);  // Create a Scanner object
		if (withdrawamount.hasNextInt()) { 
			int amount = withdrawamount.nextInt();
			int accountnum = this.getAccountNumber();
			if(amount <= ac.getBalance()) {
				PersonDao.update1(-amount, accountnum, ac );
			}
		else
		System.out.println("Cannot Withdraw more than is on your account");
		}	
	}	
	private void userdeposit(Account ac) {
		 System.out.print("Enter Deposit amount: ");
			Scanner DepositAmount = new Scanner(System.in);  // Create a Scanner object
			if (DepositAmount.hasNextInt()) { 
				int amount = DepositAmount.nextInt();
				int accountnum = this.getAccountNumber();
				if(amount >= 0) {
					PersonDao.update1(amount, accountnum, ac );
				}
				else
					System.out.println("Cannot Deposit negative money");
			}
		}
	private void admdelete() {
		System.out.print("Enter Username for deletion: ");		
		Scanner namedelete = new Scanner(System.in);  // Create a Scanner object
		if (namedelete.hasNext()) { 
			String nam = namedelete.nextLine();
			User lookupname = PersonDao.getNamedUser(nam);
			int number = lookupname.getAccountNumber();
			PersonDao.deleteAccount(number);
			System.out.println("Account deleted");
		}
	}
	private void admtransfer() {
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
			if(amount <= transferwithdrawaccount.getBalance() && amount >=0 && accountnum != accountnum2) { 
				PersonDao.update1(-amount, accountnum, transferwithdrawaccount );
				PersonDao.update1(amount, accountnum2, transferdepositaccount );
			}
		else
			System.out.println("Cannot transfer this amount");
	
	}
	private void admdeposit() {
		System.out.println("Which account name do you want to deposit to");
		Scanner acname2 = new Scanner(System.in);
		String namewithdraw2;
		String nameverify2 = acname2.nextLine();
		System.out.print("Enter deposit amount: ");
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
			System.out.println("Cannot Deposit this amount");
		}
	}
	private void admwithdraw() {
		System.out.println("Which account name do you want to withdraw from");
		Scanner acname = new Scanner(System.in);
		String namewithdraw;
		String nameverify = acname.nextLine();
		System.out.print("Enter withdraw amount: ");
		Scanner withdrawamount = new Scanner(System.in);  // Create a Scanner object
		User namedUser = PersonDao.getUser(nameverify);
		Account nameaccount = PersonDao.getAccount(namedUser.getAccountNumber());
		if (withdrawamount.hasNextInt() && namedUser.getUsername()!=null) { 
			int amount = withdrawamount.nextInt();
			int accountnum = namedUser.getAccountNumber();
			if(amount <= nameaccount.getBalance()) {
				PersonDao.update1(-amount, accountnum, nameaccount );
			}
			else
				System.out.println("Cannot Withdraw more than is on your account");
		}
		else
			System.out.println("This user does not exist");
	}
}
