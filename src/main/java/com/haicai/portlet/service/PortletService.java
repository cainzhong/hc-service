package com.haicai.portlet.service;

import java.util.List;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.Status;

/**
 * This is a common service.
 *
 * @author Cain
 *
 */
public interface PortletService {
	/**
	 * Create a user in database.
	 *
	 * @param user
	 * @return
	 */
	boolean createUser(User user);

	/**
	 * Update a user.
	 *
	 * @param user
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * Create a contact info for a user.
	 *
	 * @param user
	 * @param contact
	 * @return
	 */
	boolean createContact(User user, Contact contact);

	/**
	 * Update a contact info for a user.
	 *
	 * @param user
	 * @param contact
	 * @return
	 */
	boolean updateContact(User user, Contact contact);

	/**
	 * Create a personal history for a user.
	 *
	 * @param user
	 * @param personalHistory
	 * @return
	 */
	boolean createPersonalHistory(User user, PersonalHistory personalHistory);

	/**
	 * Update personal history for a user.
	 *
	 * @param user
	 * @param personalHistory
	 * @return
	 */
	boolean updatePersonalHistory(User user, PersonalHistory personalHistory);

	/**
	 * Create a award for a user.
	 *
	 * @param user
	 * @param awards
	 * @return
	 */
	boolean createAward(User user, Award award);

	/**
	 * Update award for a user.
	 *
	 * @param user
	 * @param award
	 * @return
	 */
	boolean updateAward(User user, Award award);

	/**
	 * Find a user info through user name.
	 *
	 * @param username
	 * @return
	 */
	User findUserByUserName(String username);

	/**
	 * Find a user info through user id.
	 *
	 * @param userId
	 * @return
	 */
	User getUserByUserId(int userId);

	/**
	 * Find a list of contact info for a user.
	 *
	 * @param user
	 * @param status
	 * @return
	 */
	List<Contact> findContacts(User user, Status status);

	/**
	 * Find a specific and active contact info for a user.
	 *
	 * @param user
	 * @param contactType
	 * @param otherDdescription
	 * @return
	 */
	Contact findSpecificActiveContact(User user, ContactType contactType, String otherDdescription);

	/**
	 * Find a list of personal history for a user.
	 *
	 * @param user
	 * @return
	 */
	List<PersonalHistory> findPersonalHistories(User user);

	/**
	 * Find a list of award for a user.
	 *
	 * @param user
	 * @return
	 */
	List<Award> findAwards(User user);
}
