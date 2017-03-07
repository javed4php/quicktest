package com.ca.digital.manager;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
@Component("baseManager")
public interface BaseManager {
//		@Autowired
//		SessionFactory sessionFactory;

		public SessionFactory getSessionFactory();

		public void setSessionFactory(SessionFactory sessionFactory);
}
