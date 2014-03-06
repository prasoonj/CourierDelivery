package com.baresniff.playground.courierdelivery.dao;

import java.util.List;

public interface BaseDao <T, U>{
	
	List <T> getAll(T t);
	
	T get(U id);
	
	List<T> getByQuery(String query);

	List<T> getByHibernateQuery(String hibernateQuery);
	
	void add(T t);
	
	String getAuthRole(String auth);
	

}
