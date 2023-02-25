package com.developer.minegociomanagement.service.impl;

import com.developer.minegociomanagement.dto.mapper.ClientMapper;
import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.entity.ClientEntity;
import com.developer.minegociomanagement.repository.ClientRepository;
import com.developer.minegociomanagement.service.interfaces.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientEntity> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public ClientEntity saveClient(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity updateClient(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

//    Using Request and Response with save and update client

    @Override
    public ClientResponse saveClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
        clientRepository.save(clientEntity);
        return ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest, Long id) {

        Optional<ClientEntity> checkExistingClient = findById(id);
        if (! checkExistingClient.isPresent())
            throw new RuntimeException("Client Id "+ id + " Not Found!");

        ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
        clientEntity.setId_cliente(id);
        clientRepository.save(clientEntity);
        return ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
    }

}
