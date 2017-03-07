/**
 * 
 */
package com.ca.digital.orchestrator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.glassfish.jersey.client.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ca.digital.service.vo.TaskDetailsVO;
import com.ca.digital.service.vo.TrailRequestVO;
import com.ca.digital.utility.CommonHelper;

/**
 * @author nalch04
 *
 */
public class CustomerRegistrationService implements ServiceExecutor{
	ApplicationContext appContext;
//	ServiceAction serviceAction;
	@Autowired
	TrailOrchestrator trailOrchestrator;
	Object trailIdForTasks=null;
	Map<String,List<TaskDetailsVO>> taskDetailsListMap=null;
	List<ClientResponse> clientResponseList=new ArrayList<ClientResponse>();
	@Autowired
	static DigitalRequest digitalRequest;
	@Autowired
	static CommonHelper commonHelper;
	@Autowired
	static TrailRequestVO trailRequestVO;
	Map<String,Object> responseMap=new LinkedHashMap<String,Object>();
//	@PreConstruct
	public void init() {
//		taskDetailsListMap=(Map<String, List<TaskDetailsVO>>) trailOrchestrator.execute(trailIdForTasks);
		
	}

	public Object execute(DigitalRequest digitalRequest) {
		trailIdForTasks=digitalRequest.getTrailId();
		try{
			this.init();
			Iterator entries = taskDetailsListMap.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry entry = (Map.Entry) entries.next();
			    String key = (String)entry.getKey();
			    List<TaskDetailsVO> taskDetailsList = (List<TaskDetailsVO>)entry.getValue();
			    int numThreadsToCreate = taskDetailsList.size();
			    if(taskDetailsList.size()>1){
			    	TrailRequestThread[] threads = new TrailRequestThread[numThreadsToCreate];
			    	for (int i = 0; i < threads.length; i++) {
			    	    threads[i] = new TrailRequestThread(taskDetailsList.get(i),responseMap);
			    	    threads[i].start();	
			    	    
			    	}
			    	for (TrailRequestThread thread:threads) {
			    		try {
							thread.join();
							responseMap.put(thread.getServiceName(),thread.getResponseForThread());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}

			    }else if(taskDetailsList.get(0)!=null){
			    	TaskDetailsVO taskDetails = taskDetailsList.get(0);
			    	Object response=commonHelper.executeTrialTasks(taskDetails,responseMap);
			    	responseMap.put(taskDetails.getTrialActionName(),response);
			    }
			    
			    

			}

		}catch (Exception e){
			e.printStackTrace();
		}
				return responseMap;
	}

	/*public Object collectResponse(List<Object> obj) {
		return responseList;
	}*/

	public static void main(String[] args){
		System.out.println("------------------" +new CustomerRegistrationService().execute(null));

	}
	@SuppressWarnings("unused")
	private void setTrailRequestVO(DigitalRequest req, Object userID) {

		// TODO Auto-generated method stub
		trailRequestVO = new TrailRequestVO();
		trailRequestVO.setActive(true);
		trailRequestVO.setCreatedDate(new java.sql.Timestamp(new Date().getTime()));
		trailRequestVO.setUpdatedDate(new java.sql.Timestamp(new Date().getTime()));
		// trailRequestVO.setUserId((Integer)userID);
		trailRequestVO.setUserId(2906156);
		trailRequestVO.setMdrCode("NULL");
		// trailRequestVO.setTrailID(Integer.parseInt(req.getTrailId()));
		trailRequestVO.setTrailID(1001);
		// Get this from Hibernate Cache
		trailRequestVO.setTrailSourceID(8001);
	}
	private void setRequestJSONToObject(Object req) {

		// TODO Auto-generated method stub
		digitalRequest = new DigitalRequest();
		digitalRequest.setEmail("qatest160426a@ca.com");
		digitalRequest.setCompanyName("qatest160426a");
		digitalRequest.setCity("Smallville");
		digitalRequest.setAddress("123 Foo St");
		digitalRequest.setCountry("United States");
		digitalRequest.setIpAddress("");
		digitalRequest.setJobTitle("Software");
		digitalRequest.setFirstName("Chakravarthi");
		digitalRequest.setLastName("Nalamala");
		digitalRequest.setPhoneNumber("512-555-1212");
		digitalRequest.setState("TX");
		digitalRequest.setPassword("ab3cde78f");
		digitalRequest.setRegRegion("en_US");
	}

}
