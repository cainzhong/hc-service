package com.online.shopping.orange.pages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.repository.OrangeRepository;

@Service
public class LoginService {
	@Autowired
	private OrangeRepository orangeRepository;
	
	public boolean hasMatchedLoginUser(String userName, String password){
		UserAccount userAccount=orangeRepository.findUserAccountByUserName(userName);
		if(userAccount.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}
}
