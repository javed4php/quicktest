/**
 * 
 */
package com.ca.digital.manager;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ca.digital.service.vo.TaskDetailsVO;

/**
 * @author nalch04
 *
 */
@Component("trailRequestManager")
public interface TrailRequestManager {
	public Map<Integer,List<TaskDetailsVO>> getTaskDetailsForTrailId(String trailId);
	public Integer createTrailRequest(Object dto);
}
