package com.ca.digital.utility;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ca.digital.entity.CustomerDTO;
import com.ca.digital.entity.ProductTrailActionsConfigDTO;
import com.ca.digital.entity.TrialRequestDTO;
import com.ca.digital.service.ServiceAction;
import com.ca.digital.service.vo.CustomerVO;
import com.ca.digital.service.vo.TaskDetailsVO;
import com.ca.digital.service.vo.TrailRequestVO;

@Component("commonHelper")
public class CommonHelper {

	public CustomerVO convertToVO(CustomerDTO dto, Object vo){
		CustomerVO customerVO = (CustomerVO) vo;
		customerVO.setCustomerId(dto.getCustomerId());
		customerVO.setFirstName(dto.getFirstName());
		
		
		return customerVO;
	}
	public void convertToDTO(){
		
	}
	public void convertVOToJSON() {
		// TODO Auto-generated method stub
		
	}
	public Map<Integer,List<TaskDetailsVO>> convertToTaskDetailsVO(	List<ProductTrailActionsConfigDTO> taskDetailsDTOList) {
		Map<Integer,List<TaskDetailsVO>> taskDetailsMap=new LinkedHashMap<Integer,List<TaskDetailsVO>>();
		for(ProductTrailActionsConfigDTO productTrailActionsConfigDTO:taskDetailsDTOList){
			TaskDetailsVO taskDetailsVO=new TaskDetailsVO();
			
			taskDetailsVO.setExecSequence(productTrailActionsConfigDTO.getExecSequence());
			taskDetailsVO.setTrialID(productTrailActionsConfigDTO.getTrialID());
			taskDetailsVO.setTrialActionID(productTrailActionsConfigDTO.getProductTrialActionsDTO().getTrialActionID());
			
			taskDetailsVO.setUrl(productTrailActionsConfigDTO.getProductTrialActionsDTO().getUrl());
			taskDetailsVO.setFullyQualifiedClassName(productTrailActionsConfigDTO.getProductTrialActionsDTO().getFullyQualifiedClassName());
			if(taskDetailsMap.get(taskDetailsVO.getExecSequence())!=null){
				taskDetailsMap.get(taskDetailsVO.getExecSequence()).add(taskDetailsVO);
			}else{
				List<TaskDetailsVO> taskDetailsVOList=new ArrayList<TaskDetailsVO>();
				taskDetailsVOList.add(taskDetailsVO);
				taskDetailsMap.put(taskDetailsVO.getExecSequence(),taskDetailsVOList);
			}
		}
		return taskDetailsMap;
	}
	public TrialRequestDTO convertToTrailRequestDTO(TrailRequestVO obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object executeTrialTasks(TaskDetailsVO taskDetailsVO,Map<String, Object> responseMap){
//			Object requestObject=null;
			Object response = null;
			if(taskDetailsVO.getUrl()!=null && !taskDetailsVO.getUrl().isEmpty()){
//		        Map<String, String> params = new HashMap<String, String>();
//		        if(taskDetailsVO.getTrialActionName()!=null && DigitalConstants.PARAMSBYCLASSNAMEMAP.get(taskDetailsVO.getTrialActionName())!=null){
//		        	params=setParamsBasedOnClassName(DigitalConstants.PARAMSBYCLASSNAMEMAP.get(taskDetailsVO.getTrialActionName()));
//		        }
//		        requestObject=params;
		        RestTemplate restTemplate = new RestTemplate();
		        response = restTemplate.postForEntity( taskDetailsVO.getUrl(), responseMap, Object.class );
	
			}else if(taskDetailsVO.getFullyQualifiedClassName()!=null){
				try {
						Class<? extends ServiceAction> classObj = (Class<? extends ServiceAction>) Class.forName(taskDetailsVO.getFullyQualifiedClassName());
						if(classObj!=null){
							ServiceAction serviceActionObject = classObj.newInstance();
							response = serviceActionObject.execute(responseMap);
							
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return response;
		}
	
}
