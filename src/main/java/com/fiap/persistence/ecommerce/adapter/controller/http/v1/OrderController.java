package com.fiap.persistence.ecommerce.adapter.controller.http.v1;

import com.fiap.persistence.ecommerce.adapter.exception.BadRequestProductNotDeclare;
import com.fiap.persistence.ecommerce.adapter.exception.ClientNotFound;
import com.fiap.persistence.ecommerce.adapter.exception.UnavailableQuantityOfProduct;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;
import com.fiap.persistence.ecommerce.usecase.order.GetOrderUsecase;
import com.fiap.persistence.ecommerce.usecase.order.SaveOrderUsecase;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe utilizada para controlar o direcionamento das requisções feitas pela aplicação quando utilizada a url /order/v1
 * As requisições feita pela aplicação podem ser:
 * /add/{clientId}/products para salvar o pedido de um cliente
 * getRequestById para pesquisar uma requisição pelo ID
 * /id/{orderId} para buscar uma ordem através do ID
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */

@RestController
@RequestMapping("/order/v1")
public class OrderController {

    private SaveOrderUsecase saveOrderUsecase;
    private GetOrderUsecase getOrderUsecase;

    @Autowired
    public OrderController(SaveOrderUsecase saveOrderUsecase,
    		GetOrderUsecase getOrderUsecase){
        this.saveOrderUsecase = saveOrderUsecase;
        this.getOrderUsecase = getOrderUsecase;
    }

    @GetMapping(value="/id/{orderId}")
    public ResponseEntity<Object> getRequestById(
            @PathVariable(value = "requestId") Integer requestId)
    {
        return new ResponseEntity<Object>(getOrderUsecase.getOrderById(requestId), HttpStatus.OK);
    }

    @PostMapping(value="/add/{clientId}/products")
    public ResponseEntity<Object> save(
    		@PathVariable(value = "clientId") Integer clientId,
    		@RequestBody List<OrderItemEntity> orderItemEntity
            ) throws BadRequestProductNotDeclare, UnavailableQuantityOfProduct, ClientNotFound {
        return new ResponseEntity<>(saveOrderUsecase.save(clientId, orderItemEntity), HttpStatus.CREATED);
    }
}



