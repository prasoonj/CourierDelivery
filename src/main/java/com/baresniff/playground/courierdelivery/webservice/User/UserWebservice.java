package com.baresniff.playground.courierdelivery.webservice.User;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baresniff.playground.courierdelivery.dao.user.UserDAO;
import com.baresniff.playground.courierdelivery.model.user.UserModel;
import com.baresniff.playground.courierdelivery.webservice.WebServiceInterface;

@Component
@Path("/user")
@Produces("application/json")
public class UserWebservice implements WebServiceInterface {
	
	@Autowired
	private UserDAO userDAO; 

	@Override
	@GET
	@Path("/{userId}")
	@ResponseBody
	public UserModel getById(@PathParam("userId") Integer userId ) {
		UserModel user = userDAO.findById(userId);
		return user;
	}

	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getByQuery(String query) {
		List<UserModel> userList = userDAO.getByQuery(query);
		return userList;
	}
	

}
