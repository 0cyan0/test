package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//检查购物车是否为空的action
public class CheckcartAction extends ActionSupport {
	
	public String execute(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("sum")==null){
			return ERROR;
		}
		return SUCCESS;
		
	}

}
