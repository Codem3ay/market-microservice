package fr.acensi.order.application.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemApi {
    private Long id;
	private Long orderId;
	private Long productId;
	private int quantity;
    
}
