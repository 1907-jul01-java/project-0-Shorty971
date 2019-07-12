package com.revature;

import java.util.List;

public interface dao {
	void insert(User user);
	
	List<User> select();
	
	void delete();
	
	void update();
	
}
