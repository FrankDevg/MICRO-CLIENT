package com.developer.minegociomanagement.dto.mapper;

import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientAddressResponse;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientAddressMapper {
    ClientAddressMapper MAPPER = Mappers.getMapper(ClientAddressMapper.class);
    ClientEntity fromRequestToEntity(ClientRequest clientRequest);
    ClientAddressResponse fromEntityToResponse(ClientEntity clientEntity);
}
