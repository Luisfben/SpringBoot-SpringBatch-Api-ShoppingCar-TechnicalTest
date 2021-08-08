package com.example.shoppingcart.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long customer_id;
	private Long product_id;
	private int quantity;

	public OrderDTO() {
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
