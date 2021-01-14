package com.fiap.persistence.ecommerce.infrastructure.repository.product;

import com.fiap.persistence.ecommerce.infrastructure.repository.product.entity.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

    ProductEntity findByProductId(@Param("productId") Integer productId);

    List<ProductEntity> findByName(@Param("name") String name);
    
}