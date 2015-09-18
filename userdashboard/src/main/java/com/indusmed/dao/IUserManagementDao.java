package com.indusmed.dao;

import com.indusmed.base.AddNewUserRequest;
import com.indusmed.base.DashboardUser;
import com.indusmed.base.LoginRequest;

public interface IUserManagementDao {
	public int addNewUser(AddNewUserRequest request);
	public DashboardUser getDashboardUser(LoginRequest request);
}
