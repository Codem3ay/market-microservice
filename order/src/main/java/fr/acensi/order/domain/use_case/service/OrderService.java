package fr.acensi.order.domain.use_case.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.acensi.order.domain.entities.Order;
import fr.acensi.order.domain.use_case.port.OrderPort;

@Component
public class OrderService {
	
	private final OrderPort orderPort;

	public OrderService(OrderPort orderPort) {
		super();
		this.orderPort = orderPort;
	}
	
	public List<Order> getAllOrders() {
		return orderPort.getAllOrders();
	}
	
	public Optional<Order> getOrderById(Long orderId){
		return orderPort.getOrderById(orderId);
	}
	
	public Order saveOrder(Order order) {
		return orderPort.saveOrder(order);
	}
	
	public void deleteOrderById(Long orderId) {
		orderPort.deleteOrderById(orderId);
	}

}
