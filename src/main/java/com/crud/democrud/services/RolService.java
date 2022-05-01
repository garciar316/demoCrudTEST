package com.crud.democrud.services;

import com.crud.democrud.models.Rol;
import com.crud.democrud.models.Usuario;
import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.RolRepository;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    private final RolRepository rolRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    @Autowired
    public RolService(RolRepository rolRepository, UsuarioRolRepository usuarioRolRepository) {
        this.rolRepository = rolRepository;
        this.usuarioRolRepository = usuarioRolRepository;
    }

    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id).orElseThrow();
    }

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminarRol(Long id) {
            rolRepository.deleteById(id);
    }

    public Rol actualizarUsuario(Rol rol) {
        if (!rolRepository.existsById(rol.getIdRol())) {
            return null;
        }
        return rolRepository.save(rol);
    }

    public List<Usuario> obtenerUsuarios(Long id) {
        Rol rol = obtenerPorId(id);
        return usuarioRolRepository.findAllByRol(rol)
                .stream().map(UsuarioRol::getUsuario).collect(Collectors.toList());
    }
}
