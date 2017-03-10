package com.ygr.usermanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.model.User;
import com.ygr.usermanage.server.UserServer;

@Controller
@RequestMapping("user")
public class UserContrller {
	private UserServer userServer;
	@RequestMapping("/add")
	public String addUser(User user, Model model) {
		if (userServer.addUser(user)) {
			return null;
		} else {
			return null;
		}

	}
}
