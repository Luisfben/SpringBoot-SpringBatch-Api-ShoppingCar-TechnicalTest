package com.example.shoppingcart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM PRODUCT WHERE NAME LIKE CONCAT('%',:name,'%') AND (PRICE BETWEEN :pricestart AND :priceend) AND MARK = :mark", countQuery = "SELECT COUNT(*) FROM PRODUCT WHERE NAME LIKE CONCAT('%',:name,'%')", nativeQuery = true)
	Page<Product> findByCriteria(Pageable pageable, @Param("name") String name, @Param("pricestart") String pricestart,
			@Param("priceend") String priceend, @Param("mark") String mark);

}
