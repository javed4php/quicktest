/**
 * 
 */
package com.ca.digital.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.digital.dao.CustomerDAO;
import com.ca.digital.entity.CustomerDTO;
import com.ca.digital.manager.CustomerManager;
import com.ca.digital.service.vo.CustomerVO;
import com.ca.digital.utility.CommonHelper;

/**
 * @author nalch04
 *
 */
@Service
@Qualifier("customerManager")
@Transactional
public class CustomerManagerImpl implements CustomerManager{
	
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	@Qualifier(value="commonHelper")
	CommonHelper commonHelper;
	@Autowired
	SessionFactory sessionFactory;
	@PostConstruct
	public void createSessionFromFactory(){
		System.out.println("Inside post construct");
//		Session session=sessionFactory.getCurrentSession();
		System.out.println("after post construct");
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void createCustomer(){
		
		//commonHelper.convertToVO();
		
		customerDAO.createCustomer();
		
		commonHelper.convertToDTO();
	}
	public List<CustomerVO> getAllCustomers(){
		System.out.println("In Manager");
		List<CustomerVO> customerVo = new ArrayList<CustomerVO>();
		CustomerVO vo = null;
		List<CustomerDTO> customerDTO = customerDAO.getAllCustomers(sessionFactory);
		if(null != customerDTO && customerDTO.size() > 0){
			for(CustomerDTO customer:customerDTO){
				vo = new CustomerVO();
				//BeanUtils.copyProperties(customerDTO, vo);
				//customerVo.add(vo);
				customerVo.add(commonHelper.convertToVO(customer, vo));
			}
		}
		return customerVo;
	}

	public String getSplStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
