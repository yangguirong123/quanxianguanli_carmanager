package com.ygr.usermanage.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.model.User;
import com.ygr.usermanage.service.UserServer;

@Controller
public class UserContrller {
	@Autowired
	private UserServer userServer;

	@RequestMapping("login")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("logindo")
	public String login(User user, Model model) {
		if (null == userServer.login(user)) {
			model.addAttribute("error", "请检查用户名或密码不正确或未通过审核");
			return "login";
		} else {
			return "main";
		}
	}

	@RequestMapping("adduser")
	public String addUser(Model model,String message) {
		model.addAttribute("message", message);
		return "user/adduser";
	}

	@RequestMapping("addsubmit")
	public String addsubmit(String username, String password, Model model){
		if (null != userServer.findUserByusername(username)) {
			model.addAttribute("message", "该用户名已存在!!!");
			return "redirect:/adduser.do";
		} else {
			User user = new User(username, password, 1);
			userServer.addUser(user);
			model.addAttribute("message", "申请注册成功！等待管理员审核通过！！");
			return "redirect:/adduser.do";
		}

	}
}
