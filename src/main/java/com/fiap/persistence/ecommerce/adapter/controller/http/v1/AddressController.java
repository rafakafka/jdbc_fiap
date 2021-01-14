package com.fiap.persistence.ecommerce.adapter.controller.http.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.AddressEntity;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;
import com.fiap.persistence.ecommerce.usecase.address.GetAddressUsecase;
import com.fiap.persistence.ecommerce.usecase.address.SaveAddressUsecase;
import com.fiap.persistence.ecommerce.usecase.client.GetClientUsecase;

/**
 * Classe utilizada para controlar o direcionamento das requisções feitas pela aplicação quando utilizada a url /client/v1
 * As requisições feita pela aplicação podem ser:
 * /add/{clientId}/address - para salvar um endereço do cliente
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */

@RestController
@RequestMapping("client/v1")
public class AddressController {
	
	private GetAddressUsecase getAddressUsecase;
	private SaveAddressUsecase saveAddressUsecase;
	private GetClientUsecase getClientUsecase;
	
	public AddressController(GetAddressUsecase getAddressUsecase,
	SaveAddressUsecase saveAddressUsecase,
	GetClientUsecase getClientUsecase) {
		this.getAddressUsecase = getAddressUsecase;
		this.saveAddressUsecase = saveAddressUsecase;
		this.getClientUsecase = getClientUsecase;
	}

    @PostMapping(value="/add/{clientId}/address")
    public ResponseEntity<Object> saveAddress(
    		@PathVariable(value = "clientId") Integer clientId,
            @RequestBody AddressEntity address)
    {
    	ClientEntity client = getClientUsecase.getClientById(clientId);
    			
    	address.setClient(client);
    	saveAddressUsecase.save(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }
}
