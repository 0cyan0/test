package com.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.bean.Role;
import com.dao.BaseRoleDao;
import com.service.RoleManager;

public class RoleManagerImpl implements RoleManager {

	private BaseRoleDao dao;
	public void setDao(BaseRoleDao dao) {
		this.dao = dao;
	}

	@Override
	public int logUser(String rolename, String password) throws Exception {

		try{
			Role role=dao.findRole(rolename, password);
			
			//判断是否管理员
			if(role!=null&&role.getType()==0){
				return 0;
			}
			if(role!=null&&role.getType()==1){
				return 1;
			}
			if(role!=null&&role.getType()==2){
				return 2;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("验证用户登录时出现错误");
		}		
		return -1;
	
	}
	
	@Override
	public List<Role> queryRoles() throws Exception {
		return dao.queryRoles();
	}

	@Override
	public Role findRole(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRole(Role role) {
		try {
			dao.saveRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRole(int id) {
		dao.deleteRole(id);
	}

	@Override
	public void updateRole(Role role) throws Exception {
		try{
			dao.updateRole(role);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("获取会员信息时出现错误");
		}	
		
	}

}
