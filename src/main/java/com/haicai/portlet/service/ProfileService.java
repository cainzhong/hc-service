package com.haicai.portlet.service;

import java.util.Map;


/**
 * @author Cain
 * 
 */
public interface ProfileService {
	/**
	 * Find User info, Contact info, Personal History and Awards for user.
	 * 
	 * @param username
	 * @return
	 */
	Map<String, Object> findIndividualProfileInfoForUser(String username);
}
