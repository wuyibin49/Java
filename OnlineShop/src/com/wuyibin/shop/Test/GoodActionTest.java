/**
 * 
 */
package com.wuyibin.shop.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wuyibin.shop.action.GoodAction;
import com.wuyibin.shop.dao.GoodDAO;
import com.wuyibin.shop.dao.impl.GoodsDAOimpl;
import com.wuyibin.shop.model.Goods;
import com.wuyibin.shop.service.GoodService;
import com.wuyibin.shop.service.impl.GoodServceimpl;

/*** <p>Title:GoodActionTest </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author Œ‚“‡±Û
 * @date 2016-8-5 œ¬ŒÁ11:24:33
 */
public class GoodActionTest {

	@Test
	public void test() {
		Goods good=new Goods();
		GoodService gs=new GoodServceimpl();
		GoodDAO gd=new GoodsDAOimpl();
	//	good=gs.getsingleGood(good.getClass(), 1);
		good=gd.getsingleGood(good.getClass(), 1);
		System.out.println(good);
		
	}

}
