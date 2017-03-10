package com.ygr.usermanage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygr.usermanage.model.Car;
import com.ygr.usermanage.service.CarServer;
import com.ygr.usermanage.utils.PageUtil;
import com.ygr.usermanage.utils.Pager;

@Controller
@RequestMapping()
public class CarController {
	private int currentPager = 1; // 当前页
	@Autowired
	private CarServer carServer;

	/**
	 * 通过"/form"需要查找到页面
	 * 
	 * @return
	 */
	@RequestMapping("/form")
	public String add() {
		return "/add_car";
	}

	@RequestMapping("/add")
	public String addCar(Car car, Model model) {
		if (car.getId() == 0) {
			if (carServer.addCar(car)) {
				return "redirect:/show.do";
			} else {
				model.addAttribute("mmm", "车牌号已存在，请勿重复添加！");
				return "/add_car";
			}
		} else {
			carServer.updateCar(car);
			return "redirect:/show.do";
		}
	}

	/**
	 * 
	 * @param pager
	 * @param map
	 *            map和model都可以从controller层传递参数到jsp页面，区别在于map一般用于数组或者列表
	 * @return
	 */
	@RequestMapping("/show")
	public String showAll(Integer pageNum, Map<String, Object> map, Model model) {
		int pageSize = 5;
		// 非空判断页面数，如果页面不为空赋值给mCurrentPager
		if (pageNum != null && pageNum > 0) {
			currentPager = pageNum;
		}
		int count = carServer.getTotalCount();
		PageUtil pageUtil = new PageUtil(pageSize, count, currentPager);

		List<Car> carLists = carServer.getPageUserLists(pageUtil.getFromIndex(), pageUtil.getPageSize());

		

		map.put("carLists", carLists);
		model.addAttribute("currentPage", currentPager);
		model.addAttribute("totalPage", pageUtil.getPageCount());
		return "/list_car";

	}

	@RequestMapping("/delete")
	public String delete(int id) {
		carServer.deleteCarById(id);
		return "redirect:/show.do";
	}

	@RequestMapping("/update")
	public String update(Car c, Model model) {
		Car car = carServer.getCarById(c.getId());
		model.addAttribute("car", car);

		return "/add_car";

	}

}
