package com.ca.digital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dbo.Domain")
public class DomainDTO {
	
	@Id
    @Column(name="DomainID")
    private String domainId;
	
	@Column(name="DomainName")
	private String domainName;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="CategoryID")
	private String categoryId;	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
		
}
