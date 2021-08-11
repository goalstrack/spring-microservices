package com.fisglobal.departmentservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.departmentservice.exception.RecordNotFound;
import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("all")
	public ResponseEntity<?> getAllDepartment()
	{
		List<Department> department= departmentRepository.findAll();
		if(department.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(department);
		}
		else {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records Found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("id") long id) throws RecordNotFound
	{
		Department department= departmentRepository.findById(id).orElseThrow(()-> new RecordNotFound("Employee not found::"+id));
		return ResponseEntity.ok().body(department);
	/* (	if(optional.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No records Found");
		}*/
	}
	
	@PostMapping("/createDepartment")
	public ResponseEntity<?> createDepartment(@Valid @RequestBody  Department department)
	{
		if(departmentRepository.existsById(department.getDepartmentId()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("records already exists");
		}
		Department d1= departmentRepository.save(department);
		
		System.out.println(d1);
		if(d1!=null)
		return ResponseEntity.status(201).body(department);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No records Found");
	}

}
