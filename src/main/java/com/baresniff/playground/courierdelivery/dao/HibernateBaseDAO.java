package com.baresniff.playground.courierdelivery.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.baresniff.playground.courierdelivery.model.user.UserModel;

public class HibernateBaseDAO<T, U> implements BaseDao<T, U> {

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		hibernateTemplate = new HibernateTemplate(this.sessionFactory);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public List<T> getAll(T t) {
		@SuppressWarnings("unchecked")
		List<T> objectList = (List<T>) hibernateTemplate.find("FROM "
				+ t.getClass());
		return objectList;
	}

	@Override
	public T get(U id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getByQuery(String query) {
		List<T> objectList = (List<T>) hibernateTemplate.find(query);
		return objectList;
	}

	@Override
	public List<T> getByHibernateQuery(String hibernateQuery) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hibernateQuery);
		return query.list();
	}

	@Override
	public void add(T t) {
		hibernateTemplate.getSessionFactory().openSession().save(t);

	}

	@Override
	public String getAuthRole(String auth) {
		String[] authValues = auth.split(":");
		String username = authValues[0];
		String password = authValues[1];
		UserModel user = (UserModel) hibernateTemplate.find("FROM User U WHERE U.username=" + username
				+ "AND U.password=" + password).get(0);
		String role = "none";
		if (user != null){
			role = user.getUserGroup();
		}
		return role;
	}

}
