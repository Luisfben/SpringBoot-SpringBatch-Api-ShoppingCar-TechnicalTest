package com.example.shoppingcart.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.shoppingcart.dto.OrderDTO;
import com.example.shoppingcart.dto.ProductDTO;
import com.example.shoppingcart.dto.SalesOrderDTO;
import com.example.shoppingcart.model.CashOrder;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.SalesOrder;

public class Util {

	public static Product productDTOToProduct(ProductDTO productDTO) {
		return new Product(productDTO.getName(), productDTO.getMark(), Double.parseDouble(productDTO.getPrice()),
				Integer.parseInt(productDTO.getStock()), productDTO.getStatus(),
				Double.parseDouble(productDTO.getDiscount_rate()));
	}

	public static CashOrder orderDTOToOrder(OrderDTO orderDTO, Double price, Double discount_rate, int sold_out) {
		CashOrder cashOrder = new CashOrder();

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);

		cashOrder.setCustomerId(orderDTO.getCustomer_id());
		cashOrder.setProduct_id(orderDTO.getProduct_id());
		cashOrder.setDate(strDate);
		cashOrder.setQuantity(orderDTO.getQuantity());
		cashOrder.setPrice(price);
		cashOrder.setDiscount_rate(discount_rate);
		cashOrder.setSold_out(sold_out);

		return cashOrder;
	}

	public static SalesOrder buildSalesOrder(CashOrder cashOrder) {
		SalesOrder salesOrder = new SalesOrder();

		salesOrder.setDate(new Date());
		salesOrder.setOrderId(cashOrder.getId());

		return salesOrder;
	}

}
