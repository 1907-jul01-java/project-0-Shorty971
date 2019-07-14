package com.revature;

public class Account {
	private static int balance;
	private static int AccountNumber;
		
	public Account(int i, int j) {
		balance = i;
		AccountNumber = j;
		// TODO Auto-generated constructor stub
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public static int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		Account.balance = balance;
	}
	public static int getAccountNumber() {
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
