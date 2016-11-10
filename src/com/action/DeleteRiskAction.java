package com.action;

import org.apache.struts2.ServletActionContext;

import com.bean.Risk;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RiskManager;

//����Ա����鼮��action
public class DeleteRiskAction extends ActionSupport {

	private Risk risk;

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}
	
	private RiskManager riskManager;

	public void setRiskManager(RiskManager riskManager) {
		this.riskManager = riskManager;
	}
	
	public  String execute(){
    	int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
    	//int type=Integer.parseInt(ServletActionContext.getRequest().getParameter("type"));
    
    	
		try{
			riskManager.deleteRisk(id);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

}
