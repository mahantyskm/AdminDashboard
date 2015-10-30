package com.indusmed.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.indusmed.base.Constants;
import com.indusmed.base.DashboardUser;

public class UserRowMapper implements RowMapper<DashboardUser>{

	public DashboardUser mapRow(ResultSet rs, int rowNum) throws SQLException {

		if(rs == null){
			return null;
		}

		DashboardUser user = new DashboardUser();
		user.setDateOfBirth(rs.getDate(Constants.DASHBOARD_USER_DATE_OF_BIRTH));
		user.setFirstname(rs.getString(Constants.DASHBOARD_USER_FIRST_NAME));
		user.setMiddlename(rs.getString(Constants.DASHBOARD_USER_MIDDLE_NAME));
		user.setLastname(rs.getString(Constants.DASHBOARD_USER_LAST_NAME));
		user.setImage(rs.getString(Constants.DASHBOARD_USER_IMAGE));
		user.setEmail(rs.getString(Constants.DASHBOARD_USER_EMAIL));
		user.setPassword(rs.getString(Constants.DASHBOARD_USER_PASSWORD));
		return user;
	}
}
