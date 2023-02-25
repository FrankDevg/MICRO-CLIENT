package com.developer.minegociomanagement.service.impl;

import com.developer.minegociomanagement.dto.mapper.AddressMapper;
import com.developer.minegociomanagement.dto.request.AddressRequest;
import com.developer.minegociomanagement.dto.response.AddressResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.repository.AddressRepository;
import com.developer.minegociomanagement.service.interfaces.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressEntity> findAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<AddressEntity> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<AddressEntity> findByIdClient(Long idclient) {
        return addressRepository.findByIdCliente(idclient);
    }


    @Override
    public AddressEntity saveAddress(AddressEntity addressEntity) {
        return addressRepository.save(addressEntity);
    }

    @Override
    public AddressEntity updateAddress(AddressEntity addressEntity) {
        return addressRepository.save(addressEntity);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

//    Using Request and Response with save and update address

    @Override
    public AddressResponse saveAddress(AddressRequest addressRequest) {
        AddressEntity addressEntity = AddressMapper.MAPPER.fromRequestToEntity(addressRequest);
        addressRepository.save(addressEntity);
        return AddressMapper.MAPPER.fromEntityToResponse(addressEntity);
    }

    @Override
    public AddressResponse updateAddress(AddressRequest addressRequest, Long id) {

        Optional<AddressEntity> checkExistingAddress = findById(id);
        if (! checkExistingAddress.isPresent())
            throw new RuntimeException("Address Id "+ id + " Not Found!");

        AddressEntity addressEntity = AddressMapper.MAPPER.fromRequestToEntity(addressRequest);
        addressEntity.setId_direccion(id);
        addressRepository.save(addressEntity);
        return AddressMapper.MAPPER.fromEntityToResponse(addressEntity);
    }

}
