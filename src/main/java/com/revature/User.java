package com.revature;

public class User {
	private String Username;
	private String Password;
	private int Authority;
	private int AccountNumber;
	private boolean verified;
	
	 User(String username, String password, int authority, int accountnumber, boolean verified) {
		super();
		Username = username;
		Password = password;
		Authority = authority;
		AccountNumber = accountnumber;
		this.verified = verified;
	 }
	
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getAuthority() {
		return Authority;
	}
	public void setAuthority(int authority) {
		Authority = authority;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountnumber) {
		AccountNumber = accountnumber;
	}

	@Override
	public String toString() {
		return "[Username=" + Username + ", Password = " + Password + ", authority = " + Authority +  " Accountnumbers = " + AccountNumber + "]";
	}
}




