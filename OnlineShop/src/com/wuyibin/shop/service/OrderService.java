package com.wuyibin.shop.service;

import com.wuyibin.shop.model.Orders;

public interface OrderService {
	//Ìí¼Ó¶©µ¥
	public void addOrder(Orders order);
	//É¾³ý¶©µ¥
	public void deleteorder(Orders order);
	//ÐÞ¸Ä¶©µ¥
	public void updateOrder(Orders order);
}
