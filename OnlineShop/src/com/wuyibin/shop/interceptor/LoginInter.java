/**
 * 
 */
package com.wuyibin.shop.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wuyibin.shop.action.UserAction;
import com.wuyibin.shop.model.User;

/*** <p>Title:LoginInter </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author Œ‚“‡±Û
 * @date 2016-8-11 œ¬ŒÁ9:24:49
 */
public class LoginInter extends AbstractInterceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		if(UserAction.class==invocation.getAction().getClass()){
			return  invocation.invoke();
		}else if(ServletActionContext.getRequest().getSession().getAttribute("user")!=null){			
			return  invocation.invoke();			
		}else{
			return "login";
		}
		
	}

}
