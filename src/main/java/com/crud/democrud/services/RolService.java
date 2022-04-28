package com.crud.democrud.services;

import com.crud.democrud.models.Rol;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.RolRepository;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<Rol> obtenerPorId(Long id) {
        return rolRepository.findById(id);
    }

    public List<Rol> obtenerTodos() {
        return (List<Rol>) rolRepository.findAll();
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public boolean eliminarRol(Long id) {
        try{
            rolRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public Rol actualizarUsuario(Rol rol) {
        if (!rolRepository.existsById(rol.getIdRol())) {
            return null;
        }
        return rolRepository.save(rol);
    }

    public List<UsuarioModel> obtenerUsuarios(Long id) {
        Rol rol = obtenerPorId(id).orElse(null);
        return usuarioRolRepository.findAllByRol(rol)
                .stream().map(UsuarioRol::getUsuario).collect(Collectors.toList());
    }
}
