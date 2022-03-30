package fr.acensi.order.infrastructure.database.jpaEntities;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class OrderItemJpa extends BaseEntity {
	
	private Long OrderId;
	private Long ProductId;
	private int quantity;

}
