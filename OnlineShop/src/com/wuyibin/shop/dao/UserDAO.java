package com.wuyibin.shop.dao;

import com.wuyibin.shop.model.User;

public interface UserDAO {
	//�û�ע��
	public void register(User user);
	//�û���¼
	public User getUser(User user);

}
