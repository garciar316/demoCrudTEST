package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.Usuario;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarUsuario(){
        Usuario usuario =new Usuario("aquaman","aqua@gmail.com",99);
        Usuario usuarioRegistrado = usuarioRepository.save(usuario);
        assertNotNull(usuarioRegistrado);
    }

    @Test
    public void testBuscarUsuarioPorId(){
        Long idBuscado=1L;
        Optional<Usuario> usuarioModelBuscado=usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuarios(){
        List<Usuario> usuarioList =(List<Usuario>) usuarioRepository.findAll();
        assertThat(usuarioList).size().isGreaterThan(0);
    }
}
