package com.revature;

public class User {
	public String Username;
	public String Password;
	public int Authority;
	private int Balance;
	
	public User(String username, String password, int authority, int balance) {
		super();
		Username = username;
		Password = password;
		Authority = authority;
		Balance = balance;
	}
	
	@Override
	public String toString() {
		return "[Username=" + Username + ", Password = " + Password + ", authority = " + Authority +  " balance = " + Balance + "]";
	}
}




