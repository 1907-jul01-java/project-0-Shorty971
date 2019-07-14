package com.revature;

class User {
	
	private  String Username;
	private  String Password;
	private  int Authority;
	private  int AccountNumber;
	private  boolean Verified;
	private  int Id;
	
	 public  int getId() {
		return Id;
	}

	User(String username, String password, int authority, int accountnumber, boolean verified) {
		super();
		Username = username;
		Password = password;
		Authority = authority;
		AccountNumber = accountnumber;
		Verified = verified;
	 }
	User(int id,String username, String password, int authority, int accountnumber, boolean verified) {
		super();
		Id = id;
		Username = username;
		Password = password;
		Authority = authority;
		AccountNumber = accountnumber;
		Verified = verified;
	 }

	public User() {
		// TODO Auto-generated constructor stub
		Username = null;
		Password = null;
		Authority = 0;
		AccountNumber = 0;
		Verified = false;
	}

	public  boolean isVerified() {
		return Verified;
	}
	public void setVerified(boolean verified) {
		Verified = verified;
	}
	public  String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public  String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public  int getAuthority() {
		return Authority;
	}
	public void setAuthority(int authority) {
		Authority = authority;
	}
	public  int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountnumber) {
		AccountNumber = accountnumber;
	}
	@Override
	public String toString() {
		return "[\nUsername=" + Username + ", Password = " + Password + ", authority = " + Authority +  " Accountnumber = " + AccountNumber + "]";
	}

	public void setId(int int1) {
		// TODO Auto-generated method stub
		Id = int1;
		
	}
}




