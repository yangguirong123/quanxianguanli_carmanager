package com.ygr.usermanage.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Role;
import com.ygr.usermanage.service.FunctionServer;
import com.ygr.usermanage.service.RoleServer;
import com.ygr.usermanage.utils.MyUtils;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleServer roleServer;

	@Autowired
	private FunctionServer functionServer;

	@RequestMapping("addrole")
	public String addRole(Model model) {
		return "role/addrole";
	}

	@RequestMapping("rolesubmit")
	public String addroleSubmit(Role role, Model model) {
		if (roleServer.addRole(role)) {
			return "redirect:/role/listrole.do";
		} else {
			model.addAttribute("message", "角色名不能重复！！！");
			return "role/addrole";
		}
	}

	@RequestMapping("listrole")
	public String listRole(Map<String, List<Role>> map) {
		List<Role> list = roleServer.findAllRole();
		map.put("roleLists", list);
		return "role/listrole";
	}

	@RequestMapping("deleterole")
	public String deleteRole(Integer role_id) {
		roleServer.deleteRoleById(role_id);
		return "redirect:/role/listrole.do";
	}

	@RequestMapping("listrolefunction")
	public String listRoleFunction(Integer role_id, Map<String, List<Function>> map, Model model, String mmmmm) {
		Role role = roleServer.findRoleById(role_id);
		List<Function> functionLists = MyUtils.setToList(role.getFunctionList());// 角色已经被赋予的功能列表
		List<Function> functionAllLists = functionServer.findAllFunction();// 所有模块所有功能列表
		map.put("functionLists", functionLists);
		map.put("functionAllLists", functionAllLists);
		model.addAttribute("role", role);
		model.addAttribute("role_id", role_id);
		model.addAttribute("mmmmm", mmmmm);// 操作角色所属的功能成功后的提示语
		return "role/listfunction";
	}

	@RequestMapping("submitfunction")
	public String submitRolefunction(Integer role_id, Integer[] selectId, Model model) {
		Role role = roleServer.findRoleById(role_id);
		Set<Function> functionSet = role.getFunctionList();
		functionSet.clear();// 清空角色下得所有功能
		for (Integer selectid : selectId) {
			Function function = functionServer.findFunctionById(selectid);// 查询出选中的哪些功能
			functionSet.add(function);// 添加选中的功能到此角色下
		}
		role.setFunctionList(functionSet);
		roleServer.updateRole(role);
		model.addAttribute("mmmmm", "   功能授权成功!!!!");
		return "redirect:/role/listrolefunction.do?role_id=" + role_id;

	}
}
