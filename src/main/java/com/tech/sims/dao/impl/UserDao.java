package com.tech.sims.dao.impl;

import com.tech.sims.dao.base.AbstractDaoImpl;
import com.tech.sims.dao.entity.UserEVO;
import com.tech.sims.dao.intf.IUserDao;

public class UserDao extends AbstractDaoImpl implements IUserDao{
	
	@Override
	public UserEVO retrieveUser(String username) {
		return hibernateTemplate.get(UserEVO.class, username);
	}

}
