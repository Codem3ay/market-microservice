package fr.acensi.order.domain.use_case.port;

import java.util.List;
import java.util.Optional;

import fr.acensi.order.domain.entities.OrderItem;

public interface OrderItemPort {
	
	List<OrderItem> getAllOrderItems();
	Optional<OrderItem> getOrderItemById(Long orderItemId);
	OrderItem saveOrderItem(OrderItem orderItem);
	void deleteOrderItemById(Long orderItemId);

}
