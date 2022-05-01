package com.crud.democrud.controllers;

import com.crud.democrud.models.Rol;
import com.crud.democrud.models.Usuario;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public List<Usuario> obtenerUsuarios() {
        try {
            return usuarioService.obtenerUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @PostMapping()
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(this.usuarioService.guardarUsuario(usuario));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(this.usuarioService.obtenerPorId(id));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/query")
    public List<Usuario> obtenerUsuariosPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        try {
            return this.usuarioService.obtenerPorPrioridad(prioridad);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Long id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Se elimino correctamente");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(usuarioService.actualizarUsuario(usuario));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/roles/{id}")
    public List<Rol> obtenerRoles(@PathVariable("id") Long id) {
        try {
            return usuarioService.obtenerRoles(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}