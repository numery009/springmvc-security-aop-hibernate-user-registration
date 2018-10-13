package com.springdemo.dao;

import com.springdemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
