package com.md.arif;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.md.arif.model.Brand;
import com.md.arif.model.Customer;
import com.md.arif.model.Order;
import com.md.arif.model.Product;
import com.md.arif.service.OrderService;


@SpringBootTest
class OrderServiceTestsTest {

	
	@Autowired
	private OrderService orderservice;
	
	
	@Test
	public void PlaceOrdertest() {
		Brand brand = new Brand(5, "HP", true, 15);
		Product product = new Product(5, "Mouse",BigDecimal.valueOf(599.0), brand);
		Customer customer = new Customer(5, "Ismail",9018374849l,"Gulbarga",585222);
		Order order= new Order(5,new Date (2021-01-01), new Date (2021-01-03),new Date (2021-01-05),
				"Delivered",customer,product,"Cash",true);
		Order result = orderservice.placeOrder(order);
		assertThat(result.equals(order));
	}

	@Test
	public void GetAllPlacedOrders() {
		List<Order> order = orderservice.getAllPlacedOrders();
		assertThat(order.size()).isGreaterThan(0);
	}
	
	@Test
	public void GetOrderByIdTest() {
		Order order=orderservice.getOrderById(1).get();
		assertThat(order.getOrderId()).isEqualTo(1);
	}
	
	@Test
	public void UpdateOrderDetailsTest() {
		Order order = orderservice.getOrderById(1).get();
		order.setPaymentSource("NEFT");
		Order orderupdated= orderservice.updateOrderDetails(order);
		assertThat(orderupdated.getPaymentSource()).isEqualTo("NEFT");
	}
	
	@Test
	public void DeleteOrderDetailsTest() {
		Brand brand = new Brand(5, "HP", true, 15);
		Product product = new Product(5, "Mouse",BigDecimal.valueOf(599.0), brand);
		Customer customer = new Customer(5, "Ismail",9018374849l,"Gulbarga",585222);
		Order order= new Order(5,new Date (2021-01-01), new Date (2021-01-03),new Date (2021-01-05),
				"Delivered",customer,product,"Cash",true);
		orderservice.placeOrder(order);
		String result=orderservice.deleteOrderDetails(5);
		assertEquals("Order Deleted Successfully", result);
	}
}
