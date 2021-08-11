package com.fisglobal.organizationalservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="organization")
public class Organization {
	
	@Id
	private String Org_id;
	
	@NotNull
	@Size(min=2,max=20,message="Organization name should have atleast 2 chars")
	private String Org_name;
	

	@NotNull
	@Size(min=2,max=20,message="Location should have atleast 2 chars")
	private String location;

}
