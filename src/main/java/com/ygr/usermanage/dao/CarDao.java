package com.ygr.usermanage.dao;

import java.util.ArrayList;
import java.util.List;

import com.ygr.usermanage.model.Car;
import com.ygr.usermanage.utils.Pager;

public interface CarDao {
	
	Car getCarById(int id);
	
	Car getCarBycarNumer(String carNumber);
	
	void addCar(Car  car);
	/**
	 * 获取所有车辆信息，无分页处理，被淘汰的方法
	 * @return
	 */
	ArrayList<Car>  findAll();
	
	void deleteCarById(int id);
	
	void updateCar(Car car);
	/**
	 * 查询每页的汽车数据
	 * @param pager
	 * @return
	 */
	List<Car> getPageUserLists(int getFromIndex,int getPageSize);
	/**
	 * 获取车辆总个数
	 * @return
	 */
	int getTotalCount();
	
	
}
