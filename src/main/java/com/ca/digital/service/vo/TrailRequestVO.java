/**
 * 
 */
package com.ca.digital.service.vo;

import java.sql.Timestamp;

/**
 * @author nalch04
 *
 */
public class TrailRequestVO {
	
	private Integer trailTransactionID;

    private String status;

	private boolean active;

	private Timestamp createdDate;

	private Timestamp updatedDate;
    
	private Integer trailSourceID;
    
    private Integer trailID;
    
	private Integer userId;
	
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
