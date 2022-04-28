package com.crud.democrud.models;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO_ROL")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioModel usuario;

    public UsuarioRol() {
    }

    public UsuarioRol(Rol rol, UsuarioModel usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
