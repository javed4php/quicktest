package com.ca.digital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="TrailSource")
public class TrailSource {
    @Id
    @Column(name="TrailSourceID")
    Integer trailSourceID;
 
    @Column(name="TrailSourceName")
    String trailSourceName;
 
    public TrailSource(Integer trailSourceID, String trailSourceName) {
        this.trailSourceID = trailSourceID;
        this.trailSourceName = trailSourceName;
    }
 
    public Integer getTrailSourceID() {
		return trailSourceID;
	}

	public void setTrailSourceID(Integer trailSourceID) {
		this.trailSourceID = trailSourceID;
	}

	public String getTrailSourceName() {
		return trailSourceName;
	}

	public void setTrailSourceName(String trailSourceName) {
		this.trailSourceName = trailSourceName;
	}

	public TrailSource() {
    }
   
}
