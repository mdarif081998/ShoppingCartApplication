package com.md.arif.repository;

//import java.math.BigDecimal;
import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

//import com.md.arif.dto.ProductResponse;
import com.md.arif.model.Product;

@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProductRestRepository extends
PagingAndSortingRepository<Product, Integer> {
	
List<Product> findByProductName(@Param("productName") String productName);
List<Product> findByBrand(@Param("brandName") String brandName);
/*
@Query("SELECT p FROM Product p WHERE p.price BETWEEN ? and ?") 
List<Product> findByPriceRange(BigDecimal minimim, BigDecimal maximum);

@Query("SELECT p FROM Product p WHERE p.product_name LIKE %?1%"
        + " OR p.brandName LIKE %?1%")
List<Product> search(String keyword);
*/
/*
@Query("SELECT new com.md.arif.dto.ProductResponse(p , b) FROM Product p JOIN p.Brand b")
public List<ProductResponse> getJoinInformation();
*/

}

