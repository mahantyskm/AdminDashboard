package com.indusmed.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.indusmed.base.Constants;
import com.indusmed.base.DashboardUser;
import com.indusmed.request.AddNewUserRequest;
import com.indusmed.request.LoginRequest;
import com.indusmed.rowmapper.UserRowMapper;

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
        
        DashboardUser user = null;
        try{
            user = getJdbcTemplate().queryForObject(sql, new Object[] { request.getUsername() }, new UserRowMapper());
        }
        catch(Exception e){
            System.out.println("Ecxeption while querying for username");
        }
        return user;
    }

}