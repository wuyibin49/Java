package com.wuyibin.shop.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuyibin.shop.dao.OrderDAO;
import com.wuyibin.shop.model.Orders;

public class OrderDAOimpl extends HibernateDaoSupport implements OrderDAO {

	@Override
	public void addOrder(Orders order) {
		getSession().save(order);		
	}

	@Override
	public void deleteOrder(Orders order) {
		getSession().delete(order);
		
	}

	@Override
	public Orders getOrderById(Class clazz, Serializable id) {
		return (Orders)getSession().load(clazz, id);
	}

	@Override
	public void updateOrder(Orders order) {
		getSession().update(order);
		
	}

}
