package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Risk;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RiskManager;

public class StaffRisksAction extends ActionSupport{
	
	private Risk risk;
	
	private RiskManager riskManager;
	
	public Risk getRisk() {
		return risk;
	}
	
	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public void setRiskManager(RiskManager riskManager) {
		this.riskManager = riskManager;
	}

	public String execute(){
		
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
        	String staff_id=(String) ServletActionContext.getRequest().getSession().getAttribute("role_id");
			List<Risk> risk=riskManager.queryRisks(staff_id);
			//request.setAttribute("allStore", store);
			//request.setAttribute("allWaiter", waiter);
        	ServletActionContext.getRequest().getSession().setAttribute("staffRisk", risk);
			if(risk!=null){
				return "success";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
		
	}

}
