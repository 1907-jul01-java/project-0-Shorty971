package com.revature;

public class Account {
	private int balance;
	private int AccountNumber;
		
	public Account(int i, int j) {
		balance = i;
		AccountNumber = j;
		// TODO Auto-generated constructor stub
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

		@Override
		public String toString() {
			return "[balance =" + balance + ", AccountNumber = " + AccountNumber + "]";
		}
	}
