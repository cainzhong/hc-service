package com.online.shopping.orange.pages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.repository.OrangeRepository;

@Service
public class ShoppingService {
	@Autowired
	private OrangeRepository orangeRepository;

	public List<OrderedItem> findOrderedItemForUser(long user_account_id){
		List<OrderedItem> orderedItemList=this.orangeRepository.getOrderedItemInShoppingCartForUser(user_account_id);
		return orderedItemList;
	}
}
