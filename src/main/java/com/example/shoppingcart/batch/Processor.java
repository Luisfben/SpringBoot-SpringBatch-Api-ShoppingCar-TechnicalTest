package com.example.shoppingcart.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.shoppingcart.dto.ProductDTO;

@Component
public class Processor implements ItemProcessor<ProductDTO, ProductDTO> {

	@Override
	public ProductDTO process(ProductDTO productDTO) throws Exception {
		return productDTO;
	}

}
