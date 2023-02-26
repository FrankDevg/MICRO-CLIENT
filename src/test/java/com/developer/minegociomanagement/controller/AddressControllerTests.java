package com.developer.minegociomanagement.controller;

import com.developer.minegociomanagement.dto.response.AddressResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressControllerTests {
	@InjectMocks
	private AddressController controller;
	@Mock
	private AddressServiceImpl service;
	@Test
	public void findAllAddressTest() {
		List<AddressEntity> addressMock = new ArrayList<AddressEntity>();
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId_cliente(0);
		addressEntity.setId_direccion(0L);
		addressEntity.setCiudad("Quito");
		addressEntity.setProvincia("Pichincha");
		addressEntity.setDireccion("Centro de Quito");
		addressEntity.setMatriz(false);
		addressMock.add(addressEntity);
		when(service.findAllAddress()).thenReturn(addressMock);
		List<AddressEntity> addressResult=controller.findAllAddress();
		verify(service,times(1)).findAllAddress();
	}
	@Test
	public void findAddressByIdClientTest(){
		List<AddressEntity> addressMock = new ArrayList<AddressEntity>();
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId_cliente(0);
		addressEntity.setId_direccion(0L);
		addressEntity.setCiudad("Quito");
		addressEntity.setProvincia("Pichincha");
		addressEntity.setDireccion("Centro de Quito");
		addressEntity.setMatriz(false);
		when(service.findByIdClient(0L)).thenReturn(addressMock);
		List<AddressEntity> addressResult=controller.findAddressByIdClient(0L);
		verify(service,times(1)).findByIdClient(0L);

	}
	@Test
	public void saveAddressTest(){
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId_cliente(0);
		addressEntity.setId_direccion(0L);
		addressEntity.setCiudad("Quito");
		addressEntity.setProvincia("Pichincha");
		addressEntity.setDireccion("Centro de Quito");
		addressEntity.setMatriz(false);
		when(service.saveAddress(addressEntity)).thenReturn(addressEntity);
		AddressEntity addressResult=controller.saveAddress(addressEntity);
		verify(service,times(1)).saveAddress(addressEntity);
	}
	@Test
	public void updateAddressTest(){
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId_cliente(0);
		addressEntity.setId_direccion(0L);
		addressEntity.setCiudad("Quito");
		addressEntity.setProvincia("Pichincha");
		addressEntity.setDireccion("Centro de Quito");
		addressEntity.setMatriz(false);
		when(service.updateAddress(addressEntity)).thenReturn(addressEntity);
		AddressEntity addressResult=controller.updateAddress(addressEntity);
		verify(service,times(1)).updateAddress(addressEntity);
	}
	@Test
	public void deleteAddressTest(){
		AddressResponse addressResponse = new AddressResponse();
		addressResponse.setId_direccion(0L);
		addressResponse.setId_direccion(0L);
		addressResponse.setCiudad("Quito");
		addressResponse.setProvincia("Pichincha");
		addressResponse.setDireccion("Centro de Quito");
		controller.deleteAddress(addressResponse.getId_direccion());
		verify(service,times(1)).deleteAddress(addressResponse.getId_direccion());
	}
	@Test
	public void findAddressByIdTest(){
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId_cliente(0);
		addressEntity.setId_direccion(0L);
		addressEntity.setCiudad("Quito");
		addressEntity.setProvincia("Pichincha");
		addressEntity.setDireccion("Centro de Quito");
		addressEntity.setMatriz(false);
		when(service.findById(0L)).thenReturn(Optional.of(addressEntity));
		Optional<AddressEntity> addressResult=controller.findAddressById(0L);
		verify(service,times(1)).findById(0L);
	}

	
	

}
