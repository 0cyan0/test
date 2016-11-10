package com.service;

import java.util.List;

import com.bean.Role;

public interface RoleManager {

	public List<Role> queryRoles() throws Exception;//��ѯ���н�ɫ
	public Role findRole(int id);//���ҽ�ɫ
	public void addRole(Role role);//��ӽ�ɫ
	public void deleteRole(int id);//ɾ����ɫ
	public void updateRole(Role role) throws Exception;//���½�ɫ
	public int logUser(String username, String password) throws Exception;//�û���¼У��
}
