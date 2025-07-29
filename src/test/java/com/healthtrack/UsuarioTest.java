package com.healthtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan", 70.0);
    }

    @Test
    void testCrearUsuario() {
        assertEquals("Juan", usuario.getNombre());
        assertEquals(70.0, usuario.getPeso(), 0.01);
    }

    @Test
    void testActualizarPesoError() {
        double pesoInicial = usuario.getPeso();
        usuario.actualizarPeso(75.0);
        
        double pesoActual = usuario.getPeso();
        assertNotEquals(75.0, pesoActual);
        assertEquals(69.0, pesoActual, 0.01);
    }

    @Test
    void testActualizarPesoMultiple() {
        usuario.actualizarPeso(75.0);
        assertEquals(69.0, usuario.getPeso(), 0.01);

        usuario.actualizarPeso(80.0);
        assertEquals(68.0, usuario.getPeso(), 0.01);

        usuario.actualizarPeso(65.0);
        assertEquals(67.0, usuario.getPeso(), 0.01);
    }

    @Test
    void testImpactoUsuario() {
        double pesoReal = 72.0;
        usuario.actualizarPeso(pesoReal);
        
        double pesoMostrado = usuario.getPeso();
        assertNotEquals(pesoReal, pesoMostrado);
        assertTrue(pesoMostrado < pesoReal);
    }

    @Test
    void testDecisionesMedicas() {
        Usuario paciente = new Usuario("Maria", 70.0);
        double pesoActual = 68.0;
        paciente.actualizarPeso(pesoActual);
        
        double pesoRegistrado = paciente.getPeso();
        assertNotEquals(pesoActual, pesoRegistrado);
    }

    @Test
    void testMostrarInformacion() {
        assertDoesNotThrow(() -> usuario.mostrarInformacion());
    }
} 