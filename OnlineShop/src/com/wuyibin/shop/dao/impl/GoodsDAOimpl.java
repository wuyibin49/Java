package com.wuyibin.shop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuyibin.shop.dao.GoodDAO;
import com.wuyibin.shop.model.Goods;

public class GoodsDAOimpl extends HibernateDaoSupport implements GoodDAO {

	@Override
	public Goods getsingleGood(Class clazz, Serializable id) {
		//return (Goods)getSession().load(clazz, id);
		return (Goods)getSession().get(clazz, id);
	}

	@Override
	public List<Goods> searchGoods(Goods good) {
		String hql="from Goods g where 1=1";
		if(good!=null){
			if(good.getName()!=null&&!"".equals(good.getName())){
				hql=hql+" and g.name like '%"+good.getName()+"%'";
			}
			if(good.getType()!=null&&!"".equals(good.getType())){
				hql=hql+" and g.type like '%"+good.getType()+"%'";
			}
		}
		List<Goods> list=getSession().createQuery(hql).list();
		return list;
		
	}

	@Override
	public void addGood(Goods good) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Goods> getallGoods() {
		return getSession().createQuery("from Goods").list();
		
	}

	/* (non-Javadoc)
	 * @see com.wuyibin.shop.dao.GoodDAO#addgoodtocar(com.wuyibin.shop.model.Goods)
	 */
	@Override
	public void addgoodtocar(Goods good) {
		// TODO Auto-generated method stub
		
	}

}
