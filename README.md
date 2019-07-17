# Command Line Interface Banking
## Benjamin Garcia
This is a simple Command Line Interface banking application. This application is written using Java as part of Revatures 1907-jul01-java project 0.
The purpose of this application is to make a simple banking solution connected to a database without relying on GUI. 


# User Stories
 List
Customers start be creating an account.
Created account needs to wait for employee verification to begin usage.
After employee verifies Customers request customer is given access to account.
After logging in User can see their account number and how much money is in it.
Logged in user can either withdraw, deposit, or transfer money
Withdrawing and depositing is limited to their account
Transfer allows a person to give their money to another account
Employees can view all users usernames, accountnumber, and balance
Employees are able to verify account applications from customers
Admins have access to all employee functions and more
Admins are able to see every account on the database not just customers
Admins withdraw from any customer
Admins are able to deposit money into any customers account
Admin can transfer money between any two customers
Admin can delete a users account

# Instructions
Build Postgres projectzero
Change directory into /db and run:

docker build -t project0 .

Then run a container:

docker run -d -p 5432:5432 project0

Compile, Package, & Execute with Maven
To compile and execute, run:

mvn compile
mvn exec:java
To package an executable jar and execute, run:

mvn clean package
java -jar target/project0-1.0-SNAPSHOT.jar
