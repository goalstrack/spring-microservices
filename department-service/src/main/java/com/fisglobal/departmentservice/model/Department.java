package com.fisglobal.departmentservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "NewDepartment")
public class Department {
	
	
	@Id	
	private long departmentId;
	@Size(min=2 , max=20 , message="Department Name should have 2 chars atleast")
	private String departmentName;
	@NotNull
	@Size(min=2, max=15 , message="Location should have 2 chars atleast")
	private String location;	
	@NotNull
	private int noOfEmployee;		
	@NotNull
	@Email
	private String email;

}
