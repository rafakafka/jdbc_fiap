package com.fiap.persistence.ecommerce.infrastructure.repository.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;

/**
 * Classe que representa o modelo para criação dos pedidos
 * @author marciocampos
 *
 */
@Entity
@Table(name="`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orderId")
    private Integer orderId;
    
    //@JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="clientId")
    private ClientEntity client;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="date")
    private Date date;
    
    @Column(name="amount")
    private BigDecimal amount;
   
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="order")
    private Set<OrderItemEntity> orderItem = new LinkedHashSet<OrderItemEntity>(); 
    
	public Set<OrderItemEntity> getOrderItem() {
		return orderItem;
	}
    
	public void setOrderItem(Set<OrderItemEntity> orderItem) {
		this.orderItem = orderItem;
	}
		
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}