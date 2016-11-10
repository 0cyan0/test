package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Risk;
import com.bean.Role;
import com.dao.BaseRiskDao;

import sun.net.www.content.text.plain;

//书籍dao接口实现类
public class RiskDao extends HibernateDaoSupport implements BaseRiskDao{

	@Override
	public List<Risk> queryRisks() {
		return this.getHibernateTemplate().find("from Risk");
	}
	
	@Override
	public List<Risk> queryRisks(String id) {
		String hql = "from Role where login_id=?";
		List planList = getHibernateTemplate().find(hql,id);
			Role r=(Role) planList.get(0);
			int cid=r.getId();
			String hql2 = "from Risk where tracker_id=?";
			List planList2 = getHibernateTemplate().find(hql2,cid);
			return planList2;
	}

	@Override
	public void saveRisk(Risk risk) throws HibernateException {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(risk);
	}

	@Override
	public Risk findRisk(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRisk(int id) {
		String hql = "from Risk where id=?";
		List planList = getHibernateTemplate().find(hql,id);
		if (planList != null && planList.size() >= 1) {
			Risk s=(Risk) planList.get(0);
			getHibernateTemplate().delete(s);
			
		} else {
		}	
	}

	@Override
	public void updateRisk(Risk risk) {
		String hql = "from Risk where id=?";
		List pList = getHibernateTemplate().find(hql,risk.getId());
		if (pList != null && pList.size() >= 1) {
			
			Risk s=(Risk) pList.get(0);
			s=risk;
			getHibernateTemplate().update(s);
			
		} else {
		}	
	}

	@Override
	public void distributeRisk(Risk risk) {
		String hql = "from Risk where id=?";
		List pList = getHibernateTemplate().find(hql,risk.getId());
		if (pList != null && pList.size() >= 1) {
			
			Risk s=(Risk) pList.get(0);
			s.setId(risk.getId());
			s.setTracker_id(risk.getTracker_id());
			getHibernateTemplate().update(s);
			
		} else {
		}	
	}

	@Override
	public void solveRisk(Risk risk) {
		String hql = "from Risk where id=?";
		List pList = getHibernateTemplate().find(hql,risk.getId());
		if (pList != null && pList.size() >= 1) {
			
			Risk s=(Risk) pList.get(0);
			s.setId(risk.getId());
			s.setState(risk.getState());
			s.setDescription(risk.getDescription());
			getHibernateTemplate().update(s);
			
		} else {
		}	
		
	}


}
