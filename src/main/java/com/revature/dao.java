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

	User getNamedUser(String name);

	List<User> getAllUnverified();

	void updateverified(int number, String name);

	List<User> getAllgeneral();

}
