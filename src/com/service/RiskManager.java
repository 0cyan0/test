package com.service;

import java.util.List;

import com.bean.Risk;

public interface RiskManager {
	
	public List<Risk> queryRisks(String login_id) throws Exception;//��ѯ���з���
	public List<Risk> queryRisks() throws Exception;//��ѯ���з���
	public Risk findRisk(int id);//���ҷ���
	public void addRisk(Risk risk);//��ӷ���
	public void deleteRisk(int id);//ɾ������
	public void updateRisk(Risk role) throws Exception;//���·���
	public void distributeRisk(Risk risk) throws Exception;
	public void solveRisk(Risk risk) throws Exception;

}
