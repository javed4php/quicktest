package com.ca.digital.service.vo;

public class TaskDetailsVO {

	private String trialActionName;
	
	private int trialID;
	
	private int trialActionID;
	
	private String url;
	
	private String fullyQualifiedClassName;
	
	private Integer execSequence;

	public Integer getExecSequence() {
		return execSequence;
	}

	public void setExecSequence(Integer execSequence) {
		this.execSequence = execSequence;
	}

	public String getTrialActionName() {
		return trialActionName;
	}

	public void setTrialActionName(String trialActionName) {
		this.trialActionName = trialActionName;
	}

	public int getTrialID() {
		return trialID;
	}

	public void setTrialID(int trialID) {
		this.trialID = trialID;
	}

	public int getTrialActionID() {
		return trialActionID;
	}

	public void setTrialActionID(int trialActionID) {
		this.trialActionID = trialActionID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFullyQualifiedClassName() {
		return fullyQualifiedClassName;
	}

	public void setFullyQualifiedClassName(String fullyQualifiedClassName) {
		this.fullyQualifiedClassName = fullyQualifiedClassName;
	}
	
	
}
