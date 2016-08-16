package com.wuyibin.shop.dao;

import java.io.Serializable;

import com.wuyibin.shop.model.Orders;

public interface OrderDAO {
	//添加订单
	public void addOrder(Orders order);
	//删除订单
	public void deleteOrder(Orders order);
	//通过id查询订单
	public Orders getOrderById(Class clazz,Serializable id);
	//修改订单
	public void updateOrder(Orders order);

}
