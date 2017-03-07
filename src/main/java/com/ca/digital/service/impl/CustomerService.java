package com.ca.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ca.digital.manager.CustomerManager;
import com.ca.digital.service.ServiceAction;
import com.ca.digital.service.vo.CustomerVO;
import com.ca.digital.utility.CommonHelper;
@Component("customerService")

public class CustomerService implements ServiceAction{

	@Autowired
	@Qualifier(value="customerManager")
	CustomerManager customerManager;
	@Autowired
	@Qualifier(value="commonHelper")
	CommonHelper commonHelper;

	public void performTask(){
		
		customerManager.createCustomer();
		commonHelper.convertVOToJSON();
	}
	
	//public List<CustomerVO> getAllCustomers() {
	public String getAllCustomers() {
		System.out.println("In cust service");
		String response = "";
		List<CustomerVO> customerVO = customerManager.getAllCustomers();
		CustomerVO custVO = null;
		if(null != customerVO && customerVO.size() > 0){
			for(CustomerVO customer:customerVO){
				custVO = new CustomerVO();
				System.out.println("First Name: " + customer.getFirstName());
				response = "SUCCESS";
			}
		}

		return response;
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------Customer Registration Impl Init ----------------------------");
	}

	public Object execute(Object object) {
		// TODO Auto-generated method stub
		this.init();
		
		String response = getAllCustomers();
		
		return response;
	}

	public void getResponse() {
//		return null;
	}
}
