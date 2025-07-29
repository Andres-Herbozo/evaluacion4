package com.healthtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioRegressionTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Test", 70.0);
    }

    @Test
    void testErrorPersistente() {
        for (int i = 0; i < 5; i++) {
            double pesoInicial = usuario.getPeso();
            double pesoNuevo = 75.0;
            
            usuario.actualizarPeso(pesoNuevo);
            double pesoActual = usuario.getPeso();
            
            assertNotEquals(pesoNuevo, pesoActual);
            assertEquals(pesoInicial - 1, pesoActual, 0.01);
        }
    }

    @Test
    void testDiferentesRangos() {
        double[] pesosNuevos = {50.0, 60.0, 70.0, 80.0, 90.0, 100.0};
        
        for (double pesoNuevo : pesosNuevos) {
            Usuario testUsuario = new Usuario("Test", 70.0);
            double pesoInicial = testUsuario.getPeso();
            
            testUsuario.actualizarPeso(pesoNuevo);
            double pesoActual = testUsuario.getPeso();
            
            assertNotEquals(pesoNuevo, pesoActual);
            assertEquals(pesoInicial - 1, pesoActual, 0.01);
        }
    }

    @Test
    void testValoresLimite() {
        double[] pesosLimite = {0.1, 1.0, 999.9, 1000.0};
        
        for (double pesoLimite : pesosLimite) {
            Usuario testUsuario = new Usuario("Test", 70.0);
            double pesoInicial = testUsuario.getPeso();
            
            testUsuario.actualizarPeso(pesoLimite);
            double pesoActual = testUsuario.getPeso();
            
            assertNotEquals(pesoLimite, pesoActual);
            assertEquals(pesoInicial - 1, pesoActual, 0.01);
        }
    }

    @Test
    void testPrecisionDecimal() {
        double[] pesosDecimales = {70.5, 70.55, 70.555, 70.5555};
        
        for (double pesoDecimal : pesosDecimales) {
            Usuario testUsuario = new Usuario("Test", 70.0);
            double pesoInicial = testUsuario.getPeso();
            
            testUsuario.actualizarPeso(pesoDecimal);
            double pesoActual = testUsuario.getPeso();
            
            assertNotEquals(pesoDecimal, pesoActual);
            assertEquals(pesoInicial - 1, pesoActual, 0.01);
        }
    }

    @Test
    void testComportamientoConsistente() {
        for (int i = 0; i < 10; i++) {
            Usuario testUsuario = new Usuario("Test", 70.0);
            double pesoInicial = testUsuario.getPeso();
            
            testUsuario.actualizarPeso(pesoInicial);
            double pesoActual = testUsuario.getPeso();
            
            assertEquals(pesoInicial - 1, pesoActual, 0.01);
            assertNotEquals(pesoInicial, pesoActual);
        }
    }

    @Test
    void testErrorNoSeCorrige() {
        for (int i = 0; i < 20; i++) {
            double pesoNuevo = 70.0 + i;
            usuario.actualizarPeso(pesoNuevo);
            
            assertNotEquals(pesoNuevo, usuario.getPeso());
        }
    }
} 