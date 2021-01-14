package com.fiap.persistence.ecommerce.infrastructure.repository.order;

import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String>{

    OrderEntity findByOrderId(@Param("orderId") Integer orderId);
    
    //List<OrderEntity> findByClientId(@Param("clientId") String clientId);
}