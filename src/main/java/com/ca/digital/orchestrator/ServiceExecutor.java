package com.ca.digital.orchestrator;


public interface ServiceExecutor {
	public void init();
	public Object execute(DigitalRequest responseDC);
	
	
}
