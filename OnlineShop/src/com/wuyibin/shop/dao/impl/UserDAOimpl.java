package com.wuyibin.shop.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuyibin.shop.model.User;

public class UserDAOimpl extends HibernateDaoSupport implements com.wuyibin.shop.dao.UserDAO {

	@Override
	public void register(User user) {
		getSession().save(user);
		
	}

	@Override
	public User getUser(User user) {
		if(user!=null){
			if(user.getAccount()!=null&user.getPassword()!=null){
				String hql="from User where account=? and password=?";
				return (User)getSession().createQuery(hql).setString(0, user.getAccount()).setString(1, user.getPassword()).uniqueResult();
			}else{
				String hql="from User where account=?";
				return (User)getSession().createQuery(hql).setString(0, user.getAccount()).uniqueResult();
			}
		}
		return null;
	}
}
