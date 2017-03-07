/**
 * 
 */
package com.ca.digital.dao;

import java.util.List;

import org.hibernate.SessionFactory;

/**
 * @author nalch04
 * @param <T>
 *
 */
public interface BaseDAO<BaseDTO> {

	public Integer create(final BaseDTO entity,SessionFactory sessionFactory) throws Exception;

	public List<BaseDTO> getAll(String className,SessionFactory sessionFactory) throws Exception;

	public void update(final BaseDTO entity,SessionFactory sessionFactory) throws Exception;

	public void delete(final BaseDTO entity,SessionFactory sessionFactory) throws Exception;

	public void deleteById(final Long entityId,SessionFactory sessionFactory) throws Exception;

}
