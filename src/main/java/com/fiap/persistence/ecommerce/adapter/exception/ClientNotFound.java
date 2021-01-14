package com.fiap.persistence.ecommerce.adapter.exception;

public class ClientNotFound extends Exception {
	
	private Integer clientId;

	public ClientNotFound(Integer clientId) {
		this.clientId = clientId;
	}
}
