package com.haicai.portlet.service;

/**
 * @author Cain
 *
 */
public interface LoginService {

	/**
	 * Check the login user info.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean hasMatchedLoginUser(String username, String password);
}
