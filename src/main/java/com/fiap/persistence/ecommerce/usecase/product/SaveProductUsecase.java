package com.fiap.persistence.ecommerce.usecase.product;

import com.fiap.persistence.ecommerce.infrastructure.repository.product.ProductRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.product.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Método de para salvar o produto na base de dados
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */


@Component
public class SaveProductUsecase {

    ProductRepository productRepository;

    @Autowired
    SaveProductUsecase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }
    
    public ProductEntity update(ProductEntity product) {
    	return productRepository.save(product);
    }
}
