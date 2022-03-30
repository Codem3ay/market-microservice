package fr.acensi.order.infrastructure.database.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import fr.acensi.order.domain.entities.OrderItem;
import fr.acensi.order.domain.use_case.port.OrderItemPort;
import fr.acensi.order.infrastructure.database.jpaEntities.OrderItemJpa;
import fr.acensi.order.infrastructure.database.repositories.OrderItemJpaRepository;

import static java.util.stream.Collectors.toList;

@Component
public class OrderItemDatabaseAdapter implements OrderItemPort {
	
	private final OrderItemJpaRepository orderItemJpaRepository;

	public OrderItemDatabaseAdapter(OrderItemJpaRepository orderItemJpaRepository) {
		this.orderItemJpaRepository = orderItemJpaRepository;
	}
	
	@Override
	public List<OrderItem> getAllOrderItems() {
		return orderItemJpaRepository.findAll()
				.stream()
				.map(this::toOrderItem)
				.collect(toList());
	}

	@Override
	public Optional<OrderItem> getOrderItemById(Long orderItemId) {
		return orderItemJpaRepository.findById(orderItemId).map(this::toOrderItem);
	}

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		OrderItemJpa orderItemJpa = orderItemJpaRepository.save(toOrderItemJpa(orderItem));
		return toOrderItem(orderItemJpa);
	}

	@Override
	public void deleteOrderItemById(Long orderItemId) {
		orderItemJpaRepository.deleteById(orderItemId);
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
