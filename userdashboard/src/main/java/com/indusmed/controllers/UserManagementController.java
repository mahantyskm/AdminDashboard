package com.indusmed.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indusmed.base.AddNewUserRequest;
import com.indusmed.base.AddNewUserResponse;
import com.indusmed.base.Constants;
import com.indusmed.base.DashboardUser;
import com.indusmed.base.LoginRequest;
import com.indusmed.base.LoginResponse;
import com.indusmed.dao.UserManagementDaoImpl;
import com.indusmed.utils.HashUtil;

@RestController
public class UserManagementController {

	@Autowired
	UserManagementDaoImpl userManagementDao;

	@Autowired
	HttpSession session;

	@RequestMapping("/addNewUser")
	public AddNewUserResponse addNewUser(@RequestParam(value = "addNewUserRequest") AddNewUserRequest request) {
		AddNewUserResponse response = new AddNewUserResponse();
		String passwordHash = HashUtil.getSHA256Hash(request.getPassword());
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
	public LoginResponse checkLogin(@RequestParam(value = "loginRequest") LoginRequest request) {
		LoginResponse response = new LoginResponse();

		DashboardUser user = userManagementDao.getDashboardUser(request);
		if (user != null && user.getPassword().equals(HashUtil.getSHA256Hash(request.getPassword()))) {
			session.setAttribute(Constants.DASHBOARD_USER, user);
			response.setSuccessful(true);
			response.setMessage(Constants.ADD_USER_SUCCESSFUL);
		} else {
			response.setSuccessful(false);
			response.setMessage(Constants.FAILED_TO_AUTENTICATE_USER);
		}
		return response;
	}

}
