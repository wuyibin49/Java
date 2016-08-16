package com.wuyibin.shop.dao;

import com.wuyibin.shop.model.User;

public interface UserDAO {
	//用户注册
	public void register(User user);
	//用户登录
	public User getUser(User user);

}
