/**
 * 
 */
package com.ca.digital.manager.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ca.digital.dao.TrailRequestDAO;
import com.ca.digital.entity.ProductTrailActionsConfigDTO;
import com.ca.digital.entity.TrialRequestDTO;
import com.ca.digital.manager.TrailRequestManager;
import com.ca.digital.service.vo.TaskDetailsVO;
import com.ca.digital.service.vo.TrailRequestVO;
import com.ca.digital.utility.CommonHelper;

/**
 * @author nalch04
 *
 */
@Component
@Qualifier("trailRequestManager")
@Transactional
public class TrailRequestManagerImpl implements TrailRequestManager {
	@Autowired
	TrailRequestDAO trailRequestDAO;
	@Autowired
	@Qualifier(value="commonHelper")
	CommonHelper commonHelper;
	@Autowired
	SessionFactory sessionFactory;
	public Map<Integer, List<TaskDetailsVO>> getTaskDetailsForTrailId(String trailId){
		List<ProductTrailActionsConfigDTO> taskDetailsDTOList = trailRequestDAO.getTaskDetailsForTrailId(trailId,sessionFactory );
		return commonHelper.convertToTaskDetailsVO(taskDetailsDTOList);
	}
	public Integer createTrailRequest(Object obj) {
		// TODO Auto-generated method stub
		Integer respcustomerDTO = null;
		TrialRequestDTO trailRequestDTO = null;
		System.out.println("In Manager for createCustomer");

		trailRequestDTO = (TrialRequestDTO)commonHelper.convertToTrailRequestDTO((TrailRequestVO)obj);

		//commonHelper.convertToVO();
		try{
			respcustomerDTO = trailRequestDAO.createTrailRequest(trailRequestDTO,sessionFactory );	
			if(respcustomerDTO>0){
				System.out.println("Transaction Recored Inserted and Transaction ID Is ::::  "+respcustomerDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return respcustomerDTO;
	}
}
