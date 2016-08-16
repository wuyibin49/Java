package com.wuyibin.shop.model;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCar {
	//订单列表
	private List<Goods> goodslist = new LinkedList<Goods>();
	//购物车总价
	private int sumprice;
	//商品数量
	private int numbers;

	public List<Goods> getGoodslist() {
		return goodslist;
	}
	public void setGoodslist(List<Goods> goodslist) {
		this.goodslist = goodslist;
	}
	public int getSumprice() {
		sumprice=0;
		for(Goods go:goodslist){
			sumprice=sumprice+(Integer.parseInt(go.getPrice()))*(Integer.parseInt(go.getAmout()));
		}		
		return sumprice;
	}
	public void setSumprice(int sumprice) {
		this.sumprice = sumprice;
	}
	public int getNumbers() {
		numbers=0;
		if(goodslist!=null){
			for(Goods go:goodslist){
				numbers=numbers+Integer.parseInt(go.getAmout());
			}
		}
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	
}
