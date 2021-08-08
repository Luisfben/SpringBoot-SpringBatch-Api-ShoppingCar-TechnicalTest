package com.example.shoppingcart.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.dto.OrderDTO;
import com.example.shoppingcart.dto.SalesOrderDTO;
import com.example.shoppingcart.exception.InsufficientStockException;
import com.example.shoppingcart.model.CashOrder;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repository.OrderRepository;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.repository.SalesOrderRepository;
import com.example.shoppingcart.util.Util;

@RestController
@RequestMapping("/api")
public class ShoppingcartController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	private static int PENDING_TO_BUY = 0;
	private static int SOLD_OUT = 1;

	@GetMapping("/v1/load")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));

		JobParameters parameter = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameter);

		System.out.println("JobExecution: " + jobExecution.getStatus());

		while (jobExecution.isRunning()) {
			System.out.println("...");
		}
		return jobExecution.getStatus();
	}

	@GetMapping("/v1/product")
	public Page<Product> product(@PageableDefault(size = 10, page = 0) Pageable pageable, @RequestParam String name,
			@RequestParam String pricestart, @RequestParam String priceend, @RequestParam String mark) {
		return productRepository.findByCriteria(pageable, name, pricestart, priceend, mark);
	}

	@PostMapping("/v1/order")
	public OrderDTO order(@RequestBody OrderDTO orderDTO) {
		Product product = productRepository.getById(orderDTO.getProduct_id());

		if (product.getStock() >= orderDTO.getQuantity()) {
			orderRepository.save(
					Util.orderDTOToOrder(orderDTO, product.getPrice(), product.getDiscountRate(), PENDING_TO_BUY));
		} else {
			throw new InsufficientStockException();
		}
		return orderDTO;
	}

	@GetMapping("/v1/ordercustomer/{customer_id}")
	public List<CashOrder> orderCustomer(@PathVariable String customer_id) {
		return orderRepository.findByCustomerId(new BigInteger(customer_id));
	}

	@DeleteMapping("/v1/ordercustomer/{customer_id}")
	public List<CashOrder> orderCustomerDelete(@PathVariable String customer_id) {
		List<CashOrder> cashOrderList = new ArrayList<>();
		cashOrderList = orderRepository.findByCustomerId(new BigInteger(customer_id));

		for (CashOrder cashOrder : cashOrderList) {
			cashOrder.setSold_out(SOLD_OUT);
			orderRepository.save(cashOrder);
		}

		return cashOrderList;
	}

	@PostMapping("/v1/salesorder")
	public List<CashOrder> salesOrder(@RequestBody SalesOrderDTO salesOrderDTO) {
		Long customer_id = salesOrderDTO.getCustomer_id();
		List<CashOrder> cashOrderList = new ArrayList<>();
		cashOrderList = orderRepository.findByCustomerId(BigInteger.valueOf(customer_id));

		for (CashOrder cashOrder : cashOrderList) {
			salesOrderRepository.save(Util.buildSalesOrder(cashOrder));
		}

		return orderCustomerDelete(Long.toString(customer_id));
	}

}
