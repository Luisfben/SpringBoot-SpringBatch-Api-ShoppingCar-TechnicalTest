package com.example.shoppingcart.dto;

import java.io.Serializable;

public class SalesOrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long customer_id;

	public SalesOrderDTO() {
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
