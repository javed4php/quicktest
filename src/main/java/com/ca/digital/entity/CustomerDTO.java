package com.ca.digital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dbo.Customer")
public class CustomerDTO {
	@Id
    @Column(name="UserID")
    String customerId;
 
    @Column(name="FistName")
    String firstName;

	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
}
