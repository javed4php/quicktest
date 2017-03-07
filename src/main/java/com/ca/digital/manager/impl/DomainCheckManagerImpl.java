package com.ca.digital.manager.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ca.digital.dao.DomainCheckDAO;
import com.ca.digital.manager.DomainCheckManager;
import com.ca.digital.utility.CommonHelper;


@Component
@Qualifier("domainCheckManager")
@Transactional

public class DomainCheckManagerImpl implements DomainCheckManager {
	
	@Autowired
	DomainCheckDAO domainCheckDAO;
	@Autowired
	@Qualifier(value="commonHelper")
	CommonHelper commonHelper;
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Long verifyDomainName(String strDomainName, String strTrialId) {
		return domainCheckDAO.verifyDomainName(strDomainName,strTrialId,sessionFactory);
		//commonHelper.convertToDTO();
	}

}
