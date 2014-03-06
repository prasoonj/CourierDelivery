package com.baresniff.playground.courierdelivery.model.delivery;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.baresniff.playground.courierdelivery.model.BaseModel;

@Entity
@Table (name="CDS_DELIVERY")
public class Delivery implements BaseModel {
	
	@Id
	@Column (name="ID")
	@GeneratedValue
	private long id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="SOURCE")
	private double[] sourceCoord;
	
	@Column(name="DESTINATION")
	private double[] destinationCoord;
	
	@Column(name="STATUS")
	private String deliveryStatus;
	
	@ManyToOne
	@JoinColumn(name="username")
	private String username;
	
	@Column(name="TIMESTAMP")
	private Timestamp timestamp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double[] getSourceCoord() {
		return sourceCoord;
	}

	public void setSourceCoord(double[] sourceCoord) {
		this.sourceCoord = sourceCoord;
	}

	public double[] getDestinationCoord() {
		return destinationCoord;
	}

	public void setDestinationCoord(double[] destinationCoord) {
		this.destinationCoord = destinationCoord;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
