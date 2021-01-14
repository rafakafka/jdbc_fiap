package com.fiap.persistence.ecommerce.usecase.order;

import com.fiap.persistence.ecommerce.adapter.exception.BadRequestProductNotDeclare;
import com.fiap.persistence.ecommerce.adapter.exception.ClientNotFound;
import com.fiap.persistence.ecommerce.adapter.exception.UnavailableQuantityOfProduct;
import com.fiap.persistence.ecommerce.infrastructure.repository.product.ProductRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.product.entity.ProductEntity;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.ClientRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.OrderItemRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.OrderRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderEntity;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Classe utilizada para salvar o pedido
 * A classe tem a verificação do cliente e verificação do estoque de produtos 
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */


@Component
public class SaveOrderUsecase {
	
	OrderRepository orderRepository;
    OrderItemRepository orderItemRepository;
    ProductRepository productRepository;
    ClientRepository clientRepository;

    @Autowired
    SaveOrderUsecase(OrderRepository orderRepository, 
    		OrderItemRepository orderItemRepository,
    		ProductRepository productRepository,
    		ClientRepository clientRepository){
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }
    
    public OrderEntity saveOrder(OrderEntity orderEntity) {
    	return orderRepository.save(orderEntity);
    }

    public OrderEntity save(Integer clientId, List<OrderItemEntity> orderItemEntity) 
    		throws BadRequestProductNotDeclare, UnavailableQuantityOfProduct, ClientNotFound {
    	BigDecimal orderAmount = new BigDecimal("0.0");  
    	ClientEntity client = clientRepository.findByClientId(clientId);
    	
    	if (client == null) {
    		throw new ClientNotFound(clientId);
    	}
    	
    	OrderEntity order = new OrderEntity();
    	order.setDate(new Date());
    	order.setClient(client);
    	order.setAmount(new BigDecimal(0));
    	orderRepository.save(order);
    	
    	for(OrderItemEntity item: orderItemEntity) {
    		if (item.getProduct().getProductId() == null) {
    			orderRepository.delete(order);
    			throw new BadRequestProductNotDeclare(item);
    		}
    		
    		ProductEntity product = productRepository.getOne(item.getProduct().getProductId());

    		if (item.getQuantity() > product.getQuantity()) {
    			orderRepository.delete(order);
    			throw new UnavailableQuantityOfProduct(item);	
    		}
    	
    		orderAmount = orderAmount.add(item.getUnitValue().multiply(new BigDecimal(item.getQuantity())));
    		item.setOrder(order);
			item.setProduct(product);
			orderItemRepository.save(item);
    	}

    	order.setAmount(orderAmount);
    	orderRepository.save(order);
    	return orderRepository.findByOrderId(order.getOrderId());
    }
}
