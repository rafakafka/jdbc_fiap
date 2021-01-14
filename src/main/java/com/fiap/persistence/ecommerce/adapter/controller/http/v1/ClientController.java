package com.fiap.persistence.ecommerce.adapter.controller.http.v1;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;
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

    @Autowired
    public ClientController(SaveClientUsecase saveClientUsecase,
            GetClientUsecase getClientUsecase){
        this.saveClientUsecase = saveClientUsecase;
        this.getClientUsecase = getClientUsecase;
    }
    
    @GetMapping(value="/list")
    public ResponseEntity<Object> getAllClient() {
    	return new ResponseEntity<Object>(getClientUsecase.getAllClient(), HttpStatus.OK);
    }
    
    @GetMapping(value="/listId/{clientId}")
    public ResponseEntity<Object> getClientById(
            @PathVariable(value = "clientId") Integer clientId)
    {
        return new ResponseEntity<Object>(getClientUsecase.getClientById(clientId), HttpStatus.OK);
    }

    @PostMapping(value="/add")
    public ResponseEntity<Object> saveClient(
            @RequestBody ClientEntity client)
    {
    	saveClientUsecase.save(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
}



