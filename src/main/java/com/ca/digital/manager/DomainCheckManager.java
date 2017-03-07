package com.ca.digital.manager;

import org.springframework.stereotype.Component;


@Component("domainCheckManager")
public interface DomainCheckManager extends BaseManager{
	
	public Long verifyDomainName(String strDomainName,String strTrialId);

}
