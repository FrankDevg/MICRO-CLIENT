package com.developer.minegociomanagement.dto.mapper;

import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);
    ClientEntity fromRequestToEntity(ClientRequest clientRequest);
    ClientResponse fromEntityToResponse(ClientEntity clientEntity);
}
