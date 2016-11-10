package com.action;

import org.apache.struts2.ServletActionContext;

import com.bean.Risk;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RiskManager;

//管理员添加书籍的action
public class DistributeRiskAction extends ActionSupport {

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
    	int tracker_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("tracker_id"));
    	//int type=Integer.parseInt(ServletActionContext.getRequest().getParameter("type"));
    	

    	risk=new Risk();
    	
    	risk.setId(id);
    	risk.setTracker_id(tracker_id);
    	
		try{
			riskManager.distributeRisk(risk);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

}
