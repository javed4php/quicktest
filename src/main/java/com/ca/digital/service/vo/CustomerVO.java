/**
 * 
 */
package com.ca.digital.service.vo;

import java.io.Serializable;


/**
 * @author nalch04
 *
 */
public class CustomerVO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1769191232620245016L;
	
	private String customerId;
    private String firstName;
    
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
    

}
