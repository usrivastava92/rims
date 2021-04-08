package com.rims.hibernate.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.rims.hibernate.entity.masters.UserPo;
import com.rims.hibernate.service.BaseService;

@Named("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Inject
	@Named("baseServiceImpl")
	private BaseService baseServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPo user = findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		return user;
	}

	public UserPo findUserByUsername(String username) {
		Map<String, Object> whereClauseMap = new HashMap<>();
		whereClauseMap.put("username", username);
		List<UserPo> userList = baseServiceImpl.getEntityList(UserPo.class, whereClauseMap);
		if (!userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	public UserPo findUserByEmail(String email) {
		Map<String, Object> whereClauseMap = new HashMap<>();
		whereClauseMap.put("email", email);
		List<UserPo> userList = baseServiceImpl.getEntityList(UserPo.class, whereClauseMap);
		if (!userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	public UserPo findUserById(String id) {
		Map<String, Object> whereClauseMap = new HashMap<>();
		whereClauseMap.put("id", id);
		List<UserPo> userList = baseServiceImpl.getEntityList(UserPo.class, whereClauseMap);
		if (!userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

}
