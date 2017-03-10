package com.ygr.usermanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.server.FunctionServer;

@Controller
@RequestMapping("function")
public class FunctionController {
	@Autowired
	private FunctionServer functionServer;

	@RequestMapping("/add")
	public String addFunction(Function function, Model model) {
		if (functionServer.addFunction(function)) {
			return null;
		} else {
			return null;
		}

	}
}
