package com.ca.digital.dao;

import org.hibernate.SessionFactory;


public interface DomainCheckDAO {
	
	public Long verifyDomainName(String strDomainName,String strTrialId,SessionFactory sessionFactory);

}
