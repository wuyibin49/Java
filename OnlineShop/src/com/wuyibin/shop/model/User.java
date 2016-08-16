package com.wuyibin.shop.model;

public class User {
	private int id;
	private String account;
	private String password;
	private String email;
	private String pic;
	private ShoppingCar shoppingcar =new ShoppingCar();
	
	public ShoppingCar getShoppingcar() {
		return shoppingcar;
	}
	public void setShoppingcar(ShoppingCar shoppingcar) {
		this.shoppingcar = shoppingcar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "”√ªß «"+this.account;
	}
	
}
