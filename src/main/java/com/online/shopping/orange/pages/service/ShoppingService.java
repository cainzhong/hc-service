package com.online.shopping.orange.pages.service;

import java.util.List;

import com.online.shopping.orange.domain.OrderedItem;

public interface ShoppingService {

	/**
	 * Find ordered item for the current login user.
	 *
	 * @param userAccountId
	 * @return
	 */
	public List<OrderedItem> findOrderedItemForUser(long userAccountId);
}
