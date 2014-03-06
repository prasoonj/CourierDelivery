package com.baresniff.playground.courierdelivery.webservice.delivery;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baresniff.playground.courierdelivery.dao.delivery.DeliveryDAO;
import com.baresniff.playground.courierdelivery.model.delivery.Delivery;
import com.baresniff.playground.courierdelivery.webservice.WebServiceInterface;

@Component
@Path("/delivery")
@Produces("application/json")
public class DeliveryWebservice implements WebServiceInterface<Delivery> {

	@Autowired
	private DeliveryDAO deliveryDAO;

	@Override
	public Delivery getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Delivery> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUpdate(Delivery delivery) {
		deliveryDAO.add(delivery);

	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@ResponseBody
	public void addDelivery(@FormParam("description") String description,
			@FormParam("sourceCoord") double[] sourceCoord,
			@FormParam("destinationCoord") double[] destinationCoord,
			@FormParam("deliveryStatus") String deliveryStatus,
			@RequestHeader("Authorization") String auth) {
		
		if(deliveryDAO.getAuthRole(auth) == "none"){
			return;
		}
		
		Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
		Delivery delivery = new Delivery();
		delivery.setDeliveryStatus(deliveryStatus); //must be "requestAcknowledged". Can use enum to restrict.
		delivery.setDescription(description);
		delivery.setDestinationCoord(destinationCoord);
		delivery.setSourceCoord(sourceCoord);
		addUpdate(delivery);

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@ResponseBody
	public void updateDelivery(@PathParam("id") Integer id,
			@FormParam("description") String description,
			@FormParam("sourceCoord") double[] sourceCoord,
			@FormParam("destinationCoord") double[] destinationCoord,
			@FormParam("deliveryStatus") String deliveryStatus,
			@RequestHeader("Authorization") String auth) {
		
		if(deliveryDAO.getAuthRole(auth) == "none"){
			return;
		}
		
		String username = "getfromauthentication";
		Delivery delivery = deliveryDAO.getById(id);
		delivery.setDeliveryStatus(deliveryStatus);
		delivery.setDescription(description);
		delivery.setDestinationCoord(destinationCoord);
		delivery.setSourceCoord(sourceCoord);
		addUpdate(delivery);

	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public Delivery update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Delivery> getByQuery(String query) {
		List<Delivery> deliveryList = deliveryDAO.getByQuery(query);
		return deliveryList;
	}

	// Database dependent. Can make it more loosely coupled in the next
	// iteration.
	@GET
	@Path("/since/{noOfDays}")
	@ResponseBody
	public List<Delivery> deliverySince(@PathParam("noOfDays") Integer noOfDays,
			@RequestHeader("Authorization") String auth) {
		
		if (deliveryDAO.getAuthRole(auth) != "ADMIN"){
			return null ;
		}
		
		String quanta = "0";
		String unit = "";
		if (noOfDays == 1) {
			quanta = "24";
			unit = "HOURS";
		} else if (noOfDays == 7) {
			quanta = "7";
			unit = "DAYS";
		} else if (noOfDays == 30) {
			quanta = "1";
			unit = "MONTH";
		}
		String query = "SELECT * FROM DELIVERY WHERE timestamp BETWEEN timestamp(DATE_SUB(NOW(), INTERVAL"
				+ quanta + unit + ")) AND timestamp(NOW())";
		return getByQuery(query);
	}

	@GET
	@Path("/status/{status}")
	@ResponseBody
	public List<Delivery> deliveryBasedOnStatus(
			@PathParam("status") String status,
			@RequestHeader("Authorization") String auth) {
		
		if (deliveryDAO.getAuthRole(auth) != "ADMIN"){
			return null;
		}
		String hibernateQuery = "FROM Delivery D WHERE D.deliveryStatus = "
				+ status;
		return deliveryDAO.getByHibernateQuery(hibernateQuery);
	}
	
	@GET
	@Path("/")
	@ResponseBody
	public List<Delivery> deliveryHistory(){
		return deliveryDAO.getAll(new Delivery());
	}

}
