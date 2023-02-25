package com.developer.minegociomanagement.repository;

import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
 //crear consultar para buscar por numero_identificacion con like
    @Query(value = "SELECT * FROM clientes WHERE numero_identificacion LIKE %:numero_identificacion%", nativeQuery = true)
    List<ClientEntity> findByIdentificationNumber(@Param("numero_identificacion") String numero_identificacion);
    
}
