package com.md.arif.model;

import java.math.BigDecimal;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Product")
public class Product {

	@Id
	@Column(name="Product_Id")
	private int productId;
	
	@Column(name="Product_Name")
	private String productName;
	
	@Column(name="Price")
	private BigDecimal price;
	
	@ManyToOne(targetEntity = Brand.class, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="Brand_Id", referencedColumnName = "Brand_id")
	private  Brand brand;

	public Product() {
		
	}


	public Product(int productId, String productName, BigDecimal price, Brand brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.brand = brand;
	}

	public Product(String productName, BigDecimal price, Brand brand) {
		super();
		this.productName = productName;
		this.price = price;
		this.brand = brand;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", brand="
				+ brand + "]";
	}

	
}
