package com.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.bean.Role;

public interface BaseRoleDao {

	public List<Role> queryRoles();//角色列表
	
	public void saveRole(Role obj) throws HibernateException;//添加角色
	
	public Role findRole(String rolename, String password);//查找角色

	public void deleteRole(int id);//删除角色
	
	public void updateRole(Role role);//更新角色

}
