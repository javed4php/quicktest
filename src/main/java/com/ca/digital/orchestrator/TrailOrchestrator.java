/**
 * 
 */
package com.ca.digital.orchestrator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.glassfish.jersey.client.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ca.digital.manager.TrailRequestManager;
import com.ca.digital.service.vo.TaskDetailsVO;
import com.ca.digital.service.vo.TrailRequestVO;
import com.ca.digital.utility.CommonHelper;

/**
 * @author nalch04
 *
 */

@RestController
@Service(value="trailOrchestrator")
public class TrailOrchestrator implements ServiceExecutor {
	@Autowired
	@Qualifier(value="trailRequestManager")
	TrailRequestManager trailRequestManager;
	ApplicationContext appContext;
//	ServiceAction serviceAction;
//	@Autowired
//	TrailOrchestrator trailOrchestrator;
	Object trailIdForTasks=null;
	Map<Integer, List<TaskDetailsVO>> taskDetailsListMap=null;
	List<ClientResponse> clientResponseList=new ArrayList<ClientResponse>();
	@Autowired
	static DigitalRequest digitalRequest;
	@Autowired
	@Qualifier(value="commonHelper")
	CommonHelper commonHelper;
	@Autowired
	static TrailRequestVO trailRequestVO;
	Map<String,Object> responseMap=new LinkedHashMap<String,Object>();
//	@PreConstruct
	public void init() {
		System.out.println("in Init");
		taskDetailsListMap=(Map<Integer, List<TaskDetailsVO>>) trailRequestManager.getTaskDetailsForTrailId(trailIdForTasks.toString());
		System.out.println("taskDetailsListMap "+taskDetailsListMap);
	}
//	public void init() {
//		// TODO Auto-generated method stub
//		
//	}

//	public Object execute(Object trailId) {
//		return trailRequestManager.getTaskDetailsForTrailId(trailId.toString());
//	}
	@RequestMapping (value ="/processTrail", method = RequestMethod.POST )
	@ResponseBody
	public Object execute(@RequestBody DigitalRequest responseDC) {
		trailIdForTasks=responseDC.getTrailId();
		try{
			this.init();
			Iterator entries = taskDetailsListMap.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry<Integer,List<TaskDetailsVO>> entry = (Entry<Integer, List<TaskDetailsVO>>) entries.next();
			    Integer key = entry.getKey();
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
			    	if(response!=null && taskDetails.getTrialActionName()!=null){
			    		responseMap.put(taskDetails.getTrialActionName(),response);
			    	}else if(taskDetails.getTrialActionName()!=null){
			    		responseMap.put(taskDetails.getTrialActionName(),"");
			    	}
			    }
			    
			    

			}

		}catch (Exception e){
			e.printStackTrace();
		}
				return responseMap;
	}
//	public Object execute() {
//		return null;
//		
//	}
//	public Object collectResponse(List<Object> obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
