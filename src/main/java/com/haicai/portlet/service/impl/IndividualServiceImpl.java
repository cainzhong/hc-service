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
import com.haicai.portlet.service.IndividualService;

/**
 * @author Cain
 *
 */
@Service
public class IndividualServiceImpl implements IndividualService {
	@Autowired
	private PortletRepository portletRepository;

	@Transactional
	public Map<String, Object> findIndividualProfileInfoForUser(String username) {
		User user = this.portletRepository.getUserByUserName(username);
		List<Contact> contacts = this.portletRepository.getContacts(user, Status.ACTIVE);
		List<PersonalHistory> personalHistories = this.portletRepository.getPersonalHistories(user);
		List<Award> awards = this.portletRepository.getAwards(user);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("contacts", contacts);
		map.put("personalHistories", personalHistories);
		map.put("awards", awards);
		return map;
	}

	public boolean disableContact(Contact contact) {
		return this.portletRepository.disableContact(contact);
	}

	public PersonalHistory findPersonalHistory(int personalHistoryId) {
		return this.portletRepository.getPersonalHistory(personalHistoryId);
	}

	public Award findAward(int awardId) {
		return this.portletRepository.getAward(awardId);
	}
}
