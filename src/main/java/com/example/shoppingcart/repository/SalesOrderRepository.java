package com.example.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingcart.model.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
