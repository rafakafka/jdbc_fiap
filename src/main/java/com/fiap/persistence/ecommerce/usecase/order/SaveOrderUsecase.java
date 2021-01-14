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
    List<OrderItemEntity> listOrderItemEntity;
    List<ProductEntity> listProduct;

    @Autowired
    SaveOrderUsecase(OrderRepository orderRepository, 
    		OrderItemRepository orderItemRepository,
    		ProductRepository productRepository,
    		ClientRepository clientRepository,
    		List<OrderItemEntity> listOrderItemEntity,
    		List<ProductEntity> listProduct){
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.listOrderItemEntity = listOrderItemEntity;
        this.listProduct = listProduct;
    }
    
    public OrderEntity saveOrder(OrderEntity orderEntity) {
    	return orderRepository.save(orderEntity);
    }

    public OrderEntity save(Integer clientId, List<OrderItemEntity> listOrderItem) 
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
    
    	for(OrderItemEntity orderItem: listOrderItem) {
    		if (orderItem.getProduct().getProductId() == null) {
    			orderRepository.delete(order);
    			throw new BadRequestProductNotDeclare(orderItem);
    		}
    		
    		ProductEntity product = productRepository.findByProductId(orderItem.getProduct().getProductId());

    		if (orderItem.getQuantity() > product.getQuantity()) {
    			orderRepository.delete(order);
    			throw new UnavailableQuantityOfProduct(orderItem);	
    		}
    	
    		orderAmount = orderAmount.add(orderItem.getUnitValue().multiply(new BigDecimal(orderItem.getQuantity())));
    		orderItem.setOrder(order);
    		orderItem.setProduct(product);
    		
			listOrderItemEntity.add(orderItem);
			
			product.setQuantity(product.getQuantity() - orderItem.getQuantity());
			listProduct.add(product);
    	}

    	orderItemRepository.saveAll(listOrderItemEntity);
    	order.setAmount(orderAmount);
    	orderRepository.save(order);
    	productRepository.saveAll(listProduct);
    	
    	order.setClient(client);
    	
    	return order; //orderRepository.findByOrderId(order.getOrderId());
    }
}