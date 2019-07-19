package com.revature;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
    signup Sign = new signup();
    loggedin Loggin = new loggedin();
    ConnectionUtil connection = new ConnectionUtil();
    persondao PersonDao = new persondao(connection.getconnection());
        int choice = 0;
		while(choice != 3) {
			System.out.println("Hello User! Welcome to Benjamin Bank\n1. Login\n2. Sign up\n3. Exit");
		    Scanner mainchoice = new Scanner(System.in);  // Create a Scanner object
		    if (mainchoice.hasNextInt()) { 
		    	choice = mainchoice.nextInt();  // Read user input
		    	switch(choice) {
		    		case 1: Loggin.loginView(PersonDao);
		    				break;
		    		case 2: Sign.signUpView(PersonDao);
		    				break;
		    		case 3: System.out.println("Thank you and have a nice day");
		    				mainchoice.close();
		    				break;
		    		default: 
		    				System.out.println("Choose 1 or 2 or 3");
		    				break;
		    	}
		    }
		    else
                System.out.println("only numbers please");   
		    	System.out.println("\n\n");
		}
		connection.close();
		}    
}