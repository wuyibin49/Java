package com.wuyibin.shop.dao;

import java.io.Serializable;
import java.util.List;

import com.wuyibin.shop.model.Goods;

public interface GoodDAO {
	public Goods getsingleGood(Class clazz,Serializable id);
	public List<Goods> searchGoods(Goods good);
	public void addGood(Goods good);
	public List<Goods> getallGoods();
	public void addgoodtocar(Goods good);
	
}
