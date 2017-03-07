package com.ca.digital.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ca.digital.dao.BaseHibernateDAO;
import com.ca.digital.dao.CustomerDAO;
import com.ca.digital.entity.CustomerDTO;

@SuppressWarnings("rawtypes")
@Repository("customerDAO")
public class CustomerDAOImpl extends BaseHibernateDAO implements CustomerDAO{

//	CustomerDAO() {
//		setDAOClass(CustomerDAO.class);
//	}
	public void createCustomer() {
		// TODO Auto-generated method stub
		
	}
	@PostConstruct
	public void setClassForDao(){
		setDAOClass(CustomerDAOImpl.class);
	}
	public List<CustomerDTO> getAllCustomers(SessionFactory sessionFactory) {
		
		System.out.println("Hai Im in DAO Cust");
		return getAll("CustomerDTO",sessionFactory);
	}
	

}
