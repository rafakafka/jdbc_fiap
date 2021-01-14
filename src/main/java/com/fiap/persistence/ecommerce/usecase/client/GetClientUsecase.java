package com.fiap.persistence.ecommerce.usecase.client;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.ClientRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe utilizada para buscar os dados do cliente na base através do nome, ID, todos os clientes ou busca através do documento 
 * Os métodos utilizados para busca são getClienteByYd, getClienteByName, getAllClient e getClienteByNumber
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */

@Component
public class GetClientUsecase {

    ClientRepository clientRepository;

    @Autowired
    public GetClientUsecase (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public ClientEntity getClientById(Integer clientId) {
        return clientRepository.findByClientId(clientId);
    }
    
    public List<ClientEntity> getClientByName(String clientName){
    	return clientRepository.findByName(clientName);
    }
    
    public List<ClientEntity> getAllClient(){
    	return clientRepository.findAll();
    }
    
    public ClientEntity getClientByDocumentNumber(String documentNumber){
    	return clientRepository.findAllByDocumentNumber(documentNumber);
    }
}
