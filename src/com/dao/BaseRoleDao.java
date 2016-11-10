package com.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.bean.Role;

public interface BaseRoleDao {

	public List<Role> queryRoles();//��ɫ�б�
	
	public void saveRole(Role obj) throws HibernateException;//��ӽ�ɫ
	
	public Role findRole(String rolename, String password);//���ҽ�ɫ

	public void deleteRole(int id);//ɾ����ɫ
	
	public void updateRole(Role role);//���½�ɫ

}
