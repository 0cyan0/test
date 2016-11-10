package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Role;
import com.dao.BaseRoleDao;

import sun.net.www.content.text.plain;

//书籍dao接口实现类
public class RoleDao extends HibernateDaoSupport implements BaseRoleDao{

	@Override
	public List<Role> queryRoles() {
		return this.getHibernateTemplate().find("from Role");
	}

	@Override
	public void saveRole(Role role) throws HibernateException {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(role);
	}

	@Override
	public Role findRole(String rolename, String password) {
		String hql = "from Role as role where role.login_id=? and role.password=?";
		List roleList = getHibernateTemplate().find(hql, new String[] { rolename, password });
		if (roleList != null && roleList.size() >= 1) {
			return (Role) roleList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void deleteRole(int id) {
		String hql = "from Role where id=?";
		List planList = getHibernateTemplate().find(hql,id);
		if (planList != null && planList.size() >= 1) {
			Role s=(Role) planList.get(0);
			getHibernateTemplate().delete(s);
			
		} else {
		}	
	}

	@Override
	public void updateRole(Role role) {
		String hql = "from Role where id=?";
		List pList = getHibernateTemplate().find(hql,role.getId());
		if (pList != null && pList.size() >= 1) {
			
			Role s=(Role) pList.get(0);
			s=role;
			getHibernateTemplate().update(s);
			
		} else {
		}	
	}

	

}
