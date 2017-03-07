package com.ca.digital.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ca.digital.entity.CustomerDTO;

public interface CustomerDAO {
	
	public void createCustomer();
	
	public List<CustomerDTO> getAllCustomers(SessionFactory sessionFactory);

}
