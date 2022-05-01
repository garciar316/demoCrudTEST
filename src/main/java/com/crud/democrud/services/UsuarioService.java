package com.crud.democrud.services;

import com.crud.democrud.models.Rol;
import com.crud.democrud.models.Usuario;
import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario obtenerPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow();
    }


    @Transactional(readOnly = true)
    public List<Usuario>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    @Transactional
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getId())) {
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Rol> obtenerRoles(Long id) {
        Usuario usuario = obtenerPorId(id);
        return usuarioRolRepository.findAllByUsuario(usuario)
                .stream().map(UsuarioRol::getRol).collect(Collectors.toList());
    }
}