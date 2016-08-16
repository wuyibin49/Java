package com.wuyibin.shop.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wuyibin.shop.model.Goods;
import com.wuyibin.shop.model.ShoppingCar;
import com.wuyibin.shop.model.User;
import com.wuyibin.shop.service.GoodService;
/**
 * * <p>Title:GoodAction </p>
* <p>Description: </p>
* <p>Company: </p> 
* @author 吴亦斌
* @date 2016-8-5 下午5:06:30
 */
public class GoodAction extends ActionSupport {
	private GoodService goodservice;
	private Goods good;
	
	public Goods getGood() {
		return good;
	}
	public void setGoodservice(GoodService goodservice) {
		this.goodservice = goodservice;
	}
	public void setGood(Goods good) {
		this.good = good;
	}

	//查询商品
	public String searchgood(){
		System.out.println("查询商品");
		System.out.println(good==null);
		List<Goods>list= goodservice.searchGoods(good);
		ServletActionContext.getRequest().setAttribute("goodslist",list);
		return "searchgood";
	}
	
//添加商品到购物车
	public void addgoodtocar() throws Exception{
		System.out.println("添加商品到购物车");
		HttpSession session=ServletActionContext.getRequest().getSession();
		User us=(User)session.getAttribute("user");
		ShoppingCar sc=us.getShoppingcar();
		Goods go=goodservice.getsingleGood(good.getClass(), good.getId());		
		List<Goods> goodlist=sc.getGoodslist();
		System.out.println(goodlist==null);
		go.setAmout(good.getAmout());
		goodlist.add(go);
		sc.setGoodslist(goodlist);
		us.setShoppingcar(sc);
		
		session.setAttribute("user", us);
		session.setAttribute("caritem", us.getShoppingcar().getNumbers());
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print("添加商品成功");
		//return "addgood";
	}
	//从购物车中删除商品
	public String deletegoodfromcar(){
		System.out.println("删除购物车中的商品");
		HttpSession session =ServletActionContext.getRequest().getSession();
		User us=(User)session.getAttribute("user");
		ShoppingCar sc=us.getShoppingcar();
		List<Goods> list=sc.getGoodslist();
		for(Goods go:list){
			if(go.getId()==good.getId()){
				list.remove(go);
				break;
			}
		}
		session.setAttribute("caritem", us.getShoppingcar().getNumbers());
		return "deletegood";		
	}
//查询单个商品
	public String getsinglegood() throws Exception{
		Goods go=goodservice.getsingleGood(good.getClass(), good.getId());
		System.out.println(go);
		JSONObject jo=JSONObject.fromObject(go);
		String result=jo.toString();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.print(result);
		//out.flush();
		//out.close();
		System.out.println("json"+result);
		request.setAttribute("goods", go);
		return "gooddetail";
	}
	public String getsingle() throws Exception{
		Goods go=goodservice.getsingleGood(good.getClass(), good.getId());
		System.out.println(go);
		JSONObject jo=JSONObject.fromObject(go);
		String result=jo.toString();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.print(result);
		//out.flush();
		//out.close();
		System.out.println("json"+result);
		request.setAttribute("goods", go);
		return null;
	}
//显示所有商品
	public String getallgoods(){
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Goods> list=goodservice.getallGoods();
		request.setAttribute("goods", list);
		return "goodsdisplay";
	}
}
