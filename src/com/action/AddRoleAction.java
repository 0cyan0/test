package com.action;

import org.apache.struts2.ServletActionContext;

import com.bean.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleManager;

//管理员添加书籍的action
public class AddRoleAction extends ActionSupport {

	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	private RoleManager roleManager;

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}
	
	public  String execute(){
    	String name=ServletActionContext.getRequest().getParameter("rolename");
    	String id=ServletActionContext.getRequest().getParameter("login_id");
    	String pw=ServletActionContext.getRequest().getParameter("password");
    	int type=Integer.parseInt(ServletActionContext.getRequest().getParameter("type"));
    	//int type=Integer.parseInt(ServletActionContext.getRequest().getParameter("type"));
    	
    	role=new Role();
    	
    	role.setRolename(name);
    	role.setLogin_id(id);
    	role.setPassword(pw);
    	role.setType(type);
    	
		try{
			roleManager.addRole(role);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

}
