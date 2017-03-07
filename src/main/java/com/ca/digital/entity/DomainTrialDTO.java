package com.ca.digital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dbo.Domain_Trial")
public class DomainTrialDTO {

	@Id
    @Column(name="Serial")
    private String serial;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Column(name="DomainID")
	private String domainID;
	public String getDomainID() {
		return domainID;
	}

	public void setDomainID(String domainID) {
		this.domainID = domainID;
	}

	@Column(name="TrialID")
	private String trialId;
	public String getTrialId() {
		return trialId;
	}

	public void setTrialId(String trialId) {
		this.trialId = trialId;
	}

	@Column(name="CategoryID")
	private String categoryId;	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
