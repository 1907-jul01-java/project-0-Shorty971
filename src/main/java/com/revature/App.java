package com.revature;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
    	ArrayList<User> Users = new ArrayList<>();
        int choice =0;
		while(choice !=3) {
			System.out.println("Hello User! Welcome to Benjamin Bank\n1. Login\n2. Sign up\n3. Exit");
		    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    if (myObj.hasNextInt()) { 
		    	choice = myObj.nextInt();  // Read user input
		    	switch(choice) {
		    		case 1: System.out.println("login succesful");
		    		//System.out.println(Users);
		    		break;
		    		case 2: System.out.print("Username: ");
		    				Scanner Uname = new Scanner(System.in);
		    				String  Username = Uname.nextLine();
		    				System.out.print("Password: ");
		    				Scanner Pword = new Scanner(System.in);
		    				String  PassWord = Pword.nextLine();
		    				System.out.print("authority: ");
		    				Scanner au = new Scanner(System.in);
		    				int  Au = au.nextInt();
		    				System.out.print("Thanks for your patronage " + Username + " please wait until we review your application and remember your password " + PassWord);
		    				Users.add(new User(Username, PassWord, Au));
		    				break;
		    		case 3: System.out.println("exited program");
		    		break;
		    		default: System.out.println("Type 1 or 2 please");
		    	}
		    }
		    else
                System.out.println("only numbers please");
            
		    	System.out.println("\n\n");
		}
	}
}

