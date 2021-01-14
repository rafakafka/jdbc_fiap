package com.fiap.persistence.ecommerce.usecase.order;

import com.fiap.persistence.ecommerce.infrastructure.repository.order.OrderRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe utilizada para consultar uma ordem de compra
 * A buca é feita através do do ID da ordem utilizando o método getOrderById
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */


@Component
public class GetOrderUsecase {

	OrderRepository orderRepository;

    @Autowired
    GetOrderUsecase(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public OrderEntity getOrderById(Integer orderId) {
        return orderRepository.findByOrderId(orderId);
    }

//    public List<OrderEntity> getOrderByClientId(String clientId) {
//        return orderRepository.findByClientId(clientId);
//    }
}
