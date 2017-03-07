package com.ca.digital.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ProductTrialActions database table.
 * 
 */
@Entity
@Table(name="dbo.ProductTrialActions")
//@NamedQuery(name="ProductTrialActionsDTO.findAll", query="SELECT p FROM ProductTrialActionsDTO p")
public class ProductTrialActionsDTO implements BaseDTO{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TrialActionID")
	private int trialActionID;

	@Column(name="Description")
	private String description;

	@Column(name="TrialActionName")
	private String trialActionName;
	
	@Column(name="Url")
	private String url;
	
	@Column(name="fullyQualifiedClassName")
	private String fullyQualifiedClassName;

	public ProductTrialActionsDTO() {
	}

	public int getTrialActionID() {
		return this.trialActionID;
	}

	public void setTrialActionID(int trialActionID) {
		this.trialActionID = trialActionID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrialActionName() {
		return this.trialActionName;
	}

	public void setTrialActionName(String trialActionName) {
		this.trialActionName = trialActionName;
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