/**
 * 
 */
package com.ca.digital.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ca.digital.entity.ProductTrailActionsConfigDTO;
import com.ca.digital.entity.TrialRequestDTO;

/**
 * @author nalch04
 *
 */

public interface TrailRequestDAO {
	public List<ProductTrailActionsConfigDTO> getTaskDetailsForTrailId(String trailId,SessionFactory sessionFactory );
	public Integer createTrailRequest(TrialRequestDTO dto,SessionFactory sessionFactory );
}
