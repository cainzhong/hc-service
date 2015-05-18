package com.haicai.portlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
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
public class PortletServiceImpl implements PortletService {

	@Autowired
	private PortletRepository portletRepository;

	public boolean createUser(User user) {
		return this.portletRepository.createUser(user);
	}

	public boolean updateUser(User user) {
		return this.portletRepository.updateUser(user);
	}

	public boolean createContact(User user, Contact contact) {
		return this.portletRepository.createContact(user, contact);
	}

	public boolean updateContact(User user, Contact contact) {
		return this.portletRepository.updateContact(user, contact);
	}

	public boolean createPersonalHistory(User user, PersonalHistory personalHistory) {
		return this.portletRepository.createPersonalHistory(user, personalHistory);
	}

	public boolean updatePersonalHistory(User user, PersonalHistory personalHistory) {
		return this.portletRepository.updatePersonalHistory(user, personalHistory);
	}

	public boolean createAward(User user, Award award) {
		return this.portletRepository.createAward(user, award);
	}

	public boolean updateAward(User user, Award award) {
		return this.portletRepository.updateAward(user, award);
	}

	public User findUserByUserName(String username) {
		return this.portletRepository.getUserByUserName(username);
	}

	public User getUserByUserId(int userId) {
		return this.portletRepository.getUserByUserId(userId);
	}

	public List<Contact> findContacts(User user, Status status) {
		return this.portletRepository.getContacts(user, status);
	}

	public Contact findSpecificActiveContact(User user, ContactType contactType, String otherDdescription) {
		return this.portletRepository.getSpecificActiveContact(user, contactType, otherDdescription);
	}

	public List<PersonalHistory> findPersonalHistories(User user) {
		return this.portletRepository.getPersonalHistories(user);
	}

	public List<Award> findAwards(User user) {
		return this.portletRepository.getAward(user);
	}
}
