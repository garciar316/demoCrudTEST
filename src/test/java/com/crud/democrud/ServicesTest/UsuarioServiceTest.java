package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.Usuario;
import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.services.RolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    void testGuardarUsuario(){
        Usuario usuario =new Usuario(null,"aqua man","aqua@gmail.com",99);
        Usuario usuarioRegistrado = usuarioRepository.save(usuario);
        assertNotNull(usuarioRegistrado);
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:insert_user.sql")
    void testBuscarUsuarioPorId(){
        Long idBuscado=1L;
        Usuario usuarioModelBuscado= usuarioRepository.findById(idBuscado).orElseThrow();
        assertThat(usuarioModelBuscado.getId()).isEqualTo(idBuscado);
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:insert_user.sql")
    void testListarUsuarios(){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList.size()).isSameAs(2);
    }
}
