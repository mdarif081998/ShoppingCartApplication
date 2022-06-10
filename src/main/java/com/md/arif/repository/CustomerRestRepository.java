package com.md.arif.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.md.arif.model.Customer;



@RepositoryRestResource(path = "customers", collectionResourceRel = "customers")
public interface CustomerRestRepository extends
PagingAndSortingRepository<Customer, Integer> {
	
		
	List<Customer> findByCustomerName(@Param("customerName") String customerName);
	List<Customer> findByZipCode(@Param("zipCode") int zipCode);

}
