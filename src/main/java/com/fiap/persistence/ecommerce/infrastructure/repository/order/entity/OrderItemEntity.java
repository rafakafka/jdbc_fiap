package com.fiap.persistence.ecommerce.infrastructure.repository.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fiap.persistence.ecommerce.infrastructure.repository.product.entity.ProductEntity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa o modelo para criação de itens de um pedido
 * @author marciocampos
 *
 */
@Entity
@Table(name="orderItem")
public class OrderItemEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderItemId")
    private Integer orderItemId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="orderId")
	private OrderEntity order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productId")
	private ProductEntity product;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="unitValue")
    private BigDecimal unitValue;
	
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public ProductEntity getProduct() {
		return product;
	}
	
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(BigDecimal unitValue) {
		this.unitValue = unitValue;
	}
}