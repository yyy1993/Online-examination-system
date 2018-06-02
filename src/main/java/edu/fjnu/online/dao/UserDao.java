package edu.fjnu.online.dao;

import edu.fjnu.online.domain.User;

import java.util.List;


public interface UserDao extends BaseDao<User>{

	public List<User> findPending(User user);
	public User getStu(User user);
}
