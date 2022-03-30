package fr.acensi.order.domain.use_case.port;

import java.util.List;
import java.util.Optional;

import fr.acensi.order.domain.entities.Order;

public interface OrderPort {
	
	List<Order> getAllOrders();
	Optional<Order> getOrderById(Long orderId);
	Order saveOrder(Order order);
	void deleteOrderById(Long orderId);

}
