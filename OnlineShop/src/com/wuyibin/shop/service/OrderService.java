package com.wuyibin.shop.service;

import com.wuyibin.shop.model.Orders;

public interface OrderService {
	//��Ӷ���
	public void addOrder(Orders order);
	//ɾ������
	public void deleteorder(Orders order);
	//�޸Ķ���
	public void updateOrder(Orders order);
}
