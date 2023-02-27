package com.developer.minegociomanagement.service.impl;

import com.developer.minegociomanagement.dto.mapper.*;
import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientAddressResponse;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.dto.response.ResultClientResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.entity.ClientEntity;
import com.developer.minegociomanagement.repository.AddressRepository;
import com.developer.minegociomanagement.repository.ClientRepository;
import com.developer.minegociomanagement.service.interfaces.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public ClientServiceImpl(ClientRepository clientRepository,AddressRepository  addressRepository) {

        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;

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
        ClientEntity clientToUpdate = clientRepository.getOne(clientEntity.getId_cliente());
        clientToUpdate.setCelular(clientEntity.getCelular()!=null?clientEntity.getCelular():clientToUpdate.getCelular());
        clientToUpdate.setNombres(clientEntity.getNombres()!=null?clientEntity.getNombres():clientToUpdate.getNombres());
        clientToUpdate.setCorreo(clientEntity.getCorreo()!=null?clientEntity.getCorreo():clientToUpdate.getCorreo());
        return clientRepository.save(clientToUpdate);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

//    Using Request and Response with save and update client

    @Override
    public ResultClientResponse saveClient(ClientRequest clientRequest) throws Exception {
        ResultClientResponse resultClientResponse = new ResultClientResponse();

        try{
            //validar si el tipo de identificacion es RUC o DNI sin sensibilidad a mayusculas



            if(clientRequest.getTipo_identificacion().equals("RUC") || clientRequest.getTipo_identificacion().equals("DNI")){

            ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
            AddressEntity addressEntity = AddressClientMapper.MAPPER.fromRequestToEntity(clientRequest);
            clientRepository.save(clientEntity);
            ClientResponse clientResponse=ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
                 if(clientResponse.getId_cliente()==null)clientResponse.setId_cliente(0);
                 if(addressEntity.getId_direccion()==null)addressEntity.setId_direccion(0L);
                 addressEntity.setId_cliente(clientResponse.getId_cliente());
                 addressRepository.save(addressEntity);
                 resultClientResponse.setCode(200);
                 resultClientResponse.setMessage("Se ingreso correctamente.");
                 resultClientResponse.setResult(clientResponse);
            }else{
                resultClientResponse.setCode(400);
                resultClientResponse.setMessage("No se pudo ingresar el cliente: Solo se admite 2 TIPOS DE IDENTIFICACION  RUC o DNI");
            }
            return resultClientResponse;

        }catch(NullPointerException exp){

            throw new Exception();
        }

    }
    @Override
    public List<ClientAddressResponse> findClientByIdentificationNumber(String id) {
        List<ClientEntity> clientEntities = clientRepository.findByIdentificationNumber(id);
        //recorrer la lista de clientes y por cada cliente buscar la direccion con matriz true
        //
        //declarar una lista de ClientAddressResponse vacia

        List<ClientAddressResponse> clientAddressResponseList = new ArrayList<>();



        for (ClientEntity clientEntity : clientEntities) {
            ClientAddressResponse clientAddResponse = ClientAddressMapper.MAPPER.fromEntityToResponse(clientEntity);

            AddressEntity addressEntity = addressRepository.findMatrizAddress(clientEntity.getId_cliente());
            clientAddResponse.setCiudad(addressEntity.getCiudad());
            clientAddResponse.setProvincia(addressEntity.getProvincia());
            clientAddResponse.setDireccion(addressEntity.getDireccion());
            clientAddressResponseList.add(clientAddResponse);

        }
        
       
       
        return clientAddressResponseList;
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
