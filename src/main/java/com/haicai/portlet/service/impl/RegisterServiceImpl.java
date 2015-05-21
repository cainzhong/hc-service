package com.haicai.portlet.service.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haicai.domain.Contact;
import com.haicai.domain.User;
import com.haicai.portlet.repository.PortletRepository;
import com.haicai.portlet.service.RegisterService;

 

/**
* This is implementation class for RegisterService class
*
* @author jason.xinli.xiang
*/
@Service
public class RegisterServiceImpl implements RegisterService, Serializable {
 
      private static final long serialVersionUID = -3130173594293924000L;
    
      @Autowired
      private PortletRepository portletRepository;

    
      public boolean createUser(User user){
            return this.portletRepository.createUser(user);
      }

      public boolean createContactForUser(User user,Contact contact){
            return this.portletRepository.createContact(user, contact);
      }

}