package com.developer.minegociomanagement.controller;

import com.developer.minegociomanagement.dto.response.ClientAddressResponse;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.entity.ClientEntity;
import com.developer.minegociomanagement.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientControllerTests {
	@InjectMocks
	private ClientController controller;
	@Mock
	private ClientServiceImpl service;
	@Test
	public void findAllClientTest() {
		List<ClientEntity> clientMock = new ArrayList<ClientEntity>();
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId_cliente(0L);
		clientEntity.setNombres("Johanna Arias");
		clientEntity.setNumero_identificacion("1723456789");
		clientEntity.setCelular("0987654321");
		clientEntity.setCorreo("Johanna@gmail.com");
		clientMock.add(clientEntity);
		when(service.findAllClient()).thenReturn(clientMock);	
		List<ClientEntity> clientResult=controller.findAllClient();
		Mockito.verify(service,times(1)).findAllClient();

	}
	@Test
	public void findClientByIdTest(){
		List<ClientEntity> clientMock = new ArrayList<ClientEntity>();
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId_cliente(0L);
		clientEntity.setNombres("Johanna Arias");
		clientEntity.setNumero_identificacion("1723456789");
		clientEntity.setCelular("0987654321");
		clientEntity.setCorreo("johanna@gmail.com");
		clientMock.add(clientEntity);
		when(service.findById(0L)).thenReturn(null);
		Optional<ClientEntity> clientResult=controller.findClientById(0L);
		Mockito.verify(service,times(1)).findById(0L);
	}
	@Test
	public void saveClientTest(){
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId_cliente(0L);
		clientEntity.setNombres("Johanna Arias");
		clientEntity.setNumero_identificacion("1723456789");
		clientEntity.setCelular("0987654321");
		clientEntity.setCorreo("johanna@gmail.com"	);
		when(service.saveClient(clientEntity)).thenReturn(clientEntity);
		ClientEntity clientResult=controller.saveClient(clientEntity);
		Mockito.verify(service,times(1)).saveClient(clientEntity);

	}
	@Test
	public void updateClientTest(){
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId_cliente(0L);
		clientEntity.setNombres("Johanna Arias");
		clientEntity.setNumero_identificacion("1723456789");
		clientEntity.setCelular("0987654321");
		clientEntity.setCorreo("johanna@gmail.com");
		when(service.updateClient(clientEntity)).thenReturn(clientEntity);
		ClientEntity clientResult=controller.updateClient(clientEntity);
		Mockito.verify(service,times(1)).updateClient(clientEntity);
	}
	@Test
	public void deleteClientTest(){
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId_cliente(0L);
		clientEntity.setNombres("Johanna Arias");
		clientEntity.setNumero_identificacion("1723456789");
		clientEntity.setCelular("0987654321");
		clientEntity.setCorreo("johannaria@gmail.com");
		controller.deleteClient(0L);
		Mockito.verify(service,times(1)).deleteClient(0L);
	}
	@Test
	public void findClientByIdentificationNumberTest(){
		ClientAddressResponse clientAddressResponse = new ClientAddressResponse();
		clientAddressResponse.setId_cliente(0);
		clientAddressResponse.setNombres("Johanna Arias");
		clientAddressResponse.setNumero_identificacion("1723456789");
		clientAddressResponse.setCelular("0987654321");
		clientAddressResponse.setCorreo("johannaarias@gmail.com");
		List<ClientAddressResponse> clientMock = new ArrayList<ClientAddressResponse>();
		when(service.findClientByIdentificationNumber("1723456789")).thenReturn(clientMock);
		controller.findClientByIdentificationNumber("1723456789");
		Mockito.verify(service,times(1)).findClientByIdentificationNumber("1723456789");


	}


}
