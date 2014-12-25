package com.ihmphr.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ihmphr.spring.model.IhmphrUser;

@Repository
public class UserDaoImpl implements UserDao {
	
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public IhmphrUser findByUserName(String userId) {
		// TODO Auto-generated method stub
				
		List<IhmphrUser> users = new ArrayList<IhmphrUser>();
		
		users = sessionFactory.getCurrentSession().createQuery(" from IhmphrUser where user_id = :username")
				      .setParameter("username", userId)
		              .list();
		
		if ( users.size() > 0 )
			
		{
			System.out.println("Got User From DB");
			return users.get(0);
		}
		else {
			
			System.out.println("Failed to get  User From DB");
		
			return null;
		}
		
		
	}

}
