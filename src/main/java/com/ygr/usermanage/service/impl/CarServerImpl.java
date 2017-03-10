package com.ygr.usermanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygr.usermanage.dao.CarDao;
import com.ygr.usermanage.model.Car;
import com.ygr.usermanage.service.CarServer;
import com.ygr.usermanage.utils.Pager;
@Service("carServer")
public class CarServerImpl implements CarServer {
	@Autowired
	private CarDao carDao;

	@Override
	public boolean addCar(Car car) {
		//如果根据车牌号查询不到汽车，那么就可以添加，因为车牌号是不能重复的
		String carNumber=car.getCarNumber();
		if (carDao.getCarBycarNumer(carNumber) == null) {
			carDao.addCar(car);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ArrayList<Car> findAll() {
		ArrayList<Car> list=carDao.findAll();
		return list;
		
	}

	@Override
	public void deleteCarById(int id) {
		carDao.deleteCarById(id);
	}

	@Override
	public void updateCar(Car car) {
		
		carDao.updateCar(car);
	}

	@Override
	public Car getCarById(int id) {
		Car car=carDao.getCarById(id);
		
		return car;
	}

	@Override
	public List<Car> getPageUserLists(int getFromIndex,int getPageSize) {
		return carDao.getPageUserLists(getFromIndex,getPageSize);
	}

	@Override
	public int getTotalCount() {
		return carDao.getTotalCount();
	}

}
