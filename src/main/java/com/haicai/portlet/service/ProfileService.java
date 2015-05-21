package com.haicai.portlet.service;

import java.util.Map;

import com.haicai.domain.Contact;


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

	/**
	 * Set a contact info into inactive for a user.
	 *
	 * @param contact
	 * @return
	 */
	boolean disableContact(Contact contact);
}
