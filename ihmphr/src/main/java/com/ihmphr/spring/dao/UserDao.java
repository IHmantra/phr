package com.ihmphr.spring.dao;

import com.ihmphr.spring.model.IhmphrUser;

public interface UserDao {
	
	IhmphrUser findByUserName(String userId);

}
