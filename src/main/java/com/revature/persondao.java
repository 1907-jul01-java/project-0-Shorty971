package com.revature;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class persondao implements dao<User>{
	    Connection connection;

	    @Override
	    public List<User> getAll() {
	    	List<User> users = new ArrayList<User>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("select * from person");
	            while (resultSet.next()) {
	                User user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"),resultSet.getInt("authority"),resultSet.getInt("accountnum"),resultSet.getBoolean("verified"));
	                users.add(user);
	            }
	        resultSet.close();
	        } catch (SQLException e) {
	        }
	        return users;
	    }

	    @Override
	    public User getNamedUser(String name) {
	    	User users = new User();
	        try {
	        	 PreparedStatement pStatement = connection.prepareStatement("select * from person where username = ?");
		            pStatement.setString(1, name);
		            ResultSet resultSet = pStatement.executeQuery();
	            while (resultSet.next()) {
	                users = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"),resultSet.getInt("authority"),resultSet.getInt("accountnum"),resultSet.getBoolean("verified"));
	            }
	        resultSet.close();
	        } catch (SQLException e) {
	        }
	        return users;
	    }

	    @Override
	    public void update1(int balance,int accountnum, Account account ) {
	    	try {
	            PreparedStatement pStatement = connection.prepareStatement("update account set balance = ? where accountnumber = ?");
	            int bal = account.getBalance();
	            System.out.print("bal = " + bal);
	            int money = bal + balance;
	            System.out.println("money = " + money);
	            pStatement.setInt(1, money );
	            pStatement.setInt(2, accountnum);
	            pStatement.executeQuery();
	        } catch (SQLException e) {
	        }
	    }
	    @Override
	    public void updateverified(int number,String name ) {
	    	try {
	            PreparedStatement pStatement = connection.prepareStatement("update person set verified = true, accountnum = ? where username = ?");
	            pStatement.setInt(1, number);
	            pStatement.setString(2,name);
	            pStatement.executeQuery();
	        } catch (SQLException e) {
	        }
	    }

	    @Override
	    public void delete() {

	    }

	    public persondao(Connection connection) {
	        this.connection = connection;
	    }

		@Override
		public List<User> select(String username, String password) {
			// TODO Auto-generated method stub
		        try {
		            Statement statement = connection.createStatement();
		            ResultSet resultSet = statement.executeQuery("select * from person where username = ? and password = ?");
		        } catch (SQLException e) {

		        }
			return null;
		}

		 @Override
		    public void insert(User user) { 
			 try {
		            PreparedStatement pStatement = connection.prepareStatement("insert into Person(Username,Password,Authority,Accountnum,verified) values(?,?,?,?,?)");
		        	pStatement.setString(1, user.getUsername());
		            pStatement.setString(2, user.getPassword());
		            pStatement.setInt(3, user.getAuthority());
		            pStatement.setInt(4, user.getAccountNumber());
		            pStatement.setBoolean(5, user.isVerified());
		            pStatement.executeUpdate();  
			 } catch (SQLException e) {

		        }
		    }
		    
		 @Override
		    public User getUser(String username, String password) {
			 User use = new User();   
			 try {
		            PreparedStatement pStatement = connection.prepareStatement("select * from person where username = ? and password = ?");
		            pStatement.setString(1, username);
		            pStatement.setString(2, password);
		            ResultSet resultSet = pStatement.executeQuery();
		            while (resultSet.next()) {
		                User user = new User();
		                user.setUsername(resultSet.getString("username"));
		                user.setPassword(resultSet.getString("password"));
		                user.setAuthority(resultSet.getInt("authority"));
		                user.setAccountNumber(resultSet.getInt("accountnum"));
		                user.setVerified(resultSet.getBoolean("verified"));
		                use = user;
		            	}
			 } catch (SQLException e) {
		        }
		        return use;
		    }
		 
		    public Account getAccount(int accountnumber) {
			 Account acc = new Account();  
			 try {
		            PreparedStatement pStatement = connection.prepareStatement("select * from Account where accountnumber = ?");
		            pStatement.setInt(1, accountnumber);
		            ResultSet resultSet = pStatement.executeQuery();
		            	while (resultSet.next()) {
		                acc.setAccountNumber(resultSet.getInt("accountnumber"));
		                acc.setBalance(resultSet.getInt("balance"));
		            	}
			 } catch (SQLException e) {
		        }
		        return acc;
		    }
		@Override
		public List<User> select() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}

	    @Override
	    public List<User> getAllUnverified() {
	    	List<User> users = new ArrayList<User>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("select * from person where verified = false");
	            while (resultSet.next()) {
	                User user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"),resultSet.getInt("authority"),resultSet.getInt("accountnum"),resultSet.getBoolean("verified"));
	                users.add(user);
	            }
	        resultSet.close();
	        } catch (SQLException e) {
	        }
	        return users;
	    }

		public void insert(Account account) { 
			 try {
		            PreparedStatement pStatement = connection.prepareStatement("insert into Account(balance,accountnumber) values(?,?)");
		        	pStatement.setInt(1, account.getBalance());
		            pStatement.setInt(2, account.getAccountNumber());
		            pStatement.executeUpdate();  
			 } catch (SQLException e) {

		        }
		    }

		public boolean UserNotInPerson(String username) {
			// TODO Auto-generated method stub
		    	String name = null;
		        try {
		        	 PreparedStatement pStatement = connection.prepareStatement("select * from person where username = ?");
			            pStatement.setString(1, username);
			            ResultSet resultSet = pStatement.executeQuery();
		            while (resultSet.next()) {
		                name = resultSet.getString("username");
		            }
		        resultSet.close();
		        } catch (SQLException e) {
		        }
		        if(name != null)
		        	return false;
		        else 
		        	return true;
		    }

		public int gethighestaccountnum() {
			int num =0;
		        try {
		            Statement statement = connection.createStatement();
		            ResultSet resultSet = statement.executeQuery("select max(id) from account");
		            while (resultSet.next()) {
		                num = resultSet.getInt("max");
		            }
		        resultSet.close();
		        } catch (SQLException e) {
		        }
		        return num;
		}
	}

