package fr.acensi.order.infrastructure.database.adapters;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import fr.acensi.order.domain.entities.Order;
import fr.acensi.order.domain.entities.OrderItem;
import fr.acensi.order.domain.use_case.port.OrderPort;
import fr.acensi.order.infrastructure.database.jpaEntities.OrderItemJpa;
import fr.acensi.order.infrastructure.database.jpaEntities.OrderJpa;
import fr.acensi.order.infrastructure.database.repositories.OrderJpaRepository;


public class OrderDatabaseAdapter implements OrderPort {
	
	private final OrderJpaRepository orderJpaRepository;

	public OrderDatabaseAdapter(OrderJpaRepository orderJpaRepository) {
		this.orderJpaRepository = orderJpaRepository;
	}
	@Override
	public List<Order> getAllOrders() {
		return orderJpaRepository.findAll()
				.stream()
				.map(this::toOrder)
				.collect(toList());
	}

	@Override
	public Optional<Order> getOrderById(Long orderId) {
		return orderJpaRepository.findById(orderId).map(this::toOrder);
	}

	@Override
	public Order saveOrder(Order order) {
		OrderJpa orderJpa = orderJpaRepository.save(toOrderJpa(order));
		return toOrder(orderJpa);
	}

	@Override
	public void deleteOrderById(Long orderId) {
		orderJpaRepository.deleteById(orderId);		
	}
	
	private Order toOrder(OrderJpa orderJpa) {
		Order order = new Order(
				orderJpa.getId(),
				orderJpa.getDate(),
				orderJpa.getOrderItems().stream().map(this::toOrderItem).collect(toList()));
		return order;
	}
	
	private OrderJpa toOrderJpa(Order order) {
		OrderJpa orderJpa = new OrderJpa();
		orderJpa.setId(order.getId());
		orderJpa.setDate(order.getDate());
		orderJpa.setOrderItems(order.getOrderItems().stream().map(this::toOrderItemJpa).collect(toList()));
		return orderJpa;
	}
	
	private OrderItem toOrderItem(OrderItemJpa orderItemJpa) {
		OrderItem orderItem = new OrderItem(
				orderItemJpa.getId(),
				orderItemJpa.getOrderId(),
				orderItemJpa.getProductId(),
				orderItemJpa.getQuantity());
		return orderItem;
	}
	
	private OrderItemJpa toOrderItemJpa(OrderItem orderItem) {
		OrderItemJpa orderItemJpa = new OrderItemJpa();
		orderItemJpa.setId(orderItem.getId());
		orderItemJpa.setOrderId(orderItem.getOrderId());
		orderItemJpa.setProductId(orderItem.getProductId());
		orderItemJpa.setQuantity(orderItem.getQuantity());
		return orderItemJpa;
	}

}
