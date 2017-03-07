/**
 * 
 */
package com.ca.digital.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ca.digital.entity.TrailSource;
import com.ca.digital.manager.TrailRequestManager;
import com.ca.digital.service.ServiceAction;
import com.ca.digital.utility.CommonHelper;

/**
 * @author nalch04
 *
 */
public class TrailRequestService implements ServiceAction {

	@Autowired
	@Qualifier(value="trailRequestManager")
	TrailRequestManager trailRequestManager;

	@Autowired
	@Qualifier(value="commonHelper")
	CommonHelper commonHelper;

	public TrailSource getTrail() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public Response updateTrail(JAXBElement<TrailSource> trailSource) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createTrail(String id, String summary, String description,
			HttpServletResponse servletResponse) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public Object execute() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getResponse() {
//		return null;
	}
	public Object execute(Object trailId) {
//		Vijay code
		return trailRequestManager.getTaskDetailsForTrailId(trailId.toString());
		
		// Chakravarti code
//				this.init();
//				Object response = null;
//				//String response = getAllCustomers(obj);
//				response = createCustomerForTrail(obj);
//				return response;
	}
	public Integer createCustomerForTrail(Object obj) {
		System.out.println("In cust service for CreateCustomerForTrail");
		String response = "";
		Integer statusCheck = null;
		statusCheck = trailRequestManager.createTrailRequest(obj);
		if(statusCheck > 0){
			response = "Customer Registration if successfully";
		}else{
			response = "Failed to Insert the Customer Registration details";
		}

		return statusCheck;
	}

}
