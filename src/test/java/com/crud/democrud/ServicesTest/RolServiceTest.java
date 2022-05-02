package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.Rol;
import com.crud.democrud.services.RolService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RolServiceTest {

    @Autowired
    RolService rolService;

    private final Rol rol = new Rol();

    @BeforeEach
    void setUp() {
        rol.setIdRol(1L);
        rol.setDescripcion("Cajero");
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:insert_rol.sql")
    void obtenerPorId() {
        Rol rol2 = rolService.obtenerPorId(1L);
        assertEquals(rol2, rol);
    }

    @Test
    void save() {
        Rol rol2 = rolService.save(rol);
        assertEquals(rol, rol2);
    }
}