package com.example.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CashOrder")
public class CashOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long customerId;
	private Long product_id;
	private String date;
	private int quantity;
	private Double price;
	private Double discount_rate;
	private int sold_out;

	public CashOrder(Long customer_id, Long product_id, String date, int quantity, Double price,
			Double discount_rate, int sold_out) {
		super();
		this.customerId = customer_id;
		this.product_id = product_id;
		this.date = date;
		this.quantity = quantity;
		this.price = price;
		this.discount_rate = discount_rate;
		this.sold_out = sold_out;
	}

	public CashOrder() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(Double discount_rate) {
		this.discount_rate = discount_rate;
	}

	public int getSold_out() {
		return sold_out;
	}

	public void setSold_out(int sold_out) {
		this.sold_out = sold_out;
	}

}
