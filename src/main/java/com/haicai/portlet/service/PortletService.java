package com.haicai.portlet.service;

import java.util.List;

import com.haicai.domain.Award;
import com.haicai.domain.Contact;
import com.haicai.domain.JobAsked;
import com.haicai.domain.PersonalHistory;
import com.haicai.domain.User;
import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.IdNumberType;
import com.haicai.domain.type.Sex;
import com.haicai.domain.type.Status;
import com.haicai.domain.type.WorkTimeType;

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
	 * @param username
	 * @param realName
	 * @param englishName
	 * @param password
	 * @param sex
	 * @param idNumber
	 * @param idNumberType
	 * @param currentCountry
	 * @param currentCity
	 * @return
	 */
	boolean createUser(String username, String realName, String englishName, String password, Sex sex, String idNumber, IdNumberType idNumberType, String currentCountry, String currentCity);

	/**
	 * Update a user
	 * 
	 * @param username
	 * @param realName
	 * @param englishName
	 * @param password
	 * @param sex
	 * @param idNumber
	 * @param idNumberType
	 * @param currentCountry
	 * @param currentCity
	 * @param portrait
	 * @return
	 */
	boolean updateUser(String username, String realName, String englishName, String password, Sex sex, String idNumber, IdNumberType idNumberType, String currentCountry, String currentCity, byte[] portrait);

	/**
	 * Create a contact info for a user.
	 * 
	 * @param user
	 * @param info
	 * @param type
	 * @param otherDdescription
	 * @return
	 */
	boolean createContact(User user, String info, ContactType type, String otherDdescription);

	/**
	 * Create a personal history for a user.
	 * 
	 * @param user
	 * @param university
	 * @param universityDegree
	 * @param major
	 * @param graduationYear
	 *            String format 'yyyy' or Timestamp
	 * @return
	 */
	boolean createPersonalHistory(User user, String university, String universityDegree, String major, Object graduationYear);

	/**
	 * Update personal history for a user.
	 * 
	 * @param personalHistoryId
	 * @param university
	 * @param universityDegree
	 * @param major
	 * @param graduationYear
	 * @return
	 */
	boolean updatePersonalHistory(int personalHistoryId, String university, String universityDegree, String major, String graduationYear);

	/**
	 * Create a award for a user.
	 * 
	 * @param user
	 * @param type
	 * @param description
	 * @param referrer
	 * @param other
	 * @return
	 */
	boolean createAward(User user, String type, String description, String referrer, String other);

	/**
	 * Update award for a user.
	 * 
	 * @param awardId
	 * @param type
	 * @param description
	 * @param referrer
	 * @param other
	 * @return
	 */
	boolean updateAward(int awardId, String type, String description, String referrer, String other);

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

	/**
	 * Create a record of JobAsked info for a user.
	 * 
	 * @param user
	 * @param proField
	 * @param title
	 * @param officeArea
	 * @param workTimeType
	 * @param expectSalary
	 * @param requirement
	 * @return
	 */
	boolean createJobAsked(User user, String proField, String title, String officeArea, WorkTimeType workTimeType, String expectSalary, String requirement);
}
