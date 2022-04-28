package com.crud.democrud.services;

import com.crud.democrud.models.Rol;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioRolRepository usuarioRolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
    }

    public List<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public List<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public UsuarioModel actualizarUsuario(UsuarioModel usuario) {
        if (!usuarioRepository.existsById(usuario.getId())) {
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    public List<Rol> obtenerRoles(Long id) {
        UsuarioModel usuario = obtenerPorId(id).get();
        return usuarioRolRepository.findAllByUsuario(usuario)
                .stream().map(UsuarioRol::getRol).collect(Collectors.toList());
    }
}