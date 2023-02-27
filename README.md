

<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->






<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://media.discordapp.net/attachments/836284594948407366/1079636506022527096/image.png" alt="Logo" width="80" height="80">
  </a>

  <h1 align="center">Mi negocio Spring Boot</h1>

  <p align="center">
    Sistema de facturación electrónica - Módulo Cliente-Dirección
    <br />
     <!--a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a-->
    <br />
    <br />
    <a href="http://20.242.129.177:8080/client">View Demo</a>
    ·
    <!--a href="https://github.com/othneildrew/Best-README-Template/issues">Report Bug</a-->
    ·
    <!--a href="https://github.com/othneildrew/Best-README-Template/issues">Request Feature</a-->
  </p>
</div>





<!-- ABOUT THE PROJECT -->
## Acerca de



La ultima version de este proyecto se encuentra en la rama developer, la cual se encuentra deployada en AKS (Azure Kubernetes Services).
Las collecciones de acceso a los endpoints de postman se encuentra en la raiz del repositorio de la rama developer.

Casos de uso:
*  Funcionalidad para buscar y obtener un listado de Clientes con una Dirección
*  Funcionalidad para crear un nuevo Cliente con la Dirección matriz
*  Funcionalidad para editar los datos del Cliente
*  Funcionalidad para eliminar un Cliente
*  Funcionalidad para registrar una nueva Dirección por Cliente
*  Funcionalidad para listar las direcciones adicionales del Cliente

Requerimientos:
* Request/Response en formato JSON
* TDD
* Buenas practicas
* Java 8+
* SpringBoot
* JPA, Hibernate
* PostgreSQL
* Pruebas Unitarias (Junit y Mockito)
<!-- ROADMAP -->

<!-- GETTING STARTED -->
## TDD
Semaforo ROJO: Ingreso de tipo de identificacion diferente a RUC o DNI.

![image](https://user-images.githubusercontent.com/52903207/221487357-6d4c6456-64bc-47b7-baae-6f7c414b3d5a.png)


Desarrollo obtenido en base a la prueba ejecutada.


![image](https://user-images.githubusercontent.com/52903207/221487637-09ef5f1e-e3e1-4d9f-8750-352bf5563835.png)

Semaforo Verde : 
 Tipo de identificación= "PASAPORTE"

![image](https://user-images.githubusercontent.com/52903207/221487806-22ccf50a-c933-470b-adfc-76ff03c5d389.png)



### Prueba Unitarias

ClientControllerTest


![image](https://user-images.githubusercontent.com/52903207/221488202-f1b02626-7b6e-4f81-84d1-be588f51de3d.png)


AddressControllerTests


![image](https://user-images.githubusercontent.com/52903207/221488308-e476e79a-4682-468c-8201-021e73e086c3.png)

## Aporte Extra

- [x] Docker
![image](https://user-images.githubusercontent.com/52903207/221493633-aabb9a1e-bfd5-4764-934c-230196d54151.png)

- [x] Kubernetes


![image](https://user-images.githubusercontent.com/52903207/221494611-97730085-a06f-4d90-a80c-cfe26d363e6b.png)

- [x] Deploy en AKS


![image](https://user-images.githubusercontent.com/52903207/221494529-2feb4d0d-40c0-4fc4-b299-aa772d947b2a.png)

- [x] CI


![image](https://user-images.githubusercontent.com/52903207/221493492-948f8f8d-992b-4015-82e6-6fc084dbc30c.png)


## Trabajo a futuro

- [ ] CD
- [ ] AMQP para email al cambiar la dirección principal
- [ ] Apigateway para seguridad


<!-- CONTACT -->
## Contact

Franklin Andrés Ruiz Gómez- franklindbruiz@gmail.com

Demo Project Link: [http://20.242.129.177:8080/client](http://20.242.129.177:8080/client)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

