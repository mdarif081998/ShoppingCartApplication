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

//import com.md.arif.dto.OrderResponse;
import com.md.arif.model.Customer;
import com.md.arif.model.Order;
import com.md.arif.repository.CustomerRestRepository;
import com.md.arif.service.OrderService;

@RestController
public class OrderController {

	
	@SuppressWarnings("unused")
	@Autowired
	private Order order;
	
	@Autowired
	private OrderService orderService;
	
	@SuppressWarnings("unused")
	@Autowired
	private Customer customer;
	
	@Autowired
	private CustomerRestRepository customerRepository;
	
	@GetMapping("/orders/v1/get/info")
	public List<Order> getAllPlacedOrderDetails(){
		return orderService.getAllPlacedOrders();
	}
	
	@PostMapping("/orders/v1/post/placeorder")
	public Order addPlacedOrder(@RequestBody Order order) {
		return orderService.placeOrder(order);
	}
	
	@GetMapping("/orders/v1/get/info/{id}")
	public Order getOrderById(@PathVariable("id") int id) {
		Optional<Order> ord=orderService.getOrderById(id);
		return ord.get();
	}
	
	@PutMapping("/orders/v1/put/info/{id}")
	public Order updateOrderDetails(@PathVariable("id") int id, @RequestBody Order order) {
		order.setOrderId(id);
		return orderService.updateOrderDetails(order);
	}
	
	@DeleteMapping("/orders/v1/delete/{id}")
	public String deleteOrderDetails(@PathVariable("id") int id) {
		return orderService.deleteOrderDetails(id);
	}
	/*
	@GetMapping("/order/v1/get/jointable")
	public List<OrderResponse> getJoinTableDetails(){
		return orderService.getOrderJoinInfo();
	}*/
	
	@GetMapping("/orders/v1/get/customer")
	public List<Customer> getAllCustomerDetails(){
		return (List<Customer>) customerRepository.findAll();
	}
}
