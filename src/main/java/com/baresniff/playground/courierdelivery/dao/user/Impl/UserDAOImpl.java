/**
 * 
 */
package com.baresniff.playground.courierdelivery.dao.user.Impl;

import java.util.List;

import com.baresniff.playground.courierdelivery.dao.HibernateBaseDAO;
import com.baresniff.playground.courierdelivery.dao.user.UserDAO;
import com.baresniff.playground.courierdelivery.model.user.UserModel;

/**
 * @author prasoonjoshi
 *
 */
public class UserDAOImpl extends HibernateBaseDAO<UserModel, Integer> implements UserDAO {

	@Override
	public UserModel findById(Integer Id) {
		UserModel user = getHibernateTemplate().load(UserModel.class, Id);
		return user;
	}

	@Override
	public List<UserModel> findAll() {
		List<UserModel> userList = getHibernateTemplate().loadAll(UserModel.class);
		return userList;
	}
	
	

}
