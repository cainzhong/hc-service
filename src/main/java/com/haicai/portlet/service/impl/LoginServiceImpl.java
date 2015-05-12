package com.haicai.portlet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haicai.domain.User;
import com.haicai.portlet.repository.PortletRepository;
import com.haicai.portlet.service.LoginService;

/**
 * @author Cain
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private PortletRepository portletRepository;

	public boolean hasMatchedLoginUser(String username, String password) {
		{
			User user = this.portletRepository.getUserByUserName(username);

			if (user.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
