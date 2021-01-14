package com.fiap.persistence.ecommerce.usecase.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.AddressRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.AddressEntity;

/**
 * Classe utilizada para salvar os dados do endereço do cliente na base de dados através do método save 
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */


@Component
public class SaveAddressUsecase {

	 	AddressRepository addressRepository;

	    @Autowired
	    public SaveAddressUsecase (AddressRepository addressRepository){
	        this.addressRepository = addressRepository;
	    }
	    
	    public void save(AddressEntity addressRequest) {
	    	addressRepository.save(addressRequest);
	    }
}
