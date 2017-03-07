package com.ca.digital.service.impl;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ca.digital.manager.DomainCheckManager;
import com.ca.digital.orchestrator.DigitalRequest;
import com.ca.digital.service.ServiceAction;
import com.ca.digital.utility.CommonHelper;
@RestController
@Service("domainCheckService")
public class DomainCheckService implements ServiceAction {
	
	static String response ="";
	static String domainStatus = "";
	static String domainName = "sreeharireddy@yahoo.com";
	static String[] output = domainName.split("@");
	static String strDomainName = output[1];
	static String strTrialId = "1001";
	
	
	@Autowired
	@Qualifier(value="domainCheckManager")
//	@Qualifier(value="baseManager")
	DomainCheckManager domainCheckManager;
	
	@Autowired
	@Qualifier(value="commonHelper")
	CommonHelper commonHelper;

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------Customer Registration Impl Init ----------------------------");
	}
	
	@RequestMapping (value ="/domainCheck", method = RequestMethod.GET )
	@ResponseBody
	public Object execute() {
		this.init();
		try{
			Long count = domainCheckManager.verifyDomainName(strDomainName,strTrialId);
			if(count > 0) {
	      	  //domainStatus = "Domain Blocked";
				response = "Domain Blocked";
	        }
	        else{
	      	  //domainStatus = "Domain UnBlocked";
	        	response = "Domain UnBlocked";
	        }		
			System.out.println("In Domain Check Service Impl Status  is :: "+domainStatus);
			
			/*JSONObject json = new JSONObject();
			json.put("Domain Name", strDomainName);
			json.put("Status", domainStatus);
		    response = json.toString();
		    System.out.println("Details of the Domain "+response);
			*/return response;
			//response = verifyDomainName(strDomainName,strTrialId);
			//System.out.println("response +++++ "+response);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		return response;
	}
	public void getResponse() {
		// TODO Auto-generated method stub
		
	}


	public Object execute(DigitalRequest digitalRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object execute(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

		
       	
}