package com.fisglobal.departmentservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DepartmentServiceApplication.class, args);
		DepartmentRepository departmentRepository= context.getBean(DepartmentRepository.class);
		/*Department department= new Department(58, "Computer", "Pune");
		Department department1= new Department(59, "Information Technology", "Mumbai");
		Department department2= new Department(67, "Production", "Chennai");
	    departmentRepository.save(department);
	    departmentRepository.save(department1);
	    departmentRepository.save(department2);
	    
		List<Department> departmentList= departmentRepository.findAll();
		departmentList.forEach(System.out::println);
		context.close(); */
		
	}

}
