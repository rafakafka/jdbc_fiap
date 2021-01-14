package com.fiap.persistence.ecommerce.infrastructure.repository.client.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;

/**
 * Classe que representa o modelo para criação dos endereços.
 * @author marciocampos
 */
@Entity
@Table(name="address")
public class AddressEntity {

	@Id
	@Column(name="addressId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clientId")
	private ClientEntity client;
	
	@Column(name="street")
	private String street;
	
	@Column(name="number")
	private String number;
	
	@Column(name="neighborhood")
	private String neighborhood;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipCode")
	private String zipCode;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
