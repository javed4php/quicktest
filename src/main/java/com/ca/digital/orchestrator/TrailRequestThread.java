package com.ca.digital.orchestrator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ca.digital.service.vo.TaskDetailsVO;
import com.ca.digital.utility.CommonHelper;

public class TrailRequestThread extends Thread {
	TaskDetailsVO taskDetails=null;
	@Autowired
	CommonHelper commonHelper;
	Object response = null;
	String serviceName=null;
	Map<String, Object> responseInputMap=null;
	public TrailRequestThread(TaskDetailsVO taskDetails, Map<String, Object> responseMap) {
		this.taskDetails=taskDetails;
		serviceName=taskDetails.getTrialActionName();
		responseInputMap=responseMap;
	}

	public void run() {
		response = commonHelper.executeTrialTasks(taskDetails,responseInputMap);
	}

	public Object getResponseForThread(){
		return response;
	}
	public String getServiceName(){
		return serviceName;
	}
}
