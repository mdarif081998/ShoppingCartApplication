package com.md.arif.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Brand")
public class Brand {
	
	@Id
	@Column(name="Brand_Id")
	private int brandId;
	
	@Column(name="Brand_Name")
	private String brandName;
	
	@Column(name="Brand_Availible_Status")
	private boolean brandAvailStatus;
	
	@Column(name="Quantity")
	private int quantity;

	public Brand() {
		
	}
	
	

	public Brand(int brandId, String brandName,  boolean brandAvailStatus,int quantity ) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandAvailStatus = brandAvailStatus;
		this.quantity = quantity;
	}



	public Brand(String brandName, boolean brandAvailStatus, int quantity) {
		super();
		this.brandName = brandName;
		this.brandAvailStatus = brandAvailStatus;
		this.quantity = quantity;
	}



	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public boolean isBrandAvailStatus() {
		return brandAvailStatus;
	}

	public void setBrandAvailStatus(boolean brandAvailStatus) {
		this.brandAvailStatus = brandAvailStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", brandAvailStatus=" + brandAvailStatus
				+ ", quantity=" + quantity + "]";
	}

}
