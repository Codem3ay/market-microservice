package fr.acensi.order.infrastructure.database.jpaEntities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class OrderJpa extends BaseEntity {
	
    @OneToMany
	private List<OrderItemJpa> orderItems;
	private Date date;

}
