package com.fiap.persistence.ecommerce.infrastructure.repository.client;

import com.fiap.persistence.ecommerce.infrastructure.repository.client.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String>{

    public ClientEntity findByClientId(@Param("clientId") Integer clientId);
    
    public List<ClientEntity> findByName(@Param("name") String name);
    
    @Query("select c from ClientEntity c where c.documentNumber = :documentNumber")
    public ClientEntity findAllByDocumentNumber(@Param("documentNumber") String documentNumber);
}