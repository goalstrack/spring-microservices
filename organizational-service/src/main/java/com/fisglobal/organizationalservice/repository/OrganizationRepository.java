package com.fisglobal.organizationalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisglobal.organizationalservice.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {

}
