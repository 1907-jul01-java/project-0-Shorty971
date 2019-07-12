package com.revature;

import java.util.Scanner;

public class signup {
	public void signUpView(){
//- [x] Customers of the bank should be able to register with a username and password, and apply to open an account.   
	System.out.print("Username: ");
	Scanner Signup = new Scanner(System.in);
	String  Username = Signup.nextLine();
	System.out.print("Password: ");
	String  PassWord = Signup.nextLine();
	System.out.print("authority: ");
	int  Authority = Signup.nextInt();
	System.out.print("Thanks for your patronage " + Username + " please wait until we review your application and remember your password " + PassWord);
	//still need to figure out user account number generation
	insert into person(Username,PassWord,Authority,AccountNumber,verified) values (Username,PassWord,Authority,0,false);
	//Users.add(new User(Username, PassWord, Authority, 0, false));
	}
}
