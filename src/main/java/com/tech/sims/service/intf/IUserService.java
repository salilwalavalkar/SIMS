package com.tech.sims.service.intf;

import com.tech.sims.model.UserCredentials;
import com.tech.sims.service.base.IService;

public interface IUserService extends IService {
	
	UserCredentials retrieveUserDetails(String username);

}
