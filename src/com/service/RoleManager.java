package com.service;

import java.util.List;

import com.bean.Role;

public interface RoleManager {

	public List<Role> queryRoles() throws Exception;//查询所有角色
	public Role findRole(int id);//查找角色
	public void addRole(Role role);//添加角色
	public void deleteRole(int id);//删除角色
	public void updateRole(Role role) throws Exception;//更新角色
	public int logUser(String username, String password) throws Exception;//用户登录校验
}
