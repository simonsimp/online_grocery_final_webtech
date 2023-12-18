package com.simon.OnlineGroceryStoreManagementsystem.dao;


import com.simon.OnlineGroceryStoreManagementsystem.model.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);

	public Role save(Role role);
}
