package com.developer.minegociomanagement.dto.mapper;

import com.developer.minegociomanagement.dto.request.AddressRequest;
import com.developer.minegociomanagement.dto.response.AddressResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);
    AddressEntity fromRequestToEntity(AddressRequest addressRequest);
    AddressResponse fromEntityToResponse(AddressEntity addressEntity);
}
