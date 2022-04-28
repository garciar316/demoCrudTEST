package com.crud.democrud.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "NOMBRE", length = 50, nullable = false)
    private String nombre;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "PRIORIDAD", length = 50, nullable = false)
    private Integer prioridad;

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioModel(String nombre, String email, Integer prioridad) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }

    public UsuarioModel() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

}