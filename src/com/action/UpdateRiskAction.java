package com.action;

import org.apache.struts2.ServletActionContext;

import com.bean.Risk;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RiskManager;

//管理员添加书籍的action
public class UpdateRiskAction extends ActionSupport {

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
    	String name=ServletActionContext.getRequest().getParameter("name");
    	int possibility=Integer.parseInt(ServletActionContext.getRequest().getParameter("possibility"));
    	int influenceDegree=Integer.parseInt(ServletActionContext.getRequest().getParameter("influenceDegree"));
    	int triggerOrThreshold=Integer.parseInt(ServletActionContext.getRequest().getParameter("triggerOrThreshold"));
    	int committer_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("committer_id"));
    	int tracker_id=Integer.parseInt(ServletActionContext.getRequest().getParameter("tracker_id"));
    	int state=Integer.parseInt(ServletActionContext.getRequest().getParameter("state"));
    	String description=ServletActionContext.getRequest().getParameter("description");
    	//int type=Integer.parseInt(ServletActionContext.getRequest().getParameter("type"));
    	

    	risk=new Risk();
    	
    	risk.setId(id);
    	risk.setName(name);
    	risk.setPossibility(possibility);
    	risk.setInfluenceDegree(influenceDegree);
    	risk.setTriggerOrThreshold(triggerOrThreshold);
    	risk.setCommitter_id(committer_id);
    	risk.setTracker_id(tracker_id);
    	risk.setState(state);
    	risk.setDescription(description);
    	
		try{
			riskManager.updateRisk(risk);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

}
