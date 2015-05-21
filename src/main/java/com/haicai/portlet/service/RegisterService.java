package com.haicai.portlet.service;

import com.haicai.domain.Contact;
import com.haicai.domain.User;

/**
* @author Jason
*
*/
public interface RegisterService{

     /**
      * Create user in register page
      *
       * @param user
      * @return
      */
     boolean createUser(User user);

     /**
      * Create contact for user in register page
      *
       * @param user
      * @param contact
      * @return
      */
     boolean createContactForUser(User user,Contact contact);

}