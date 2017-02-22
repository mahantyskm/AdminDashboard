package com.indusmed.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indusmed.base.Constants;
import com.indusmed.base.DashboardUser;
import com.indusmed.dao.UserManagementDaoImpl;
import com.indusmed.request.AddNewUserRequest;
import com.indusmed.request.LoginRequest;
import com.indusmed.response.AddNewUserResponse;
import com.indusmed.response.GetUserResponse;
import com.indusmed.response.LoginResponse;
import com.indusmed.response.LogoutResponse;
import com.indusmed.utils.HashUtil;

import java.lang.annotation.Retention;

@RestController
public class UserManagementController {

    @Autowired
    UserManagementDaoImpl userManagementDao;

    @Autowired
    HashUtil hashUtil;

    @Autowired
    HttpSession session;

    @RequestMapping("/addNewUser")
    public AddNewUserResponse addNewUser(AddNewUserRequest request) {
        AddNewUserResponse response = new AddNewUserResponse();

        String passwordHash = hashUtil.getSHA256Hash(request.getPassword());
        request.setPassword(passwordHash);
        int result = userManagementDao.addNewUser(request);
        if (result > 0) {
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_ADD_USER);
        }
        return response;
    }

    @RequestMapping("/login")
    public LoginResponse checkLogin(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        System.out.println("username: " + request.getUsername());
        System.out.println("Passord: " + request.getPassword());
        DashboardUser user = userManagementDao.getDashboardUser(request);

        if (user != null && user.getPassword().equals(hashUtil.getSHA256Hash(request.getPassword()))) {
            session.setAttribute(Constants.DASHBOARD_USER, user);
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_AUTENTICATE_USER);
        }

        return response;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/getUserFromSession")
    public GetUserResponse getUserFromSession() {
        GetUserResponse response = new GetUserResponse();
        DashboardUser user = (DashboardUser) session.getAttribute(Constants.DASHBOARD_USER);
        if (user != null) {
            response.setUser(user);
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_AUTENTICATE_USER);
        }
        return response;
    }

    @RequestMapping("/logout")
    public LogoutResponse logout() {
        LogoutResponse response = new LogoutResponse();
        session.invalidate();
        response.setSuccessful(true);
        response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        return response;
    }

}
