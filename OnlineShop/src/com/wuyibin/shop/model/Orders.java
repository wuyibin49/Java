package com.wuyibin.shop.model;

import java.util.LinkedList;
import java.util.List;

public class Orders {
	private int id;
	//订单编号
	private int orderNo;
	//收货地址
	private String address;
	//联系电话
	private String telephone;
	//商品信息
	private List<Goods> goodslist=new LinkedList<Goods>();
	//用户信息
	private User user;
	//版本控制
	private int version;
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Goods> getGoodslist() {
		return goodslist;
	}
	public void setGoodslist(List<Goods> goodslist) {
		this.goodslist = goodslist;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
