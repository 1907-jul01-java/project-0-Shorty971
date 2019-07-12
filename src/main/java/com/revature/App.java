package com.revature;
import java.util.ArrayList;
import java.util.Scanner;

//	- [x] Build the application using Java 8.
//  - [x] All interaction with the user should be done through the console using the `Scanner` class.
//- [] All information should be persisted using text files and serialization.
//- [] 100% test coverage is expected using JUnit. You should be using TDD.
//- [] Logging should be accomplished using Log4J. All transactions should be logged.
//- [] Create an SQL script that will create a user in an SQL database and a table schema for storing your bank users and account information.
//- [] Your database should include at least 1 stored procedure.
//- [] Have your bank application connect to your SQL database using JDBC and store all information that way.
//- [] You should use the DAO design pattern for data connectivity.
public class App {
    public static void main(String[] args) {
    signup sign = new signup();
    loggedin loggin = new loggedin();
    	/*ConnectionUtil connection = new ConnectionUtil();
    	connection.getconnection();
    	connection.close();
    	*/

 //    	ArrayList<User> Users = new ArrayList<>();
        int choice =0;
		while(choice !=3) {
			System.out.println("Hello User! Welcome to Benjamin Bank\n1. Login\n2. Sign up\n3. Exit");
		    Scanner mainchoice = new Scanner(System.in);  // Create a Scanner object
		    if (mainchoice.hasNextInt()) { 
		    	choice = mainchoice.nextInt();  // Read user input
		    	switch(choice) {
		    		case 1: loggin.loginView();
		    				break;
		    		case 2: 
		    				sign.signUpView();
		    				break;
		    		case 3: 
		    				System.out.println("Thank you and have a nice day");
		    				break;
		    		default: 
		    				System.out.println("Choose 1 or 2 or 3");
		    	}
		    }
		    else
                System.out.println("only numbers please");   
		    	System.out.println("\n\n");
		}
	}
}

