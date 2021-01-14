package com.fiap.persistence.ecommerce.usecase.client;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.ClientRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Classe utilizada para salvar os dados do cliente na base de dados através do método save 
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */


@Component
public class SaveClientUsecase {

    ClientRepository clientRepository;

    @Autowired
    public SaveClientUsecase (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    
    public ClientEntity save(ClientEntity clientRequest) {
        return clientRepository.save(clientRequest);
    }
}
