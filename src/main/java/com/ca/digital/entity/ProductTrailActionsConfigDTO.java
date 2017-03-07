package com.ca.digital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="dbo.ProductTrialActionsConfig")
public class ProductTrailActionsConfigDTO implements BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3670878720414796977L;

	@Id
	@Column(name="ActionID")
	private int actionID;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="ExecSequence")
	private Integer execSequence;
	
	@Column(name="TrialID")
	private int trialID;
	
	
	@OneToOne(optional=false)
	@JoinColumn(foreignKey = @ForeignKey(name = "ProductTrialActionsConfig_ProductTrialActions_FK") , name="trialActionID") 
	private ProductTrialActionsDTO productTrialActionsDTO;


	public int getActionID() {
		return actionID;
	}


	public void setActionID(int actionID) {
		this.actionID = actionID;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getExecSequence() {
		return execSequence;
	}


	public void setExecSequence(Integer execSequence) {
		this.execSequence = execSequence;
	}

	public ProductTrialActionsDTO getProductTrialActionsDTO() {
		return productTrialActionsDTO;
	}


	public void setProductTrialActionsDTO(ProductTrialActionsDTO productTrialActionsDTO) {
		this.productTrialActionsDTO = productTrialActionsDTO;
	}


	/**
	 * @return the trialID
	 */
	public int getTrialID() {
		return trialID;
	}


	/**
	 * @param trialID the trialID to set
	 */
	public void setTrialID(int trialID) {
		this.trialID = trialID;
	}
	
	
}
