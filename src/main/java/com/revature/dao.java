package com.revature;

import java.util.List;

public interface dao<E> {
	void insert(E e);
	
	List<User> select();
	
	void delete();
	
	void update();

	List<User> getAll();

	List<User> select(String username, String password);

	User getUser(String username, String password);

	void update1(int balance, int account, Account account2);

	Account getAccount(int accountnumber);
	
}
