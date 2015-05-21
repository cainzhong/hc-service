package com.haicai.portlet.service;

import java.util.List;
import java.util.Map;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;


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
	
	/**
	 * Find a personal history for a user.
	 *
	 * @param personalHistoryId
	 * @return
	 */
	PersonalHistory findPersonalHistory(int personalHistoryId);

	/**
	 * Find a award for a user.
	 *
	 * @param awardId
	 * @return
	 */
	Award findAward(int awardId);
}
