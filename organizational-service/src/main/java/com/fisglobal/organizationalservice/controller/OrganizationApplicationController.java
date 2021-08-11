package com.fisglobal.organizationalservice.controller;

import java.util.List;

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

import com.fisglobal.organizationalservice.exception.RecordNotFound;
import com.fisglobal.organizationalservice.model.Organization;
import com.fisglobal.organizationalservice.repository.OrganizationRepository;

@RestController
@RequestMapping("/api/organization")
public class OrganizationApplicationController {
	
	@Autowired
	private OrganizationRepository organizationRespository;
	
	@GetMapping("all")
	public ResponseEntity<?> getAllOrganization()
	{
		List<Organization> organization= organizationRespository.findAll();
		if(organization.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(organization);
		}
		else {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records Found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("id") String id) throws RecordNotFound
	{
		Organization organization= organizationRespository.findById(id).orElseThrow(()-> new RecordNotFound("Organization not found::"+id));
		return ResponseEntity.ok().body(organization);
	/* (	if(optional.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No records Found");
		}*/
	}
	
	@PostMapping("/createOrganization")
	public ResponseEntity<?> createOrganization(@Valid @RequestBody  Organization organization)
	{
		if(organizationRespository.existsById(organization.getOrg_id()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("records already exists");
		}
		Organization o1= organizationRespository.save(organization);
		
		System.out.println(o1);
		if(o1!=null)
		return ResponseEntity.status(201).body(organization);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No records Found");
	}

	

}
