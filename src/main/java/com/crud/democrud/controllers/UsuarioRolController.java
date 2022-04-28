package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/asignar_rol")
public class UsuarioRolController {

    private final UsuarioRolService usuarioRolService;

    @Autowired
    public UsuarioRolController(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    @PostMapping
    public UsuarioRol guardar(@RequestBody UsuarioRol usuarioRol) {
        return usuarioRolService.save(usuarioRol);
    }
}
