package com.fiap.persistence.ecommerce.infrastructure.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, String> {
	

}
