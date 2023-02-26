package com.developer.minegociomanagement.service.interfaces;

import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientAddressResponse;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientEntity> findAllClient();

    Optional<ClientEntity> findById(Long id);
    List<ClientAddressResponse> findClientByIdentificationNumber(String id);
    ClientEntity saveClient(ClientEntity clientEntity);
    ClientEntity updateClient(ClientEntity clientEntity);
    void deleteClient(Long id);

//    Using Request for Save and Update Client
    ClientResponse saveClient(ClientRequest clientRequest) throws Exception;
    ClientResponse updateClient(ClientRequest clientRequest, Long id);


}
