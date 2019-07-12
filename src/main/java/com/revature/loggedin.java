package com.revature;

import java.util.Scanner;

public class loggedin {
	public void loginView(){
		int choice;
	 System.out.print("Username: ");
		Scanner logginginfo = new Scanner(System.in);
		String  Username1 = logginginfo.nextLine();
		System.out.print("Password: ");
		String  PassWord1 = logginginfo.nextLine();
		/*for (User u : Users) {
			if(u.getUsername().equals(Username1))
				if(u.getPassword().equals(PassWord1)) {
					//logged in user info
					if(u.getAuthority() == 1) {
						System.out.println(u.getUsername());
						System.out.println("1. Withdraw\n2. Deposit\n3. Apply for joint");
						String  loggedinuserchoice = logginginfo.nextLine();
 				 //	- [] Customers should be able to apply for joint accounts.
 				 //	- [] Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts.
 				 //	- [] All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.  
 				if (logginginfo.hasNextInt()) {
 					choice = logginginfo.nextInt(); 
 			    	switch(choice) {
 			    		case 1: u.setAccountNumber(u.getAccountNumber());
 			    		break;
 			    		case 2: u.setAccountNumber(u.getAccountNumber());
 			    		break;
 			    		case 3: System.out.println("Applying for joing with account number blank");
 			    	}
 				}
					}
					//	- [] Employees of the bank should be able to view all of their customers information. This includes:
				    //   - [] Account information
				    //   - [] Account balances
				    //   - [] Personal information
				 	//- [] Employees should be able to approve/deny open applications for accounts.
					else if(u.getAuthority() == 2){
						
					}
					//- [] Bank admins should be able to view and edit all accounts. This includes:
				    //  - [] Approving/denying accounts
				    //  - [] Withdrawing, depositing, transferring from all accounts
				    //   - [] Canceling accounts
					else if (u.getAuthority() == 3){}
				}

		}*/
}
}
