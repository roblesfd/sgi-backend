package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

public class UsuarioValidationTest {
    private Validator validator;
    Set<ConstraintViolation<Usuario>> violations;
    Usuario usuario;

    @BeforeEach
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        usuario = new Usuario(
                "Fernando", "García", "López",
                "55 1234 5678", "Calle 123", Rol.ADMIN, 3000.0,
                "fernando@example.com", "password123"
        );

    }

    @Test
    void testUsuarioValido(){
        violations = validator.validate(usuario);
        assertTrue(violations.isEmpty(), "No deberia haber violaciones");
    }

    @Test
    void testNombreDemasiadoCorto(){
        usuario.setNombre("Fe");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "El nombre es muy corto");
        assertEquals(1, violations.size());
    }

    @Test
    void testApellidoPaternoDemasiadoCorto(){
        usuario.setApellidoPaterno("Ga");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "Apellido paterno demasiado corto");
        assertEquals(1, violations.size());
    }

    @Test
    void testApellidoMaternoDemasiadoCorto(){
        usuario.setApellidoMaterno("Lo");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "Apellido materno demasiado corto");
        assertEquals(1, violations.size());
    }

    @Test
    void testTelefonoDemasiadoCorto(){
        usuario.setTelefono("55 1234");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "No. de telefono demasiado corto");
        assertEquals(1, violations.size());
    }

    @Test
    void testTelefonoDemasiadoLargo(){
        usuario.setTelefono("55 1234 5678 91022");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "No. de telefono demasiado largo");
        assertEquals(1, violations.size());
    }

    @Test
    void correoInvalido(){
        usuario.setCorreo("correo-invalido");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "El correo es invalido");
    }

    @Test
    void contrasenaCorta(){
        usuario.setContrasena("123");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "Debería haber una violación por contraseña corta");
    }

    @Test
    void contrasenaLarga(){
        usuario.setContrasena("123898989898989898989898989898989898989898989898989898989898989898989898989898898989898989898989898988989899898898");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "La contraseña es muy larga");
    }

    @Test
    void testCamposObligatorios() {
        usuario = new Usuario(
                null, null, null,
                null, null, null, 0.0,
                null, null
        );
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty(), "Todos los campos son obligatorios");
    }
}