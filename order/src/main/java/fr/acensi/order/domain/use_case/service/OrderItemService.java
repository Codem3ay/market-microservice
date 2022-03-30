package fr.acensi.order.domain.use_case.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.acensi.order.domain.entities.OrderItem;
import fr.acensi.order.domain.use_case.port.OrderItemPort;

@Component
public class OrderItemService {
	
	
	private final OrderItemPort orderItemPort;
	
	public OrderItemService(OrderItemPort orderItemPort) {
		this.orderItemPort = orderItemPort;
	}
	
	public List<OrderItem> getAllOrderItems() {
		return orderItemPort.getAllOrderItems();
	}
	
	public Optional<OrderItem> getOrderItemById(Long orderItemId) {
		return orderItemPort.getOrderItemById(orderItemId);
	}
	
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemPort.saveOrderItem(orderItem);
	}
	
	public void deleteOrderItemById(Long orderItemId) {
		orderItemPort.deleteOrderItemById(orderItemId);
	}
	
}
