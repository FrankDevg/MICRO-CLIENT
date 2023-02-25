package com.developer.minegociomanagement.service.interfaces;

import com.developer.minegociomanagement.dto.request.AddressRequest;
import com.developer.minegociomanagement.dto.response.AddressResponse;
import com.developer.minegociomanagement.entity.AddressEntity;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressEntity> findAllAddress();
    Optional<AddressEntity> findById(Long id);
    List<AddressEntity> findByIdClient(Long idclient);


    AddressEntity saveAddress(AddressEntity addressEntity);
    AddressEntity updateAddress(AddressEntity addressEntity);
    void deleteAddress(Long id);

//    Using Request for Save and Update Address
    AddressResponse saveAddress(AddressRequest addressRequest);
    AddressResponse updateAddress(AddressRequest addressRequest, Long id);


}
