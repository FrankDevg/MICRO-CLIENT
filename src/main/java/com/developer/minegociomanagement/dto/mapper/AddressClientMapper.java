package com.developer.minegociomanagement.dto.mapper;

import com.developer.minegociomanagement.dto.request.AddressRequest;
import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.AddressResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressClientMapper {
    AddressClientMapper MAPPER = Mappers.getMapper(AddressClientMapper.class);
    AddressEntity fromRequestToEntity(ClientRequest addressRequest);
    AddressResponse fromEntityToResponse(AddressEntity addressEntity);
}
