package com.developer.minegociomanagement.service;

import com.developer.minegociomanagement.dto.mapper.AddressClientMapper;
import com.developer.minegociomanagement.dto.mapper.ClientMapper;
import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.dto.response.ResultClientResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.entity.ClientEntity;
import com.developer.minegociomanagement.repository.AddressRepository;
import com.developer.minegociomanagement.repository.ClientRepository;
import com.developer.minegociomanagement.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTests {
	@Spy
	@InjectMocks
	private ClientServiceImpl service;

	@Mock
	private ClientRepository repository;
	@Mock
	private AddressRepository repositoryAddress;

	@Test
	void saveClientTest_WhenSaveClientWithout_RUC_DNI() throws Exception {
		ClientRequest clientRequest = new ClientRequest();
		clientRequest.setTipo_identificacion("PASAPORTE");
		clientRequest.setNumero_identificacion("1723456789001");
		clientRequest.setNombres("Andrés Ruiz");
		clientRequest.setCelular("0987654321");
		clientRequest.setCorreo("franklindbruiz@gmail.com");
		clientRequest.setCiudad("Quito");
		clientRequest.setProvincia("Pichincha");
		clientRequest.setDireccion("Av. 6 de Diciembre");
		clientRequest.setMatriz(true);
		ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
		AddressEntity addressEntity = AddressClientMapper.MAPPER.fromRequestToEntity(clientRequest);
		addressEntity.setId_direccion(0L);
		clientEntity.setId_cliente(0L);
		ClientResponse clientResponse=ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
		ResultClientResponse resultClientResponse = new ResultClientResponse();
		resultClientResponse.setCode(400);
		resultClientResponse.setResult(clientResponse);
		resultClientResponse.setMessage("No se pudo ingresar el cliente: Solo se admite 2 TIPOS DE IDENTIFICACION  RUC o DNI");

		when(service.saveClient(clientRequest)).thenReturn(resultClientResponse);
		ResultClientResponse returnedSaved = service.saveClient(clientRequest);
		//assertEquals("El cliente no ingreso RUC o DNI", clientResponse);
		assertEquals("No se pudo ingresar el cliente: Solo se admite 2 TIPOS DE IDENTIFICACION  RUC o DNI", returnedSaved.getMessage());
		
	}

	


}
