package com.developer.minegociomanagement.repository;

import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
