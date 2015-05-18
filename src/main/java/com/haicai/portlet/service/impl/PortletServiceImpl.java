package com.haicai.portlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haicai.domain.Contact;
import com.haicai.domain.User;
import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.Status;
import com.haicai.portlet.repository.PortletRepository;
import com.haicai.portlet.service.PortletService;

/**
 * @author Cain
 *
 */
@Repository
public class PortletServiceImpl implements PortletService{
	
	@Autowired
	private PortletRepository portletRepository;

	public User findUserByUserName(String username) {
		return this.portletRepository.getUserByUserName(username);
	}

	public List<Contact> findContactInfoForUser(User user, Status status) {
		return this.portletRepository.getContactInfoForUser(user, status);
	}
	
	public Contact findSpecificActiveContactInfoForUser(User user, ContactType contactType, String otherDdescription) {
		return this.portletRepository.getSpecificActiveContactInfoForUser(user, contactType, otherDdescription);
	}

	public boolean addContactForUser(User user, Contact contact) {
		return this.portletRepository.createContactForUser(user, contact);
	}
	
	public boolean updateContactForUser(User user,Contact contact){
		return this.portletRepository.updateContactForUser(user, contact);
	}

}
