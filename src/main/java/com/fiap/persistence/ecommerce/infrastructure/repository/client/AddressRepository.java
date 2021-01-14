package com.fiap.persistence.ecommerce.infrastructure.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
	
	public AddressEntity findByAddressId(@Param("addressId") Integer addressId);
}
