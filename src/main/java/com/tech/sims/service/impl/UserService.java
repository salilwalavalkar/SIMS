package com.tech.sims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tech.sims.dao.entity.UserEVO;
import com.tech.sims.dao.intf.IUserDao;
import com.tech.sims.model.UserCredentials;
import com.tech.sims.service.intf.IUserService;

public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public UserCredentials retrieveUserDetails(String username) {
		return convertToModel(userDao.retrieveUser(username));
	}

	private UserCredentials convertToModel(UserEVO userEvo) {
		UserCredentials userDetails = new UserCredentials();
		if (userEvo != null) {
			userDetails.setUsername(userEvo.getUsername());
			userDetails.setPassword(userEvo.getPassword());
			userDetails.setRole(userEvo.getRole());
		}
		return userDetails;
	}

}
