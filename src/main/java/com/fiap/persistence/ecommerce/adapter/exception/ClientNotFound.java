package com.fiap.persistence.ecommerce.adapter.exception;

public class ClientNotFound extends Exception {
	
	public ClientNotFound(Integer clientId) {
		super(String.format("ClientNotFound  Id: %s", clientId));
	}
}
