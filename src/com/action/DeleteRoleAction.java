package com.action;

import org.apache.struts2.ServletActionContext;

import com.bean.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleManager;

//管理员添加书籍的action
public class DeleteRoleAction extends ActionSupport {

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
    	int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
    	//int type=Integer.parseInt(ServletActionContext.getRequest().getParameter("type"));
    
    	
		try{
			roleManager.deleteRole(id);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

}
