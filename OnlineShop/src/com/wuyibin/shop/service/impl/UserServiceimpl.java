package com.wuyibin.shop.service.impl;

import com.wuyibin.shop.dao.UserDAO;
import com.wuyibin.shop.model.User;
import com.wuyibin.shop.service.UserService;

public class UserServiceimpl implements UserService {
	private UserDAO userdao;
	
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	@Override
	public void register(User user) {
		userdao.register(user);
		
	}

	@Override
	public User getUser(User user) {
		 return userdao.getUser(user);
		
	}

}
