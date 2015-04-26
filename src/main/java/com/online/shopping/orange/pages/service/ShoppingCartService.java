package com.online.shopping.orange.pages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.domain.UserAccount;
import com.online.shopping.orange.repository.OrangeRepository;

@Service
public class ShoppingCartService {
	@Autowired
	private OrangeRepository orangeRepository;

	public List<OrderedItem> findOrderedItemForUser(String userName){
		List<OrderedItem> orderedItemList=this.orangeRepository.getOrderedItemForUser(userName);
		return orderedItemList;
	}
}
