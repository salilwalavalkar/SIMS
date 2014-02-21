package com.tech.sims.dao.intf;

import com.tech.sims.dao.base.IDao;
import com.tech.sims.dao.entity.UserEVO;

public interface IUserDao extends IDao {
	
	UserEVO retrieveUser(String username);

}
