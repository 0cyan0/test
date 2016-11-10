package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Risk;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RiskManager;

public class AllRisksAction extends ActionSupport{
	
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
			List<Risk> risk=riskManager.queryRisks();
			//request.setAttribute("allStore", store);
			//request.setAttribute("allWaiter", waiter);
        	ServletActionContext.getRequest().getSession().setAttribute("allRisk", risk);
			if(risk!=null && risk.size()!=0){
				return "success";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
		
	}

}
