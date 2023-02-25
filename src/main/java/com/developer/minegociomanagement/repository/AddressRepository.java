package com.developer.minegociomanagement.repository;

import com.developer.minegociomanagement.dto.response.AddressResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    //crear consultar para buscar por idcliente
    @Query(value = "SELECT * FROM direccion_cliente WHERE id_cliente = :id_cliente", nativeQuery = true)
    List<AddressEntity> findByIdCliente(@Param("id_cliente") Long id_cliente);
    
    @Query(value = "SELECT * FROM direccion_cliente WHERE id_cliente = :id_cliente AND matriz = true", nativeQuery = true)
    AddressEntity findMatrizAddress(@Param("id_cliente") Long id_cliente);
    
    

}
