package com.tech.sims.helper;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tech.sims.model.UserCredentials;
import com.tech.sims.service.intf.IUserService;

/**
 * UserDetailsService interface is used in order to lookup the username,
 * password and GrantedAuthorities for any given user. This interface provide
 * only one method which implementing class need to implement.
 * 
 * UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException;
 * 
 * @author salil
 * 
 */
public class UserHelper implements UserDetailsService {
	
	@Autowired
	private IUserService userService;

	/**
	 * Userdetails - Provides core user information.
	 * 
	 * Implementations are not used directly by Spring Security for security
	 * purposes. They simply store user information which is later encapsulated
	 * into Authentication objects. This allows non-security related user
	 * information (such as email addresses, telephone numbers etc) to be stored
	 * in a convenient location.
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		UserCredentials user = userService.retrieveUserDetails(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
        }
		
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(authority));
	}
}