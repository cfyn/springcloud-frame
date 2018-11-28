package com.siwei.frame.user.provider.dao;


import com.siwei.frame.common.utils.entity.User;

import java.util.List;

public interface UserMapper {
	
	void updateById(User user);
	
	void insert(User user);
	
	User findByMobile(String mobile);
	
	User findById(Integer id);
	
	List<User> findUsers(User user);
}