package com.ca.digital;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ca.digital.entity.CustomerDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
    	System.out.println("hai");
//    	SessionFactory sessionFactory = new Configuration().configure("C://CPQDigitalCommerce//digicommerce//src//main//resources//hibernate.cfg.xml").buildSessionFactory();
//    	Configuration  configuration = new Configuration().configure( "C:\\CPQDigitalCommerce\\digicommerce\\src\\main\\resources\\hibernate.cfg.xml");
//    	Configuration  configuration = new Configuration().configure( "");
    	Configuration configuration = new Configuration();          
    	SessionFactory sessionFactory =configuration.configure().buildSessionFactory();
//    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
//    	List<Customer> orderheaderList = session.createSQLQuery("SELECT FROM ORDER_HEADER WHERE order_name like '%Ishan%'").list();
//    	List<Customer> orderheaderList = session.createSQLQuery("SELECT FROM Customer WHERE firstName like '%Ishan%'").list();
    	Query q = session.createQuery("from Customer");
    	List customerList = session.createQuery("FROM Customer").list(); 
        for (Iterator iterator = 
     		   customerList.iterator(); iterator.hasNext();){
     	   CustomerDTO customer = (CustomerDTO) iterator.next(); 
           System.out.println("First Name: " + customer.getFirstName()); 
//           System.out.print("  Last Name: " + customer.getLastName()); 
        } 
//    	q.setString("surname", "Richard");
    	List result = q.list();
//    	Criteria cr = session.createCriteria(Customer.class);
//    	cr.add(Restrictions.eq("customerId", "123456"));
//    	List results = cr.list();
    	System.out.println("ordrHeader "+result.size());


    }
    
}
