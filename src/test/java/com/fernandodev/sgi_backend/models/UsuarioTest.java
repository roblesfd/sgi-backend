package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.Rol;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UsuarioTest {
    @Test
    public void testConstructorWithParams(){
        //Arrange
        Usuario usuario = new Usuario("Fernando", "Gomez", "Perez", "55 1234 5678", "Direccion X", Rol.ADMIN, 5000.0, "fer@example.com", "password123");

        //Act y Assert
        usuario.setId(1L);
        assertEquals(1L, usuario.getId());
        assertEquals("Fernando", usuario.getNombre());
        assertEquals("Gomez", usuario.getApellidoPaterno());
        assertEquals("Perez", usuario.getApellidoMaterno());
        assertEquals("55 1234 5678", usuario.getTelefono());
        assertEquals("Direccion X", usuario.getDireccion());
        assertEquals(Rol.ADMIN, usuario.getRol());
        assertEquals(5000.0, usuario.getSalario());
        assertEquals("fer@example.com", usuario.getCorreo());
        assertEquals("password123", usuario.getContrasena());
    }

    @Test
    public void testDefaultConstructor() {
        //Arrange
        Usuario usuario = new Usuario();
        //Act y Assert
        assertNull(usuario.getId());
        assertNull(usuario.getNombre());
        assertNull(usuario.getApellidoPaterno());
        assertNull(usuario.getApellidoMaterno());
        assertNull(usuario.getTelefono());
        assertNull(usuario.getDireccion());
        assertNull(usuario.getRol());
        assertEquals(0.0, usuario.getSalario());
        assertNull(usuario.getCorreo());
        assertNull(usuario.getContrasena());
    }
}
