package com.example.shoppingcart.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SalerOrder")
public class SalesOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long orderId;
	private Date date;

	public SalesOrder(Long id, Long orderId, Date date) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.date = date;
	}

	public SalesOrder() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
