package com.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.bean.Risk;

public interface BaseRiskDao {
	
	public List<Risk> queryRisks();//�����б�
	public List<Risk> queryRisks(String id);//�����б�

	public void saveRisk(Risk obj) throws HibernateException;//��ӷ���
	
	public Risk findRisk(int id);//���ҷ���

	public void deleteRisk(int id);//ɾ������
	
	public void updateRisk(Risk risk);//���·���

	public void distributeRisk(Risk risk);

	public void solveRisk(Risk risk);
	
}
