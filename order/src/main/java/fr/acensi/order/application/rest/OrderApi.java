package fr.acensi.order.application.rest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class OrderApi{

    private Long id;
    private Date date;
    private List<OrderItemApi> items;
    
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
	public List<OrderItemApi> getItems() {
		return items;
	}
	public void setItems(List<OrderItemApi> items) {
		this.items = items;
	}
    
    
    
}