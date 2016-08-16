package com.wuyibin.shop.dao;

import java.io.Serializable;

import com.wuyibin.shop.model.Orders;

public interface OrderDAO {
	//��Ӷ���
	public void addOrder(Orders order);
	//ɾ������
	public void deleteOrder(Orders order);
	//ͨ��id��ѯ����
	public Orders getOrderById(Class clazz,Serializable id);
	//�޸Ķ���
	public void updateOrder(Orders order);

}
