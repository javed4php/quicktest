package com.ca.digital.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import jersey.repackaged.com.google.common.base.Preconditions;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ca.digital.entity.DomainDTO;

@Repository
public class BaseHibernateDAO<BaseDTO extends Serializable> implements BaseDAO<BaseDTO> {
	private Class<BaseDTO> daoClass;
	String basemgr=null;
//	@Autowired
//	BaseManager baseManager;

	public void setDAOClass(final Class<BaseDTO> clazzToSet) {
		this.daoClass = clazzToSet;
		
	}

	public BaseDTO getById(final Long id,SessionFactory sessionFactory) {
		Preconditions.checkArgument(id != null);
		return (BaseDTO) sessionFactory.getCurrentSession()
				.get(this.daoClass, id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BaseDTO> getByName(final String name,SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.setCacheMode(CacheMode.IGNORE);
		return (List<BaseDTO>) session.get(this.daoClass, name);
	}

	@SuppressWarnings("unchecked")
	public List<BaseDTO> getAll(String className,SessionFactory sessionFactory) {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + className).list();
	}

	public Integer create(final BaseDTO entity,SessionFactory sessionFactory) throws HibernateException {
		//Preconditions.checkNotNull(entity);
		return (Integer) sessionFactory.getCurrentSession().save(entity);
	}

	public void update(final BaseDTO entity,SessionFactory sessionFactory) {
		Preconditions.checkNotNull(entity);
		sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(final BaseDTO entity,SessionFactory sessionFactory) {
		Preconditions.checkNotNull(entity);
		sessionFactory.getCurrentSession().delete(entity);
	}

	public void deleteById(final Long entityId,SessionFactory sessionFactory) {
		final BaseDTO entity = this.getById(entityId,sessionFactory);
		Preconditions.checkState(entity != null);
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	public Long verifyDomainName(String qry,DomainDTO domainDTO,String strTrialId,SessionFactory sessionFactory) {
		//Preconditions.checkArgument(id != null);
		Query query = sessionFactory.getCurrentSession().createQuery(qry);
		query.setParameter("trialId",strTrialId );
		query.setParameter("domainId",domainDTO.getDomainId());
		query.setParameter("categoryId",domainDTO.getCategoryId());			
		Long count = (Long)query.uniqueResult();		
		return count;		
	}
	
	public DomainDTO getDomainDetails(String qry,String domainName,SessionFactory sessionFactory) {
		//Preconditions.checkArgument(id != null);
		DomainDTO domainDTO = null;
		Query query = sessionFactory.getCurrentSession().createQuery(qry);
		query.setParameter("domainName",domainName );
		for(Iterator it=query.iterate();it.hasNext();){
  		  domainDTO=(DomainDTO)it.next();        				   
		}
		return domainDTO;
		
	}

//	protected final Session getCurrentSession() {
//		return sessionFactory.getCurrentSession();
//	}
	public Criteria createCriteria( Class<BaseDTO> entity, String alias,SessionFactory sessionFactory ){
		System.out.println("sessionFactory "+sessionFactory+" entity "+entity+" alias "+alias);      
//		Preconditions.checkNotNull( entity );
	    return sessionFactory.getCurrentSession().createCriteria( entity,alias );
	}

}
