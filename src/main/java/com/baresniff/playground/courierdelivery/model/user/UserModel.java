/**
 * 
 */
package com.baresniff.playground.courierdelivery.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.Authentication;

import com.baresniff.playground.courierdelivery.model.BaseModel;
import com.baresniff.playground.courierdelivery.model.delivery.Delivery;

/**
 * @author prasoonjoshi
 *
 */
@Entity
@Table (name="CDS_USER")
public class UserModel implements BaseModel {
	
	@Id
	@Column (name="USERNAME")
	private String username;
	
	@Column (name="PASSWORD")
	private byte[] password;
	
	@Transient
	private Authentication authentication;
	
	@OneToMany(mappedBy="user")
	private Set<Delivery> deliveries;
	
	//userGroup can be ('user', 'admin')
	@Column(name="userGroup")
	private String userGroup;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public Set<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	
	
}
