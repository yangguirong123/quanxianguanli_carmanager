package com.ygr.usermanage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.model.Module;
import com.ygr.usermanage.service.ModuleServer;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private ModuleServer moduleServer;

	// module/addmodule.do
	@RequestMapping("addmodule")
	public String login(Model model) {
		return "module/addmodule";
	}

	// module/listmodule.do
	@RequestMapping("listmodule")
	public String listModule(Map<String, List<Module>> map) {
		List<Module> list = moduleServer.findAllModule();
		map.put("modulesList", list);
		return "module/listmodule";
	}

	// module/addmodule_submit.do
	@RequestMapping("addmodule_submit")
	public String addModule(Module module, Model model) {
		if (moduleServer.addModule(module)) {
			return "redirect:/module/listmodule.do";
		} else {
			model.addAttribute("mmmm", "该模块已存在请勿重复添加!!");
			return "module/addmodule";
		}
	}

	//module/deletemodule.do
	@RequestMapping("deletemodule")
	public String deleteModule(Integer module_id,Model model){	
		moduleServer.deleteModuleById(module_id);
		return "redirect:/module/listmodule.do";
		
	}
	//module/updatemodule.do
	@RequestMapping("updatemodule")
	public String updateModule(Integer module_id,Model model){
		 Module m=moduleServer.getModuleById(module_id);
		 moduleServer.updateModule(m);
		return "";
		
	}
}
