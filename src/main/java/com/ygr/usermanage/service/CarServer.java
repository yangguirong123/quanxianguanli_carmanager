package com.ygr.usermanage.service;

import java.util.ArrayList;
import java.util.List;

import com.ygr.usermanage.model.Car;
import com.ygr.usermanage.utils.Pager;

public interface CarServer {
	
	boolean addCar(Car car);
	
	ArrayList<Car> findAll();
	
	void deleteCarById(int id);
	
	void updateCar(Car car);
	
	Car getCarById(int id);
	/**
	 * 分页处理 获取车辆列表
	 * @param pager
	 * @return
	 */
	List<Car> getPageUserLists(int getFromIndex, int getPageSize );
	/**
	 * 获取车辆总个数
	 * @return
	 */
	int getTotalCount();
}
