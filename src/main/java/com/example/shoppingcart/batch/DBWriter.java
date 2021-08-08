package com.example.shoppingcart.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.shoppingcart.dto.ProductDTO;
import com.example.shoppingcart.repository.ProductRepository;
import com.example.shoppingcart.util.Util;

@Component
public class DBWriter implements ItemWriter<ProductDTO> {

	@Autowired
	private ProductRepository ProductRepository;

	@Override
	public void write(List<? extends ProductDTO> ProductDTOs) throws Exception {
		for (int i = 0; i < ProductDTOs.size(); i++) {
			if (ProductDTOs.get(i).notAnyIsEmpty()) {
				ProductRepository.save(Util.productDTOToProduct(ProductDTOs.get(i)));
			}
		}
	}

}
