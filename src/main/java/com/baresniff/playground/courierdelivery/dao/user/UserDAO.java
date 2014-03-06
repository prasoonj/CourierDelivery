package com.baresniff.playground.courierdelivery.dao.user;

import java.util.List;

import com.baresniff.playground.courierdelivery.dao.BaseDao;
import com.baresniff.playground.courierdelivery.model.user.UserModel;

public interface UserDAO extends BaseDao<UserModel, Integer>{
	
	public UserModel findById(Integer Id);
	public List<UserModel> findAll();
}
