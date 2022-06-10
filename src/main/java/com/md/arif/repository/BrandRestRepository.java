package com.md.arif.repository;


import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.md.arif.model.Brand;

@RepositoryRestResource(path = "brands", collectionResourceRel = "brandss")
public interface BrandRestRepository extends
PagingAndSortingRepository<Brand, Integer> {

	
	List<Brand> findByBrandName(@Param("brandName") String brandName);
	List<Brand> findByQuantity(@Param("quantity") int quantity);

/*
	@Query("SELECT b FROM Brand b WHERE b.brand_name LIKE %?1%")
	List<Brand> search(String keyword);
*/
	}
