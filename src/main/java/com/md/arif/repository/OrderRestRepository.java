package com.md.arif.repository;

import java.util.Date;
import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//import com.md.arif.dto.OrderResponse;
import com.md.arif.model.Order;


@RepositoryRestResource(path = "orders", collectionResourceRel = "orders")
public interface OrderRestRepository extends
PagingAndSortingRepository<Order, Integer> {

		
	List<Order> findByOrderPlacedDate(@Param("orderPlacedDate") Date orderPlacedDate);
	List<Order> findByOrderDispatchedDate(@Param("orderDispatchedDate") Date orderDispatchedDate);
	List<Order> findByOrderDeliveredDate(@Param("orderDeliveredDate") Date orderDeliveredDate);
	List<Order> findByOrderStatus(@Param("orderStatus") String orderStatus);
	//List<Order> findByCustomerId(@Param("customerId") int customerId);
	//List<Order> findByProductId(@Param("productId") int productId);
	List<Order> findByPaymentSource(@Param("paymentSource") String paymentSource);
	
	List<Order> findByPaymentStatus(@Param("paymentStatus") boolean paymentStatus);
	
	/*
	@Query("SELECT new com.md.arif.dto.OrderResponse(o, p , c) FROM Order o JOIN o.Product p, JOIN o.Customer c")
	List<OrderResponse> getJoinInformation();
*/
	}

