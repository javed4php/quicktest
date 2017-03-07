package com.ca.digital.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ca.digital.service.vo.CustomerVO;

@Service("customerManager")
public interface CustomerManager extends BaseManager{
	
	public void createCustomer();
	
	public List<CustomerVO> getAllCustomers();
	
	public String getSplStatus();

}
