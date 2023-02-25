package com.developer.minegociomanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "direccion_cliente")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id_direccion;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    public AddressEntity(){

    }


    public AddressEntity(Long id_direccion, String provincia, String ciudad, String direccion) {
        this.id_direccion = id_direccion;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
