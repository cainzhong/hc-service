package com.haicai.portlet.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.haicai.domain.User;
import com.haicai.hibernate.util.HibernateUtil;

/**
 * @author Cain
 *
 */
@Service
public class HCHinernateService {
	public List<User> findAllUsers() {
		Session userSession = HibernateUtil.getSessionFactory().openSession();
		Transaction userTransaction = userSession.beginTransaction();
	
		List<User> userList = userSession.createQuery("from User").list();

		userTransaction.commit();
		userSession.close();

		HibernateUtil.shutdown();

		return userList;
	}
}
