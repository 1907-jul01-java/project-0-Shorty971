package com.revature;
import java.util.ArrayList;
import java.util.Scanner;
//- [] All information should be persisted using text files and serialization.
//- [] 100% test coverage is expected using JUnit. You should be using TDD.
//- [] Logging should be accomplished using Log4J. All transactions should be logged.
//- [] Your database should include at least 1 stored procedure.
public class App {
    public static void main(String[] args) {
    signup sign = new signup();
    loggedin loggin = new loggedin();
    ConnectionUtil connection = new ConnectionUtil();
    persondao PersonDao = new persondao(connection.getconnection());
        int choice =0;
		while(choice !=3) {
			System.out.println("Hello User! Welcome to Benjamin Bank\n1. Login\n2. Sign up\n3. Exit");
		    Scanner mainchoice = new Scanner(System.in);  // Create a Scanner object
		    if (mainchoice.hasNextInt()) { 
		    	choice = mainchoice.nextInt();  // Read user input
		    	switch(choice) {
		    		case 1: loggin.loginView(PersonDao);
		    				break;
		    		case 2: 
		    				sign.signUpView(PersonDao);
		    				break;
		    		case 3: 
		    				System.out.println("Thank you and have a nice day");
		    				break;
		    		default: 
		    				System.out.println("Choose 1 or 2 or 3");
//		    				mainchoice.close();
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

