package com.md.arif.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.md.arif.dto.OrderResponse;
import com.md.arif.model.Order;
import com.md.arif.repository.OrderRestRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRestRepository orderRepository;
	
	public Order placeOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> getAllPlacedOrders(){
		return (List<Order>) orderRepository.findAll();
	}
	
	public Optional<Order> getOrderById(int orderId) {
		return orderRepository.findById(orderId);
	}
	/*
	public List<OrderResponse> getOrderJoinInfo(){
		return orderRepository.getJoinInformation();
	}*/
	
	public Order updateOrderDetails(Order order) {
		Optional<Order> ord=orderRepository.findById(order.getOrderId());
		ord.get().setOrderDeliveredDate(order.getOrderDeliveredDate());
		ord.get().setOrderDispatchedDate(order.getOrderDispatchedDate());
		ord.get().setOrderPlacedDate(order.getOrderPlacedDate());
		ord.get().setOrderStatus(order.getOrderStatus());
		ord.get().setPaymentSource(order.getPaymentSource());
		ord.get().setPaymentStatus(order.isPaymentStatus());
		ord.get().setCustomer(order.getCustomer());
		ord.get().setProduct(order.getProduct());
		
		return orderRepository.save(ord.get());
	}
	
	public String deleteOrderDetails(int orderId) {
		Optional<Order> ord=orderRepository.findById(orderId);
		orderRepository.delete(ord.get());
		return "Order Deleted Successfully";
	}
}
