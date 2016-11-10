package com.service.impl;

import java.util.List;

import com.bean.Risk;
import com.dao.BaseRiskDao;
import com.service.RiskManager;

public class RiskManagerImpl implements RiskManager{
	
	private BaseRiskDao dao;
	public void setDao(BaseRiskDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Risk> queryRisks() throws Exception {
		return dao.queryRisks();
	}
	
	@Override
	public List<Risk> queryRisks(String login_id) throws Exception {
		return dao.queryRisks(login_id);
	}

	@Override
	public Risk findRisk(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRisk(Risk risk) {
		try {
			dao.saveRisk(risk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRisk(int id) {
		dao.deleteRisk(id);
	}

	@Override
	public void updateRisk(Risk risk) throws Exception {
		try{
			dao.updateRisk(risk);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("获取会员信息时出现错误");
		}	
	}

	@Override
	public void distributeRisk(Risk risk) throws Exception {
		try{
			dao.distributeRisk(risk);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("获取会员信息时出现错误");
		}	
		
	}

	@Override
	public void solveRisk(Risk risk) throws Exception {
		try{
			dao.solveRisk(risk);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("获取会员信息时出现错误");
		}	
	}

}
