package com.ca.digital.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ca.digital.service.ServiceAction;
import com.ca.digital.utility.SOAPHelper;

@Component("splCheckService")
@Path("/splcheck")
public class SPLCheckService implements ServiceAction {
	
	static String response = "";
	
	
	@Autowired
	@Qualifier(value="splCheckService")
	SPLCheckService splCheckService;
	@Autowired
	@Qualifier(value="soapHelper")
	SOAPHelper soapHelper;

	public void performTask(){
		
		System.out.println("In performTask method ");
		try {
			this.getSplStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//commonHelper.convertVOToJSON();
	}
		
	@SuppressWarnings("static-access")
	@Produces({ MediaType.APPLICATION_JSON })
	public static String getSplStatus() throws Exception {
		SOAPHelper soapHelper = new SOAPHelper();
		response = soapHelper.createSoapRequest();
		JSONObject json = new JSONObject();
		json.put("Status", "Blocked");
		json.put("EntityId", "039992A1791");
		json.put("SanctionId", "000719106");
		json.put("Description", "Country Listed In CA Embargo Database");
		response = json.toString();
		System.out.println("status in if " + response);
		return response;

	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
	@GET
	public Object execute(Object object) {
		// TODO Auto-generated method stub
		this.init();
		try {
			System.out.println("inside execute");
			response = getSplStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	public void getResponse() {
//		return null;
	}
}
	
	
	

