package com.ihmphr.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ihmphr.spring.dao.UserDao;
import com.ihmphr.spring.model.IhmphrUser;
import com.ihmphr.spring.model.IhmphrUserRole;

@Service("ihmphrUserDetailsService")
public class IhmphrUserDetailsService implements UserDetailsService  {
	
	@Autowired
	private UserDao userDao ;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String userId )
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		IhmphrUser ihmphrUser ;
		ihmphrUser = userDao.findByUserName(userId);
		
		List<GrantedAuthority> authorities = buildUserAuthority(ihmphrUser.getUserRole());
		
		
		return xferihmphrUsertoSpringUser (ihmphrUser,authorities);
	}

	private User xferihmphrUsertoSpringUser(IhmphrUser ihmphrUser,
			List<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		
		return new User(ihmphrUser.getUserId(),ihmphrUser.getPasskey(),true,true,true,true,authorities);
				
	}

	private List<GrantedAuthority> buildUserAuthority(
			Set<IhmphrUserRole> userRole) {
		// TODO Auto-generated method stub
		
		System.out.println(" User Roles Coming From Hibernate  "+ userRole );
		
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		
		Iterator<IhmphrUserRole> it = userRole.iterator();
		
		while ( it.hasNext()){
			
			setAuths.add( new SimpleGrantedAuthority( it.next().getUserRoleId()));
		}
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		
		System.out.println("PP--> GrantedAuthorities" + Result );
		
		return Result;
	}

}
