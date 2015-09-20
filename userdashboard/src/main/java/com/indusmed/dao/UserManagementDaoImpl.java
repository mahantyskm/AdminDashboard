package com.indusmed.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.indusmed.base.AddNewUserRequest;
import com.indusmed.base.Constants;
import com.indusmed.base.DashboardUser;
import com.indusmed.base.LoginRequest;
import com.indusmed.base.UserRowMapper;

public class UserManagementDaoImpl extends JdbcDaoSupport implements IUserManagementDao {

    public int addNewUser(AddNewUserRequest request) {
        String sql = "insert into " + Constants.USERS_TABLE + " (firstname,lastname,middlename,password,email,creation_date,image) values(?,?,?,?,?,?,?)";
        int result = getJdbcTemplate().update(
                sql,
                new Object[] {
                        request.getFirstname(),
                        request.getLastname(),
                        request.getMiddlename(),
                        request.getPassword(),
                        request.getEmail(),
                        request.getDateOfJoining(),
                        request.getImage() });
        return result;
    }

    public DashboardUser getDashboardUser(LoginRequest request) {
        String sql = "select * from user_info where email = ?";
        DashboardUser user = getJdbcTemplate().queryForObject(sql, new Object[] { request.getUsername() }, new UserRowMapper());

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

}