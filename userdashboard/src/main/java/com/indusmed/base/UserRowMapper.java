package com.indusmed.base;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<DashboardUser>{

	public DashboardUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		if(rs == null || !rs.next()){
			return null;
		}
		DashboardUser user = new DashboardUser();
		user.setDateOfBirth(rs.getDate(Constants.DASHBOARD_USER_DATE_OF_BIRTH));
		user.setFirstName(rs.getString(Constants.DASHBOARD_USER_FIRST_NAME));
		user.setMiddleName(rs.getString(Constants.DASHBOARD_USER_MIDDLE_NAME));
		user.setLastName(rs.getString(Constants.DASHBOARD_USER_LAST_NAME));
		user.setImage(rs.getString(Constants.DASHBOARD_USER_IMAGE));
		user.setEmailId(rs.getString(Constants.DASHBOARD_USER_EMAIL));
		user.setRole(rs.getString(Constants.DASHBOARD_USER_ROLE));
		user.setPassword(rs.getString(Constants.DASHBOARD_USER_PASSWORD));
		user.setUserName(rs.getString(Constants.DASHBOARD_USER_USERNAME));
		return user;
	}
}
