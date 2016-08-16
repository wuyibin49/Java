package com.wuyibin.shop.action;

import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.Goods;
import com.wuyibin.shop.model.Orders;
import com.wuyibin.shop.model.ShoppingCar;
import com.wuyibin.shop.model.User;
import com.wuyibin.shop.service.OrderService;

public class OrderAction extends ActionSupport{
	private Orders order;
	private OrderService orderservice;
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}
	public String addOrder() throws Exception{
		System.out.println("ÃÌº”∂©µ•");
		Orders or=new Orders();
		User us=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		ShoppingCar sc=us.getShoppingcar();
		List<Goods> list=sc.getGoodslist();
		or.setGoodslist(list);
		or.setAddress("œ√√≈");
		or.setTelephone("56344");
		or.setUser(us);
		orderservice.addOrder(or);
		list.removeAll(list);
		sc.setGoodslist(list);

		return "addorder";
	}
	public String updateOrder(){
		orderservice.updateOrder(order);
		return "updateorder";
	}
	

	
	
	
	
	
	
	
	
	
	
}
