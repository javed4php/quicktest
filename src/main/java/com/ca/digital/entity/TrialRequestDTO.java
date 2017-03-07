/**
 * 
 */
package com.ca.digital.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author nalch04
 *
 */
@Entity
@Table(name="TrialSource")

public class TrialRequestDTO  implements Serializable,BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="trailreqinc" , strategy="increment")
	@GeneratedValue(generator="trailreqinc")
    @Column(name="TrialTransactionID, nullable = true")
	private Integer trailTransactionID;

    @Column(name="Status")
    private String status;

	@Column(name="Active")
	private boolean active;

	@Column(name="CreatedDate")
	private Timestamp createdDate;

	@Column(name="UpdatedDate")
	private Timestamp updatedDate;
    
    @Column(name="TrialSourceID")
    private Integer trailSourceID;
    
    @Column(name="TrialID")
    private Integer trailID;
    
	@Column(name="UserId")
	private Integer userId;
	
    @Column(name="MDRCode")
    private String mdrCode;

	/**
	 * @return the trailTransactionID
	 */
	public Integer getTrailTransactionID() {
		return trailTransactionID;
	}

	/**
	 * @param trailTransactionID the trailTransactionID to set
	 */
	public void setTrailTransactionID(Integer trailTransactionID) {
		this.trailTransactionID = trailTransactionID;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the trailSourceID
	 */
	public Integer getTrailSourceID() {
		return trailSourceID;
	}

	/**
	 * @param trailSourceID the trailSourceID to set
	 */
	public void setTrailSourceID(Integer trailSourceID) {
		this.trailSourceID = trailSourceID;
	}

	/**
	 * @return the trailID
	 */
	public Integer getTrailID() {
		return trailID;
	}

	/**
	 * @param trailID the trailID to set
	 */
	public void setTrailID(Integer trailID) {
		this.trailID = trailID;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the mdrCode
	 */
	public String getMdrCode() {
		return mdrCode;
	}

	/**
	 * @param mdrCode the mdrCode to set
	 */
	public void setMdrCode(String mdrCode) {
		this.mdrCode = mdrCode;
	}
	
}
