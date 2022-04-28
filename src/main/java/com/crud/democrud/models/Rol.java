package com.crud.democrud.models;

import javax.persistence.*;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "DESCRIPCION", length = 50, nullable = false)
    private String descripcion;

    public Rol() {
    }

    public Rol(Long idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String rol) {
        this.descripcion = rol;
    }
}
