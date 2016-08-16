package com.wuyibin.shop.service;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.model.Goods;

public interface GoodService {
	public Goods getsingleGood(Class clazz,Serializable id);
	public List<Goods> searchGoods(Goods good);
	public void addGood(Goods good);
	public List<Goods> getallGoods();
}
