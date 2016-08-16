package com.wuyibin.shop.service.impl;

import java.util.List;

import com.wuyibin.shop.dao.OrderDAO;
import com.wuyibin.shop.model.Goods;
import com.wuyibin.shop.model.Orders;
import com.wuyibin.shop.service.OrderService;

public class OrderServiceimpl implements OrderService{
	private OrderDAO orderdao;
	
	public OrderDAO getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(OrderDAO orderdao) {
		this.orderdao = orderdao;
	}

	@Override
	public void addOrder(Orders order) {
		orderdao.addOrder(order);
		
	}

	@Override
	public void deleteorder(Orders order) {
		Orders ord=orderdao.getOrderById(order.getClass(), order.getId());
		orderdao.deleteOrder(ord);
	}

	@Override
	public void updateOrder(Orders order) {
		Orders or=orderdao.getOrderById(order.getClass(), order.getId());
		or.setAddress(order.getAddress());
		or.setTelephone(order.getTelephone());
		or.setGoodslist(order.getGoodslist());
//		List<Goods>uplist=order.getGoodslist();
//		List<Goods> list=or.getGoodslist();
//		for(Goods go:list){
//			for(Goods upgo:uplist){
//				if(go.getId()==upgo.getId()){
//					go.setAmout(upgo.getAmout());
//				}
//				
//			}
//		}
		orderdao.updateOrder(or);
	}

}
