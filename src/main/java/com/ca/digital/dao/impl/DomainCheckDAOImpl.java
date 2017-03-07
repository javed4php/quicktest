package com.ca.digital.dao.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ca.digital.dao.BaseHibernateDAO;
import com.ca.digital.dao.DomainCheckDAO;
import com.ca.digital.entity.DomainDTO;



@SuppressWarnings("rawtypes")
@Repository("domainCheckDAO")
public class DomainCheckDAOImpl extends BaseHibernateDAO implements DomainCheckDAO {
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void setClassForDao(){
		setDAOClass(DomainCheckDAOImpl.class);
	}
	
	public Long verifyDomainName(String strDomainName,String strTrialId,SessionFactory sessionFactory){
		
		String strQuery = "from DomainDTO as domainDTO where domainDTO.domainName= :domainName";
		DomainDTO domainDTO = getDomainDetails(strQuery,strDomainName,sessionFactory);
		String strQuery1 = "select count(*) from DomainTrialDTO as domainTrial where domainTrial.trialId= :trialId and (domainTrial.domainID= :domainId or domainTrial.categoryId= :categoryId)";
		Long count = verifyDomainName(strQuery1,domainDTO,strTrialId,sessionFactory);
		return count;		  
	}
    	  
}
