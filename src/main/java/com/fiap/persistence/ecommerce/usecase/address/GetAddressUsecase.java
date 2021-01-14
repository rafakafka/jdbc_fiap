package com.fiap.persistence.ecommerce.usecase.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.AddressRepository;
import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.AddressEntity;

/**
 * Classe utilizada para buscar os dados do endereço do cliente na base de dados através dos métodos
 * getAddresbyId ou getAllAddress para trazer todos os endereços
 * @author Lucas Vinicius, Marcio Campos, Rafael Martins
 */

@Component
public class GetAddressUsecase {
	
	AddressRepository addressRepository;

	@Autowired
	public GetAddressUsecase(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	 public AddressEntity getAdressById(Integer addressId) {
	    return addressRepository.findByAddressId (addressId);
	 }

	 public List<AddressEntity> getAllAddress(){
	    return addressRepository.findAll();
	 }
}
