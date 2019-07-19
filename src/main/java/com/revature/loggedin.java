package com.revature;

import java.util.Scanner;

public class loggedin {
	public void loginView(persondao PersonDao){
		User loggedin  = loginview(PersonDao);
		Scanner sc = new Scanner(System.in);
		if(loggedin != null && loggedin.isVerified() == true) {
			if(loggedin.getAuthority() == 1) 
			 	loggedin.usermenu(sc);
			else if(loggedin.getAuthority() == 2)
				loggedin.empmenu(sc);
			else if (loggedin.getAuthority() == 3)
				loggedin.admmenu(sc);
		}
		else System.out.print("Account doesnt exist or is unverified");
	}
	private User loginview(persondao pd) {
		System.out.print("Username: ");
		Scanner logginginfo = new Scanner(System.in);
		String  Username1 = logginginfo.nextLine();
		System.out.print("Password: ");
		String  PassWord1 = logginginfo.nextLine();
		User loggedin = pd.getUser(Username1,PassWord1);
		
		return loggedin;
	}
}