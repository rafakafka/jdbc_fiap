package com.fiap.persistence.ecommerce.infrastructure.repository.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderItemEntity;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.Column;

/**
 * Classe que representa o modelo para criação dos produtos.
 * @author marciocampos
 */
@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="productId")
    private Integer productId;
    
    @Column(name="name")
    private String name;
    
    @Column(name="quantity")
    private Integer quantity;
    
    @Column(name="actualUnitValue")
    private BigDecimal actualUnitValue;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")
	private Set<OrderItemEntity> orderItem = new LinkedHashSet<OrderItemEntity>();
	
    
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@JsonIgnore
	public Set<OrderItemEntity> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(Set<OrderItemEntity> orderItem) {
		this.orderItem = orderItem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getActualUnitValue() {
		return actualUnitValue;
	}
	public void setActualUnitValue(BigDecimal actualUnitValue) {
		this.actualUnitValue = actualUnitValue;
	}
}
