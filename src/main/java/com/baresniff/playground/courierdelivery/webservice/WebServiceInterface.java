package com.baresniff.playground.courierdelivery.webservice;

import java.util.List;

public interface WebServiceInterface <T> {
	
	public T getById(Integer id);
	public List<T> getAll();
	public void addUpdate(T t);
	public void delete();
	public T update();
	public List<T> getByQuery(String query);
}
