package com.fiap.persistence.ecommerce.adapter.exception;

import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;

public class UnavailableQuantityOfProduct extends Exception {

    public UnavailableQuantityOfProduct(OrderItemEntity orderItemEntity) {
    	super(String.format("UnavailableQuantityOfProduct : %s", orderItemEntity.getProduct().getProductId()));
    }
}
