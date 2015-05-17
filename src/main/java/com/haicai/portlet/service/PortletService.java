package com.haicai.portlet.service;

import java.util.List;

import com.haicai.domain.Contact;
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
	 * Find a user info through user name.
	 *
	 * @param username
	 * @return
	 */
	User findUserByUserName(String username);
	
	/**
	 * Find contact info for a user.
	 *
	 * @param user
	 * @param status
	 * @return
	 */
	List<Contact> findContactInfoForUser(User user,Status status);
	
	/**
	 * Find a specific and active contact info for a user.
	 *
	 * @param user
	 * @param contactType
	 * @param otherDdescription
	 * @return
	 */
	Contact findSpecificActiveContactInfoForUser(User user, ContactType contactType, String otherDdescription);
	
	/**
	 * Add contact info for a user.
	 *
	 * @param user
	 * @param contact
	 * @return
	 */
	boolean addContactForUser(User user, Contact contact);
	
	/**
	 * Update contact info for a user.
	 *
	 * @param user
	 * @param contact
	 * @return
	 */
	boolean updateContactForUser(User user,Contact contact);
}
