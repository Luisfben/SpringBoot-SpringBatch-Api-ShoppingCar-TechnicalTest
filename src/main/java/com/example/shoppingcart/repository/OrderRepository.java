package com.example.shoppingcart.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shoppingcart.model.CashOrder;

public interface OrderRepository extends JpaRepository<CashOrder, Long> {

	@Query(value = "SELECT * FROM CASH_ORDER WHERE CUSTOMER_ID = :customer_id AND SOLD_OUT = 0", nativeQuery = true)
	List<CashOrder> findByCustomerId(@Param("customer_id") BigInteger customer_id);

}
