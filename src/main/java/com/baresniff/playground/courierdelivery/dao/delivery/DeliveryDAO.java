package com.baresniff.playground.courierdelivery.dao.delivery;

import java.util.List;

import com.baresniff.playground.courierdelivery.dao.BaseDao;
import com.baresniff.playground.courierdelivery.model.delivery.Delivery;

public interface DeliveryDAO extends BaseDao<Delivery, Integer> {

	public List<Delivery> getByQuery(String query);
	public Delivery getById(Integer id);
	
	public void add(Delivery delivery);
	public void delete(Integer id);
	
	public Delivery update(Integer id);
}
