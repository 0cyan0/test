package com.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.bean.Risk;

public interface BaseRiskDao {
	
	public List<Risk> queryRisks();//风险列表
	public List<Risk> queryRisks(String id);//风险列表

	public void saveRisk(Risk obj) throws HibernateException;//添加风险
	
	public Risk findRisk(int id);//查找风险

	public void deleteRisk(int id);//删除风险
	
	public void updateRisk(Risk risk);//更新风险

	public void distributeRisk(Risk risk);

	public void solveRisk(Risk risk);
	
}
