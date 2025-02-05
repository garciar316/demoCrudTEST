package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioRolService {

    private final UsuarioRolRepository usuarioRolRepository;

    @Autowired
    public UsuarioRolService(UsuarioRolRepository usuarioRolRepository) {
        this.usuarioRolRepository = usuarioRolRepository;
    }

    @Transactional
    public UsuarioRol save(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }
}
