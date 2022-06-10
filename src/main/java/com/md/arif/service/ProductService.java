package com.md.arif.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.md.arif.dto.ProductResponse;
import com.md.arif.model.Product;
import com.md.arif.repository.ProductRestRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRestRepository productrepository;
	
	public Product addProduct(Product product) {
		return productrepository.save(product);
	}
	
	public List<Product> getAllProducts() {
		return (List<Product>) productrepository.findAll();
}
	
	public Optional<Product> getProductById(int productId){
		return productrepository.findById(productId);
	}
	
	/*
	public List<ProductResponse> getProductJoinInfo(){
		return productrepository.getJoinInformation();
	}*/
	
	public Product updateProduct(Product product) {
		 Optional<Product> pro= productrepository.findById(product.getProductId());
		
		 pro.get().setProductName(product.getProductName());
		pro.get().setPrice(product.getPrice());
		pro.get().setBrand(product.getBrand());
		return productrepository.save(pro.get());
	}
	
	public String deleteProduct(int productId) {
		Optional<Product> pro=productrepository.findById(productId);
		productrepository.delete(pro.get());
		return "Product Removerd Succesfully";
	}
}

