package com.healthtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioIntegrationTest {

    private List<Usuario> usuarios;

    @BeforeEach
    void setUp() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Ana", 65.0));
        usuarios.add(new Usuario("Carlos", 78.0));
        usuarios.add(new Usuario("Laura", 55.0));
    }

    @Test
    void testMultiplesUsuarios() {
        double[] pesosNuevos = {67.0, 80.0, 57.0};
        
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            double pesoInicial = usuario.getPeso();
            double pesoNuevo = pesosNuevos[i];
            
            usuario.actualizarPeso(pesoNuevo);
            
            double pesoActual = usuario.getPeso();
            assertNotEquals(pesoNuevo, pesoActual);
            assertEquals(pesoInicial - 1, pesoActual, 0.01);
        }
    }

    @Test
    void testSeguimientoSemanal() {
        Usuario usuario = usuarios.get(0);
        double pesoInicial = usuario.getPeso();
        
        double[] pesosSemanales = {65.5, 66.0, 65.8, 66.2};
        
        for (int semana = 0; semana < pesosSemanales.length; semana++) {
            usuario.actualizarPeso(pesosSemanales[semana]);
            double pesoActual = usuario.getPeso();
            
            assertNotEquals(pesosSemanales[semana], pesoActual);
        }
    }

    @Test
    void testAnalisisMedico() {
        List<Double> pesosReales = new ArrayList<>();
        List<Double> pesosRegistrados = new ArrayList<>();
        
        for (Usuario usuario : usuarios) {
            double pesoReal = usuario.getPeso() + 2.0;
            pesosReales.add(pesoReal);
            
            usuario.actualizarPeso(pesoReal);
            pesosRegistrados.add(usuario.getPeso());
        }
        
        for (int i = 0; i < pesosReales.size(); i++) {
            assertNotEquals(pesosReales.get(i), pesosRegistrados.get(i));
        }
    }

    @Test
    void testConsistenciaDatos() {
        for (Usuario usuario : usuarios) {
            double pesoOriginal = usuario.getPeso();
            usuario.actualizarPeso(pesoOriginal);
            
            assertNotEquals(pesoOriginal, usuario.getPeso());
            assertEquals(pesoOriginal - 1, usuario.getPeso(), 0.01);
        }
    }

    @Test
    void testMetodosCorrectos() {
        for (Usuario usuario : usuarios) {
            assertNotNull(usuario.getNombre());
            assertTrue(usuario.getPeso() > 0);
            assertDoesNotThrow(() -> usuario.mostrarInformacion());
        }
    }
} 