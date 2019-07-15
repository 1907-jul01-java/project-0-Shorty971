package com.revature;

import java.util.Scanner;


public class signup {
	public void signUpView(persondao PersonDao){
//- [x] Customers of the bank should be able to register with a username and password, and apply to open an account.   
	System.out.print("Username: ");
	Scanner Signup = new Scanner(System.in);
	String  Username = Signup.nextLine();
	System.out.print("Password: ");
	String  PassWord = Signup.nextLine();
	if(PersonDao.UserNotInPerson(Username)) {
	PersonDao.insert(new User(Username, PassWord, 1, 0, false));
	System.out.print("Thanks for your patronage " + Username + " please wait until we review your application and remember your password " + PassWord);
	}
	else
		System.out.println("Username already exists in database\nAccount not created");
	}
}
