package com.wuyibin.shop.service.impl;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.dao.GoodDAO;
import com.wuyibin.shop.model.Goods;
import com.wuyibin.shop.service.GoodService;

public class GoodServceimpl implements GoodService {
	private GoodDAO gooddao;
	
	public void setGooddao(GoodDAO gooddao) {
		this.gooddao = gooddao;
	}

	@Override
	public Goods getsingleGood(Class clazz, Serializable id) {
		return gooddao.getsingleGood(clazz, id);		
	}

	public GoodDAO getGooddao() {
		return gooddao;
	}

	@Override
	public List<Goods> searchGoods(Goods good) {
		
		return gooddao.searchGoods(good);
	}

	@Override
	public void addGood(Goods good) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Goods> getallGoods() {
		return gooddao.getallGoods();
	}
}
