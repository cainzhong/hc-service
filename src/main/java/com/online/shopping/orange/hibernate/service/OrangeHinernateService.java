package com.online.shopping.orange.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.util.HibernateUtil;

/**
 * @author Cain
 *
 */
@Service
public class OrangeHinernateService {
	public List<UserAccount> findUserAccountByUserName(String username) {
		Session userAccountSession = HibernateUtil.getSessionFactory().openSession();
		Transaction userAccountTransaction = userAccountSession.beginTransaction();
	
		List<UserAccount> userAccountlList = userAccountSession.createQuery("from UserAccount").list();

		userAccountTransaction.commit();
		userAccountSession.close();

		HibernateUtil.shutdown();

		return userAccountlList;
	}
}
