package com.ygr.usermanage.dao.impl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ygr.usermanage.dao.CarDao;
import com.ygr.usermanage.model.Car;
import com.ygr.usermanage.utils.MyHibernateDaoSupport;
import com.ygr.usermanage.utils.PageUtil;
import com.ygr.usermanage.utils.Pager;

@Transactional
@Repository("carDao")
@Scope("singleton")
public class CarDaoImpl extends MyHibernateDaoSupport implements CarDao {
	// @Autowired
	// private SessionFactory sessionFactory;

	@Override
	public Car getCarById(int id) {
		return getHibernateTemplate().get(Car.class, id);
	}

	@Override
	public Car getCarBycarNumer(String carNumber) {
		List<Car> list = (List<Car>) getHibernateTemplate().find("from Car where carNumber=?", carNumber);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void addCar(Car car) {
		getHibernateTemplate().save(car);
	}

	@Override
	public ArrayList<Car> findAll() {
		List<Car> carlist = (List<Car>) getHibernateTemplate().find("From Car");
		return (ArrayList<Car>) carlist;
	}

	@Override
	public void deleteCarById(int id) {
		Car car = getHibernateTemplate().get(Car.class, id);
		getHibernateTemplate().delete(car);
	}

	@Override
	public void updateCar(Car car) {
		getHibernateTemplate().update(car);
	}

	@Override
	public List<Car> getPageUserLists(int getFromIndex,int getPageSize) {

		List<Car> lists = getHibernateTemplate().execute(new HibernateCallback<List<Car>>() {
			@Override
			public List<Car> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("FROM Car ").setFirstResult(getFromIndex)
						.setMaxResults(getFromIndex);
				List<Car> lists = (List<Car>) query.list();
				return lists;
			}
		});
		return lists;
		// 重点在于两个方法setFirstResult()和setMaxResults()查询数据库中位于这个两个id坐标之间的数据返回得到的一个数组，即为每个页面中显示的数据
		// setFirstResult()中的参数为，获取每个分页第一个数据的坐标位置，
		// setMaxResults()中的参数为每页显示多少条记录个数

	}

	@Override
	public int getTotalCount() {
		List<Car> carLists = (List<Car>) getHibernateTemplate().find("from Car");
		int count = 0;
		if (carLists != null && carLists.size() > 0) {
			count = carLists.size();
		}
		return count;
	}

}
