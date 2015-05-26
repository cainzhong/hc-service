package com.haicai.portlet.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.UserRole;
import com.haicai.domain.type.AwardType;
import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.IdNumberType;
import com.haicai.domain.type.Sex;
import com.haicai.domain.type.Status;
import com.haicai.domain.type.UniversityDegree;
import com.haicai.portlet.repository.PortletRepository;
import com.haicai.portlet.service.PortletService;

/**
 * @author Cain
 *
 */
@Repository
public class PortletServiceImpl implements PortletService, UserDetailsService {

	@Autowired
	private PortletRepository portletRepository;

	@Override
	public boolean createUser(String username, String realName, String englishName, String password, Sex sex, String idNumber, IdNumberType idNumberType, String currentCountry, String currentCity) {
		User user = new User();
		user.setUsername(username);
		user.setRealName(realName);
		user.setEnglishName(englishName);
		user.setPassword(password);
		user.setSex(sex);
		user.setIdNumber(idNumber);
		user.setIdNumberType(idNumberType);
		user.setCurrentCountry(currentCountry);
		user.setCurrentCity(currentCity);
		user.setCreateTime(new Timestamp(System.currentTimeMillis()));
		user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return this.portletRepository.createUser(user);
	}

	@Override
	public boolean updateUser(String username, String realName, String englishName, String password, Sex sex, String idNumber, IdNumberType idNumberType, String currentCountry, String currentCity) {
		User user = this.portletRepository.getUserByUserName(username);
		user.setRealName(realName);
		user.setEnglishName(englishName);
		user.setPassword(password);
		user.setSex(sex);
		user.setIdNumber(idNumber);
		user.setIdNumberType(idNumberType);
		user.setCurrentCountry(currentCountry);
		user.setCurrentCity(currentCity);
		user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return this.portletRepository.updateUser(user);
	}

	@Override
	public boolean createContact(User user, String info, ContactType type, String otherDdescription) {
		Contact contact = new Contact();
		contact.setInfo(info);
		contact.setType(type);
		if (otherDdescription != null) {
			contact.setOtherDdescription(otherDdescription.toLowerCase());
		}
		contact.setStatus(Status.ACTIVE);
		contact.setCreateTime(new Timestamp(System.currentTimeMillis()));
		contact.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return this.portletRepository.createContact(user, contact);
	}

	@Override
	public boolean createPersonalHistory(User user, String university, UniversityDegree universityDegree, String major, String graduationYear) {
		PersonalHistory personalHistory = new PersonalHistory();
		personalHistory.setUniversity(university);
		personalHistory.setUniversityDegree(universityDegree);
		personalHistory.setMajor(major);
		personalHistory.setGraduationYear(graduationYear);
		personalHistory.setCreateTime(new Timestamp(System.currentTimeMillis()));
		personalHistory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return this.portletRepository.createPersonalHistory(user, personalHistory);
	}

	@Override
	public boolean updatePersonalHistory(int personalHistoryId, String university, UniversityDegree universityDegree, String major, String graduationYear) {
		PersonalHistory personalHistory = this.portletRepository.getPersonalHistory(personalHistoryId);
		personalHistory.setUniversity(university);
		personalHistory.setUniversityDegree(universityDegree);
		personalHistory.setMajor(major);
		personalHistory.setGraduationYear(graduationYear);
		personalHistory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return this.portletRepository.updatePersonalHistory(personalHistory);
	}

	@Override
	public boolean createAward(User user, AwardType type, String description, String referrer, String other) {
		Award award = new Award();
		award.setType(type);
		award.setDescription(description);
		award.setReferrer(referrer);
		award.setOther(other);
		award.setCreateTime(new Timestamp(System.currentTimeMillis()));
		award.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return this.portletRepository.createAward(user, award);
	}

	@Override
	public boolean updateAward(int awardId, AwardType type, String description, String referrer, String other) {
		Award award = this.portletRepository.getAward(awardId);
		award.setType(type);
		award.setDescription(description);
		award.setReferrer(referrer);
		award.setOther(other);
		award.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return this.portletRepository.updateAward(award);
	}

	@Override
	public User findUserByUserName(String username) {
		return this.portletRepository.getUserByUserName(username);
	}

	@Override
	public User getUserByUserId(int userId) {
		return this.portletRepository.getUserByUserId(userId);
	}

	@Override
	public List<Contact> findContacts(User user, Status status) {
		return this.portletRepository.getContacts(user, status);
	}

	@Override
	public Contact findSpecificActiveContact(User user, ContactType contactType, String otherDdescription) {
		return this.portletRepository.getSpecificActiveContact(user, contactType, otherDdescription);
	}

	@Override
	public List<PersonalHistory> findPersonalHistories(User user) {
		return this.portletRepository.getPersonalHistories(user);
	}

	@Override
	public List<Award> findAwards(User user) {
		return this.portletRepository.getAwards(user);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User user = this.portletRepository.getUserByUserName(username);
		if(user==null){
			return null;
		}
		UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, this.getAuthorities(user));
		return userDetails;
	}

	private Collection<GrantedAuthority> getAuthorities(User user){
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		List<UserRole> userRoles = this.portletRepository.getUserRolesByUser(user);
		for(UserRole userRole:userRoles){
			authList.add(new GrantedAuthorityImpl(userRole.getRole()));
		}
		return authList;
	}
}
