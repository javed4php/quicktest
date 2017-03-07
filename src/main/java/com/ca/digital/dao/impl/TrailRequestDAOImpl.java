/**
 * 
 */
package com.ca.digital.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ca.digital.dao.BaseHibernateDAO;
import com.ca.digital.dao.TrailRequestDAO;
import com.ca.digital.entity.ProductTrailActionsConfigDTO;
import com.ca.digital.entity.TrialRequestDTO;

/**
 * @author nalch04
 *
 */
@SuppressWarnings("rawtypes")
@Repository("trailRequestDAO")
public class TrailRequestDAOImpl extends BaseHibernateDAO implements TrailRequestDAO {
	public List<ProductTrailActionsConfigDTO> getTaskDetailsForTrailId(String trailId,SessionFactory sessionFactory){
		System.out.println("TrailRequestDAOImpl criteria "+trailId);
		Criteria criteria = createCriteria(ProductTrailActionsConfigDTO.class,"productTrialActionsConfig",sessionFactory);
			criteria.add( Restrictions.eq( "productTrialActionsConfig.trialID", Integer.parseInt(trailId)))
			.add( Restrictions.ge( "productTrialActionsConfig.execSequence", 0))
			.addOrder(Order.asc("execSequence"));
//			.createCriteria("productTrialActionsConfig.productTrialActionsDTO" , "productTrialActions");
//	            .add(Restrictions.eq("productTrialActionsConfig.TrialActionID", "productTrialActions.trialActionID"))
//	            .addOrder(Order.asc("execSequence"));
//			Criteria c = session.createCriteria(ProductTrailActionsConfigDTO.class, "productTrailActionsConfig");
//			c.createAlias("productTrailActionsConfig.ProductTrialActionsDTO", "productTrialActions"); // inner join by default
//			c.add(Restrictions.eq("productTrialActionsConfig.trialActionID", "productTrialActions.trialActionID"));
//			c.addOrder( Property.forName("productTrialActionsConfig.ExecSequence").asc() );
//			return c.list();
	    System.out.println("criteria 1 __   _ "+criteria);
		List<ProductTrailActionsConfigDTO> taskDetailsList=criteria.list();
		System.out.println("taskDetailsList 1 __   _ "+taskDetailsList+ "size "+taskDetailsList.size());    
		
		return taskDetailsList;
	}
	

	@SuppressWarnings("unchecked")
	public Integer createTrailRequest(TrialRequestDTO dto,SessionFactory sessionFactory ) {
		// TODO Auto-generated method stub
		System.out.println("In TrailRequestDAOImpl for createTrailRequest");
		
		Integer result = create(TrialRequestDTO.class,sessionFactory );
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void setClassForDao(){
		setDAOClass(TrailRequestDAOImpl.class);
	}
}
