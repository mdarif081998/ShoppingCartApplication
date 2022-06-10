package com.md.arif.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Customer")
public class Customer {

	@Id
	@Column(name="Customer_Id")
	private int customerId;
	
	@Column(name="Customer_Name")
	private String customerName;
	
	@Column(name="Contact_No")
	private long contactNo;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Zip_Code")
	private int zipCode;

	public Customer() {
		
	}
	
	public Customer(int customerId, String customerName, long contactNo, String address, int zipCode) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.address = address;
		this.zipCode = zipCode;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNo=" + contactNo
				+ ", address=" + address + ", zipCode=" + zipCode + "]";
	}
	
	
	
	
}
