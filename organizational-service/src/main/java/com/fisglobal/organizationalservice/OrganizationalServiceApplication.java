package com.fisglobal.organizationalservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.organizationalservice.model.Organization;
import com.fisglobal.organizationalservice.repository.OrganizationRepository;

@SpringBootApplication
public class OrganizationalServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(OrganizationalServiceApplication.class, args);
	    OrganizationRepository organization=context.getBean(OrganizationRepository.class);
	    /*Organization org=new Organization("int01", "fisglobal", "Philipines");
	    Organization org1=new Organization("int02", "wipro", "Banglore");
	    Organization org2=new Organization("int03", "tcs", "Mumbai");
	    Organization org3=new Organization("int04", "persistent", "pune");
	    organization.save(org);
	    organization.save(org1);
	    organization.save(org2);
	    organization.save(org3);
	    
	    List<Organization> orgList= organization.findAll();
		orgList.forEach(System.out::println);
		context.close();*/
	    
	
	}

}
