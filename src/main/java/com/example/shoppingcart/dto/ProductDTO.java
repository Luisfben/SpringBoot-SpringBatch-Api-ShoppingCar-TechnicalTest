package com.example.shoppingcart.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String mark;
	private String price;
	private String stock;
	private String status;
	private String discount_rate;

	public ProductDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(String discount_rate) {
		this.discount_rate = discount_rate;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", mark=" + mark + ", price=" + price + ", stock=" + stock + ", status="
				+ status + ", discount_rate=" + discount_rate + "]";
	}

	public boolean notAnyIsEmpty() {
		return (!name.isEmpty() && !mark.isEmpty() && !price.isEmpty() && !stock.isEmpty() && !status.isEmpty()
				&& !discount_rate.isEmpty());

	}

}
