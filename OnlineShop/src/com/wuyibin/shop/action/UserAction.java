package com.wuyibin.shop.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.ShoppingCar;
import com.wuyibin.shop.model.User;
import com.wuyibin.shop.service.UserService;

public class UserAction extends ActionSupport {
	private User user;
	private UserService userservice;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	//�û�ע����֤
	public String checkreg() throws Exception{
		System.out.println("�û���¼��֤");
		//System.out.println(user);
		User us=userservice.getUser(user);
	//	System.out.println("us="+us);
		if(us!=null){
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			PrintWriter out=ServletActionContext.getResponse().getWriter();
			out.print("�û����Ѵ��ڣ�����������");
		}
		return null;
	}
//�û�ע��
	public String register() throws Exception{
		//HttpSession session=ServletActionContext.getRequest().getSession();
		//User us=userservice.getUser(user);
		if(user!=null){
			userservice.register(user);
			return SUCCESS;
		}else
			return null;
		
	}
	
//�û���¼
	public String login(){
		User us=userservice.getUser(user);
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(us!=null&&us.getAccount().equals(user.getAccount())&&us.getPassword().equals(user.getPassword())){
			us.setShoppingcar(new ShoppingCar());
			session.setAttribute("user", us);
			session.setAttribute("caritem", us.getShoppingcar().getNumbers());
			return "login";
		}else{
			session.setAttribute("info", "�û���¼ʧ��");
			return "loginfailed";
		}
	}
	
	
	
}
