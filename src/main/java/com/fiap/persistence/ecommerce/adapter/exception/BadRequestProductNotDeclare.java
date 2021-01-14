package com.fiap.persistence.ecommerce.adapter.exception;

import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;

public class BadRequestProductNotDeclare extends Exception{

	OrderItemEntity orderItemEntity;

    public BadRequestProductNotDeclare(OrderItemEntity orderItemEntity) {
        this.orderItemEntity = orderItemEntity;
    }
}
