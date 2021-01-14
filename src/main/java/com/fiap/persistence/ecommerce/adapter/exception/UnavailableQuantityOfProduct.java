package com.fiap.persistence.ecommerce.adapter.exception;

import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;

public class UnavailableQuantityOfProduct extends Exception {
	
	private OrderItemEntity orderItemEntity;

    public UnavailableQuantityOfProduct(OrderItemEntity orderItemEntity) {
        this.orderItemEntity = orderItemEntity;
    }
}
