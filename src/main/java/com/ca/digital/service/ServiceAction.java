package com.ca.digital.service;


public interface ServiceAction {
	
	public void init() ;
	
	public Object execute(Object object);
	
	public void getResponse();

}
