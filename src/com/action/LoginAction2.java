package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleManager;

//µÇÂ¼action
public class LoginAction2 extends ActionSupport{
	private Role role;
	
	private RoleManager roleManager;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}
	

	
    public String execute() throws Exception{	
    	//ServletActionContext.getRequest().getSession().putValue("username", role.getLogin_id());
		String username=ServletActionContext.getRequest().getParameter("login_id");
    	String pw=ServletActionContext.getRequest().getParameter("password");
    	//int login=userManager.logUser(username, pw);
    	//System.out.println(role.getLogin_id());
    	//System.out.println(role.getPassword());
    	//ServletActionContext.getRequest().getSession().setAttribute("role_id", role.getLogin_id());
    	ServletActionContext.getRequest().getSession().setAttribute("role_id", username);
    	//int login=roleManager.logUser(role.getLogin_id(),role.getPassword());
    	int login=roleManager.logUser(username,pw);
    	if(login==0){ 
    		return "admin";		
    	}
    	if(login==1){
    		return "manager2";
    	}
    	if(login==2){
    		return "staff";
    	}
    	else{
    		return "error";
    	}
    	
    }
}
