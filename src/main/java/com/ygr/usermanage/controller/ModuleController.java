package com.ygr.usermanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.server.ModuleServer;

@Controller
@RequestMapping("module")
public class ModuleController {
	@Autowired
	private ModuleServer moduleServer;
	
	
}
