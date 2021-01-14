package com.fiap.persistence.ecommerce.usecase.product;

import com.fiap.persistence.ecommerce.infrastructure.repository.product.ProductRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.product.entity.ProductEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe utilizada para consultar o produto
 * Busca de produtos utilizando o ID através do método GetProductById
 * Busca de produtos através do nome através do método GetProductByName
 * Busca de todos os produtos na base através do método GetAllProducts 
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */

@Component
public class GetProductUsecase {

    ProductRepository productRepository;

    @Autowired
    GetProductUsecase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductEntity getProductById(Integer productId) {
        return productRepository.findByProductId (productId);
    }

    public List<ProductEntity> getProductByName(String productName) {
        return productRepository.findByName(productName);
    }
    
    public List<ProductEntity> getAllProducts() {
    	return productRepository.findAll();
    }

}
