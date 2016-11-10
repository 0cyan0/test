package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoleManager;

public class AllRolesAction extends ActionSupport{
	
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

	public String execute(){
		
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			List<Role> role=roleManager.queryRoles();
			//request.setAttribute("allStore", store);
			//request.setAttribute("allWaiter", waiter);
        	ServletActionContext.getRequest().getSession().setAttribute("allRole", role);
			if(role!=null && role.size()!=0){
				return "success";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
		
	}

}
