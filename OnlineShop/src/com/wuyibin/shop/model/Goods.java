package com.wuyibin.shop.model;

public class Goods {
	private int id;
	//商品名称
	private String name;
	//商品价格
	private String price;
	//商品数量
	private String amout;
	//商品类型
	private String type;
	//版本控制
	private int version;

	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmout() {
		return amout;
	}
	public void setAmout(String amout) {
		this.amout = amout;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		
		return "good:name="+this.name+",price="+this.price+",type="+this.type+",amount"+this.amout;
	}
	

}
