package com.indusmed.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.indusmed.base.AddNewUserRequest;
import com.indusmed.base.DashboardUser;
import com.indusmed.base.LoginRequest;
import com.indusmed.base.UserRowMapper;

public class UserManagementDaoImpl extends JdbcDaoSupport implements IUserManagementDao {

	public int addNewUser(AddNewUserRequest request) {
		String sql = "";
		int result = getJdbcTemplate().update(sql, new Object[] {});
		return result;
	}

	public DashboardUser getDashboardUser(LoginRequest request) {
		String sql = "select * from dashboard_users where username ='" + request.getUserName() + "'";
		List<DashboardUser> users = getJdbcTemplate().query(sql, new UserRowMapper());

		if (users != null && users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
