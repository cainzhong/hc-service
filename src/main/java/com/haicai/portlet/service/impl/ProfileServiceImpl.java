package com.haicai.portlet.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.type.Status;
import com.haicai.portlet.repository.PortletRepository;
import com.haicai.portlet.service.ProfileService;

/**
 * @author Cain
 *
 */
@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private PortletRepository portletRepository;

	@Transactional
	public Map<String, Object> findIndividualProfileInfoForUser(String username) {
		User user = this.portletRepository.getUserByUserName(username);
		List<Contact> contactList = this.portletRepository.getContacts(user, Status.ACTIVE);
		List<PersonalHistory> personalHistories = this.portletRepository.getPersonalHistories(user);
		List<Award> awardsList = this.portletRepository.getAwards(user);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("contactList", contactList);
		map.put("personalHistories", personalHistories);
		map.put("awardsList", awardsList);
		return map;
	}

	public boolean disableContact(Contact contact) {
		return this.portletRepository.disableContact(contact);
	}
}
