package com.fiap.persistence.ecommerce.adapter.exception;

import com.fiap.persistence.ecommerce.infrastructure.repository.product.entity.ProductEntity;

public class ProductNotFound extends Exception {

	public ProductNotFound(ProductEntity productEntity) {
		super(String.format("ProductNotFound  Id: %s", productEntity.getProductId()));
	};
}
