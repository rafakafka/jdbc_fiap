package com.fiap.persistence.ecommerce.infrastructure.repository.client.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fiap.persistence.ecommerce.infrastructure.repository.order.entity.OrderEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Classe que representa o modelo para criação dos clientes.
 * @author marciocampos
 */
@Entity
@Table(name="client")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="clientId")
    private Integer clientId;
	
	@Column(name="name")
    private String name;
	
	@Column(name="documentNumber")
    private String documentNumber;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="birthDate")
    private Date birthDate;
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="client")
	private Set<AddressEntity> address = new LinkedHashSet<AddressEntity>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="client")
	private Set<OrderEntity> order = new LinkedHashSet<OrderEntity>();
 
	public Set<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(Set<AddressEntity> address) {
		this.address = address;
	}

	@JsonIgnore
	public Set<OrderEntity> getOrder() {
		return order;
	}

	public void setOrder(Set<OrderEntity> order) {
		this.order = order;
	}

	
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
