package fr.acensi.order.application.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;

import fr.acensi.order.domain.entities.Order;
import fr.acensi.order.domain.entities.OrderItem;
import fr.acensi.order.domain.use_case.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderAdapter {
	
	private OrderService orderService;
	
	public OrderAdapter(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public List<OrderApi> getAllOrders(){
		return orderService.getAllOrders()
				.stream()
				.map(this::toOrderApi)
				.collect(toList());
	}
	
	private OrderApi toOrderApi(Order order) {
		OrderApi orderApi = new OrderApi();
		orderApi.setId(order.getId());
		orderApi.setDate(order.getDate());
		orderApi.setItems(order.getOrderItems().stream().map(this::toOrderItemApi).collect(toList()));
		return orderApi;
	}
	
	private OrderItemApi toOrderItemApi(OrderItem orderItem) {
		OrderItemApi orderItemApi = new OrderItemApi();
		orderItemApi.setId(orderItem.getId());
		orderItemApi.setOrderId(orderItem.getOrderId());
		orderItemApi.setProductId(orderItem.getProductId());
		orderItemApi.setQuantity(orderItem.getQuantity());
		return orderItemApi;
	}
	
}
