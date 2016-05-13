package com.indusmed.controllers;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indusmed.base.Constants;

@RestController
public class DashboardViewController {
	@Autowired
	private HttpSession session;

	private static final Logger LOGGER = Logger.getLogger(DashboardViewController.class);

	@RequestMapping("/temp")
	public String getName() {
		LOGGER.debug("n get Name");
		return Constants.TEMP_PAGE;
	}

	@RequestMapping("/newUser")
	public String newUser() {
		if (session.getAttribute(Constants.DASHBOARD_USER) != null) {
			return Constants.ADD_NEW_USER;
		} else {
			return Constants.USER_LOGIN;
		}
	}	
/*
	@RequestMapping({"/","/dashboard"})
	public String getPage() {
		//if (session.getAttribute(Constants.DASHBOARD_USER) != null) {
			return Constants.USER_HOME;
		/*} else {
			return Constants.USER_LOGIN;
		}*/
	//}//

}
