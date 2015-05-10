package com.haicai.portlet.service;

import com.haicai.domain.type.ContactType;
import com.haicai.domain.type.Sex;

/**
 * @author Cain
 *
 */
public interface RegisterService {
	/**
	 * 
	 * @return
	 */
	boolean registerUser(String username,String realName,String enlishName,Sex sex,String password,String emial,String telephone,ContactType contactType, String otherContact);
}
