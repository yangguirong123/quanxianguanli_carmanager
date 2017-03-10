package com.ygr.usermanage.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Module;
import com.ygr.usermanage.service.FunctionServer;
import com.ygr.usermanage.service.ModuleServer;

@Controller
@RequestMapping("/function")
public class FunctionController {
	@Autowired
	private FunctionServer functionServer;

	@Autowired
	private ModuleServer moduleServer;

	// function/listfunction.do
	@RequestMapping("listfunction")
	public String listFunction(String message, Integer module_id, Map<String, List<Function>> map, Model model) {
		List<Function> listFunctions = moduleServer.getFunctionListsByModuleId(module_id);
		Module m = moduleServer.getModuleById(module_id);
		map.put("moduleFunctionList", listFunctions);
		model.addAttribute("module_id", module_id);
		model.addAttribute("module", m);
		model.addAttribute("mmm", message);
		return "function/listfunction";
	}

	@RequestMapping(value = "addmodulefunction")
	public String addModuleFunction(Integer module_id, String function_code, String description, Model model) {
		Module module = moduleServer.getModuleById(module_id);
		Function function = new Function(function_code, description, module);
		if (functionServer.addFunction(function)) {
			return "redirect:/function/listfunction.do?module_id=" + module_id;
		} else {
			String message = "功能的code不能重复存在！！";
			model.addAttribute("message", message);
			return "redirect:/function/listfunction.do?module_id=" + module_id;
		}
	}

	@RequestMapping(value = "deletemodulefunction")
	public String deleteModuleFunction(Integer function_id, Model model) {
		int module_id = functionServer.findFunctionById(function_id).getModule().getModule_id();
		functionServer.deleteFunctionById(function_id);
		return "redirect:/function/listfunction.do?module_id=" + module_id;
	}

}
