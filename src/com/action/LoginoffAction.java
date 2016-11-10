package com.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//×¢ÏúµÇÂ¼µÄaction
public class LoginoffAction extends ActionSupport{
	
	@SuppressWarnings("deprecation")
	public String execute() throws Exception{
		
		HttpSession session=ServletActionContext.getRequest().getSession(false);
		/*@SuppressWarnings("unchecked")
		Map<Integer, Cart> carts =  (Map<Integer, Cart>) session.getAttribute("cart");
		if(carts!=null){
		carts.clear();
		}*/
		session.removeValue("username");
		session.removeAttribute("cart");
		session.removeAttribute("all");
		session.removeAttribute("sum");
		session.removeAttribute("rmb");
		return super.execute();
				
	}

}
