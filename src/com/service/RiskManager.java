package com.service;

import java.util.List;

import com.bean.Risk;

public interface RiskManager {
	
	public List<Risk> queryRisks(String login_id) throws Exception;//查询所有风险
	public List<Risk> queryRisks() throws Exception;//查询所有风险
	public Risk findRisk(int id);//查找风险
	public void addRisk(Risk risk);//添加风险
	public void deleteRisk(int id);//删除风险
	public void updateRisk(Risk role) throws Exception;//更新风险
	public void distributeRisk(Risk risk) throws Exception;
	public void solveRisk(Risk risk) throws Exception;

}
