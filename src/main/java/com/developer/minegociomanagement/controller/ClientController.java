package com.developer.minegociomanagement.controller;


import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientAddressResponse;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.dto.response.ResultClientResponse;
import com.developer.minegociomanagement.entity.ClientEntity;
import com.developer.minegociomanagement.service.interfaces.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientEntity> findAllClient() {
        return clientService.findAllClient();
    }

    @GetMapping("/{id}")
    public Optional<ClientEntity> findClientById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }
    @GetMapping("/findClientByIdentificationNumber/{id}")
    public List<ClientAddressResponse> findClientByIdentificationNumber(@PathVariable("id") String id) {
        return clientService.findClientByIdentificationNumber(id);
    }

    @PostMapping("/saveClient")
    public ClientEntity saveClient(@RequestBody ClientEntity clientEntity) {
        return clientService.saveClient(clientEntity);
    }

    @PutMapping("/updateClient")
    public ClientEntity updateClient(@RequestBody ClientEntity clientEntity) {
        return clientService.updateClient(clientEntity);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }

//    Using Request and Response with save and update client

    @PostMapping("/res")
    public ResultClientResponse saveEmpResponse(@RequestBody ClientRequest clientRequest) throws Exception {
        return clientService.saveClient(clientRequest);
    }

    @PutMapping("/res/{id}")
    public ClientResponse updateEmpResponse(@RequestBody ClientRequest clientRequest, @PathVariable("id") Long id) {
        return clientService.updateClient(clientRequest, id);
    }

}
