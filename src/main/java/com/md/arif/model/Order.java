package com.md.arif.model;



import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="OrderDetails")
public class Order {

	@Id
	@Column(name="Order_Id")
	private int orderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Order_Placed_Date", columnDefinition = "DATE")
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date orderPlacedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Order_Dispatched_Date", columnDefinition = "DATE")
	private Date orderDispatchedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Order_Delivered_Date", columnDefinition = "DATE")
	private Date orderDeliveredDate;
	
	@Column(name="Order_Status")
	private String orderStatus;
	
	@Column(name="Payment_Source")
	private String paymentSource;
	
	@Column(name="Payment_Status")
	private boolean paymentStatus;
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="Customer_Id", referencedColumnName = "Customer_Id")
	private Customer customer;
	
	@ManyToOne(targetEntity = Product.class,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="Product_Id", referencedColumnName = "Product_Id")
	private Product product;
	

	public Order() {
		
	}
	


	public Order( int orderId, Date orderPlacedDate, Date orderDispatchedDate, Date orderDeliveredDate,
			String orderStatus, Customer customer, Product product, String paymentSource,
			boolean paymentStatus) {
		super();
		this.orderId = orderId;
		this.orderPlacedDate = orderPlacedDate;
		this.orderDispatchedDate = orderDispatchedDate;
		this.orderDeliveredDate = orderDeliveredDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.product = product;
		this.paymentSource = paymentSource;
		this.paymentStatus = paymentStatus;
	}



	public Order(Date orderPlacedDate, Date orderDispatchedDate, Date orderDeliveredDate, String orderStatus,
			String paymentSource, boolean paymentStatus, Customer customer, Product product) {
		super();
		this.orderPlacedDate = orderPlacedDate;
		this.orderDispatchedDate = orderDispatchedDate;
		this.orderDeliveredDate = orderDeliveredDate;
		this.orderStatus = orderStatus;
		this.paymentSource = paymentSource;
		this.paymentStatus = paymentStatus;
		this.customer = customer;
		this.product = product;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderPlacedDate() {
		return orderPlacedDate;
	}

	public void setOrderPlacedDate(Date orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}

	public Date getOrderDispatchedDate() {
		return orderDispatchedDate;
	}

	public void setOrderDispatchedDate(Date orderDispatchedDate) {
		this.orderDispatchedDate = orderDispatchedDate;
	}

	public Date getOrderDeliveredDate() {
		return orderDeliveredDate;
	}

	public void setOrderDeliveredDate(Date orderDeliveredDate) {
		this.orderDeliveredDate = orderDeliveredDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	

	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public String getPaymentSource() {
		return paymentSource;
	}

	public void setPaymentSource(String paymentSource) {
		this.paymentSource = paymentSource;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderPlacedDate=" + orderPlacedDate + ", orderDispatchedDate="
				+ orderDispatchedDate + ", orderDeliveredDate=" + orderDeliveredDate + ", orderStatus=" + orderStatus
				+ ", customer=" + customer + ", product=" + product + ", paymentSource=" + paymentSource
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}
