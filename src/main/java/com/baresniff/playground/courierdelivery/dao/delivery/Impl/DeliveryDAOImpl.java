/**
 * 
 */
package com.baresniff.playground.courierdelivery.dao.delivery.Impl;

import java.util.List;

import com.baresniff.playground.courierdelivery.dao.HibernateBaseDAO;
import com.baresniff.playground.courierdelivery.dao.delivery.DeliveryDAO;
import com.baresniff.playground.courierdelivery.model.delivery.Delivery;

/**
 * @author prasoonjoshi
 *
 */
public class DeliveryDAOImpl extends HibernateBaseDAO<Delivery, Integer> implements
		DeliveryDAO {

	/* (non-Javadoc)
	 * @see com.baresniff.playground.courierdelivery.dao.BaseDao#get(java.lang.Object)
	 */
	@Override
	public Delivery get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.baresniff.playground.courierdelivery.dao.delivery.DeliveryDAO#getById(java.lang.Integer)
	 */
	@Override
	public Delivery getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.baresniff.playground.courierdelivery.dao.delivery.DeliveryDAO#getAll()
	 */
	@Override
	public List<Delivery> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.baresniff.playground.courierdelivery.dao.delivery.DeliveryDAO#add(com.baresniff.playground.courierdelivery.model.delivery.Delivery)
	 */
	@Override
	public void add(Delivery delivery) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.baresniff.playground.courierdelivery.dao.delivery.DeliveryDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.baresniff.playground.courierdelivery.dao.delivery.DeliveryDAO#update(java.lang.Integer)
	 */
	@Override
	public Delivery update(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
