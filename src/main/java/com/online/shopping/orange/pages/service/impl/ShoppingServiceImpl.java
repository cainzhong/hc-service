package com.online.shopping.orange.pages.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.orange.domain.OrderedItem;
import com.online.shopping.orange.pages.service.ShoppingService;
import com.online.shopping.orange.repository.OrangeRepository;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	private OrangeRepository orangeRepository;

	public List<OrderedItem> findOrderedItemForUser(long userAccountId){
		List<OrderedItem> orderedItemList=this.orangeRepository.getOrderedItemInShoppingCartForUser(userAccountId);
		return orderedItemList;
	}
}
