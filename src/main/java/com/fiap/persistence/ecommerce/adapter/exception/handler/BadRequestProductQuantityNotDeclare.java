package com.fiap.persistence.ecommerce.adapter.exception.handler;

import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;

public class BadRequestProductQuantityNotDeclare extends Exception{

    OrderItemEntity orderItemEntity;

    public BadRequestProductQuantityNotDeclare(OrderItemEntity orderItemEntity) {
        this.orderItemEntity = orderItemEntity;
    }
}
