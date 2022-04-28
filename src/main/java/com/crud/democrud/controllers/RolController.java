package com.crud.democrud.controllers;

import com.crud.democrud.models.Rol;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/{id}")
    public Rol obtenerPorId(@PathVariable("id") Long id) {
        return rolService.obtenerPorId(id).orElse(null);
    }

    @GetMapping
    public List<Rol> obtenerTodos() {
        return rolService.obtenerTodos();
    }

    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @GetMapping("/usuarios/{id}")
    public List<UsuarioModel> obtenerUsuarios(@PathVariable("id") Long id) {
        return rolService.obtenerUsuarios(id);
    }
}
