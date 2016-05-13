package com.indusmed.dao;

import com.indusmed.base.DashboardUser;
import com.indusmed.request.AddNewUserRequest;
import com.indusmed.request.LoginRequest;

public interface IUserManagementDao {
	public int addNewUser(AddNewUserRequest request);
	public DashboardUser getDashboardUser(LoginRequest request);
}
