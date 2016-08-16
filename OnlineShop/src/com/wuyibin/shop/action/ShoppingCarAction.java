package com.wuyibin.shop.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.Goods;
import com.wuyibin.shop.model.Orders;
import com.wuyibin.shop.model.ShoppingCar;
import com.wuyibin.shop.model.User;
import com.wuyibin.shop.service.OrderService;

public class ShoppingCarAction extends ActionSupport {
	private Goods good;
	private Orders order;
	private OrderService orderservice;
	
	
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public OrderService getOrderservice() {
		return orderservice;
	}
	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}
	public String addorder(){
		orderservice.addOrder(order);
		return "addorder";
	}
	public String deleteorder(){
		orderservice.deleteorder(order);
		return "deleteorder";
	}
	//更新购物车商品数量
	public String updategood(){
		User us=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		ShoppingCar sc=us.getShoppingcar();
		List<Goods> list=sc.getGoodslist();
		for(Goods go:list){
			if(go.getId()==good.getId()){
				go.setAmout(good.getAmout());
			}			
		}
		sc.setGoodslist(list);
		us.setShoppingcar(sc);
		
		ServletActionContext.getRequest().setAttribute("goodlist", list);
		ServletActionContext.getRequest().getSession().setAttribute("user", us);
		ServletActionContext.getRequest().getSession().setAttribute("caritem", us.getShoppingcar().getNumbers());
		return "updategood";
	}
	//查看购物车
	public String getgoodfromcar(){
		System.out.println("查看购物车中的商品");
		HttpSession session = ServletActionContext.getRequest().getSession();
		User us=(User)session.getAttribute("user");
		ShoppingCar sc=us.getShoppingcar();
		List<Goods> list=sc.getGoodslist();
		ServletActionContext.getRequest().setAttribute("goodlist", list);
		ServletActionContext.getRequest().setAttribute("tatolprice", sc.getSumprice());
		System.out.println("goodlist="+list);
		return "getgoods";
	}
}
