package com.developer.minegociomanagement.controller;


import com.developer.minegociomanagement.dto.request.AddressRequest;
import com.developer.minegociomanagement.dto.response.AddressResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.service.interfaces.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressEntity> findAllAddress() {
        return addressService.findAllAddress();
    }

    @GetMapping("/{id}")
    public Optional<AddressEntity> findAddressById(@PathVariable("id") Long id) {
        return addressService.findById(id);
    }
    @GetMapping("/findbyidclient/{id}")
    public List<AddressEntity> findAddressByIdClient(@PathVariable("id") Long id) {
        return addressService.findByIdClient(id);
    }


    @PostMapping("/saveAddress")
    public AddressEntity saveAddress(@RequestBody AddressEntity addressEntity) {
        return addressService.saveAddress(addressEntity);
    }

    @PutMapping("/updateAddress")
    public AddressEntity updateAddress(@RequestBody AddressEntity addressEntity) {
        return addressService.updateAddress(addressEntity);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }

//    Using Request and Response with save and update address

    @PostMapping("/res")
    public AddressResponse saveEmpResponse(@RequestBody AddressRequest addressRequest) {
        return addressService.saveAddress(addressRequest);
    }

    @PutMapping("/res/{id}")
    public AddressResponse updateEmpResponse(@RequestBody AddressRequest addressRequest, @PathVariable("id") Long id) {
        return addressService.updateAddress(addressRequest, id);
    }

}
