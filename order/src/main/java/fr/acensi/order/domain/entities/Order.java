package fr.acensi.order.domain.entities;

import java.util.Date;
import java.util.List;

public class Order {
	
	private Long id;
	private Date date;
	private List<OrderItem> orderItems;
	
	public Order(Long id, Date date, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.date = date;
		this.orderItems = orderItems;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
