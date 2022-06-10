package com.md.arif.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.md.arif.dto.ProductResponse;
import com.md.arif.model.Brand;
import com.md.arif.model.Product;
import com.md.arif.repository.BrandRestRepository;
import com.md.arif.service.ProductService;

@RestController
public class ProductController {
	
	@SuppressWarnings("unused")
	@Autowired
	private Product product;
	
	@Autowired
	private ProductService productService;
	
	@SuppressWarnings("unused")
	@Autowired
	private Brand brand;
	
	@Autowired
	private BrandRestRepository brandRepository;

	@GetMapping("/products/v1/get/info")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping("/products/v1/post/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/products/v1/get/info/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		Optional<Product> pro=productService.getProductById(id);
		return pro.get();
	}
	
	@PutMapping("/products/v1/put/update/{id}")
	public Product updateProductById(@PathVariable("id") int id, @RequestBody Product product) {
		product.setProductId(id);
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/v1/delete/{id}")
	public String deleteProductById(@PathVariable("id") int id) {
		return productService.deleteProduct(id);
		
	}
	/*
	@GetMapping("/products/v1/get/jointable")
	public List<ProductResponse> getJoinTablesInfo(){
		return productService.getProductJoinInfo();
	}*/
	
	@GetMapping("/products/v1/get/brand")
	public List<Brand> getAllBrands() {
		return (List<Brand>) brandRepository.findAll();
	}
}

