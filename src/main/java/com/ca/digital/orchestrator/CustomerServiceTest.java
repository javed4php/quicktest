package com.ca.digital.orchestrator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ca.digital.service.ServiceAction;


public class CustomerServiceTest {
//	@Autowired
//	@Qualifier(value="customerService")
//	CustomerService customerService;
	public static void main(String[] args){
		
		ApplicationContext appContext =
		    	  new ClassPathXmlApplicationContext("config/spring-config.xml");
//		  ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		ServiceAction serviceAction = appContext.getBean(ServiceAction.class);
		
		 System.out.println("customerService "+serviceAction);
		  //List<Customer> customers=customerService.getAllCustomers();
		 /*for(Customer customer:customers){
			  System.out.println("First Name: " + customer.getFirstName()); 
		  }*/
		 Object customers=serviceAction.execute(null);
		 System.out.println("JSON Output ::::::: "+customers.toString());
		  
	}
}
