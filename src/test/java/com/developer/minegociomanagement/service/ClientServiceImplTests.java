package com.developer.minegociomanagement.service;

import com.developer.minegociomanagement.dto.mapper.AddressClientMapper;
import com.developer.minegociomanagement.dto.mapper.ClientMapper;
import com.developer.minegociomanagement.dto.request.ClientRequest;
import com.developer.minegociomanagement.dto.response.ClientResponse;
import com.developer.minegociomanagement.entity.AddressEntity;
import com.developer.minegociomanagement.entity.ClientEntity;
import com.developer.minegociomanagement.repository.AddressRepository;
import com.developer.minegociomanagement.repository.ClientRepository;
import com.developer.minegociomanagement.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.postgresql.hostchooser.HostRequirement.any;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTests {
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
		ClientResponse clientResponse=ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
		addressEntity.setId_direccion(0L);
		clientEntity.setId_cliente(0L);
		//verificar que no guarden clientes sin RUC o DNI
		when(service.saveClient(clientRequest)).thenReturn(clientResponse);
		service.saveClient(clientRequest);
		//assertEquals("El cliente no ingreso RUC o DNI", clientResponse);
		assertEquals("RUC", clientResponse.getTipo_identificacion());
		
	}
	


}
