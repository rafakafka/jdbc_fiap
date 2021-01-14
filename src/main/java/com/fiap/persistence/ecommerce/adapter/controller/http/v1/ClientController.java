package com.fiap.persistence.ecommerce.adapter.controller.http.v1;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.AddressEntity;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;
import com.fiap.persistence.ecommerce.usecase.address.SaveAddressUsecase;
import com.fiap.persistence.ecommerce.usecase.client.GetClientUsecase;
import com.fiap.persistence.ecommerce.usecase.client.SaveClientUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe utilizada para controlar o direcionamento das requisções feitas pela aplicação quando utilizada a url /client/v1
 * As requisições feita pela aplicação podem ser:
 * /list - para listar os clientes 
 * /listId - para listar os clientes através do ID
 * /add - para salvar os dados do cliente
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */


@RestController
@RequestMapping("/client/v1")
public class ClientController {

	private SaveClientUsecase saveClientUsecase;
	private GetClientUsecase getClientUsecase;
	private SaveAddressUsecase saveAddressUsecase;

	@Autowired
	public ClientController(SaveClientUsecase saveClientUsecase, GetClientUsecase getClientUsecase,
			SaveAddressUsecase saveAddressUsecase) {
		this.saveClientUsecase = saveClientUsecase;
		this.getClientUsecase = getClientUsecase;
		this.saveAddressUsecase = saveAddressUsecase;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<Object> getAllClient() {
		try {

			return new ResponseEntity<Object>(getClientUsecase.getAllClient(), HttpStatus.OK);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@GetMapping(value = "/list/{clientId}")
	public ResponseEntity<Object> getClientById(@PathVariable(value = "clientId") Integer clientId) {
		try {
			return new ResponseEntity<Object>(getClientUsecase.getClientById(clientId), HttpStatus.OK);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	

	@PostMapping(value = "/create")
	public ResponseEntity<Object> saveClient(@RequestBody ClientEntity client) {
		try {
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@PostMapping(value = "/create/{clientId}/address")
	public ResponseEntity<Object> saveAddress(@PathVariable(value = "clientId") Integer clientId,
			@RequestBody AddressEntity address) {
		try {
			ClientEntity client = getClientUsecase.getClientById(clientId);
			address.setClient(client);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	/*
	@PostMapping(value = "/create")
	public ResponseEntity<Object> saveClient(@RequestBody ClientEntity client) {
		try {
			return new ResponseEntity<>(saveClientUsecase.save(client), HttpStatus.CREATED);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@PostMapping(value = "/create/{clientId}/address")
	public ResponseEntity<Object> saveAddress(@PathVariable(value = "clientId") Integer clientId,
			@RequestBody AddressEntity address) {
		try {
			ClientEntity client = getClientUsecase.getClientById(clientId);
			address.setClient(client);
			return new ResponseEntity<>(saveAddressUsecase.save(address), HttpStatus.CREATED);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
*/	
	
}
