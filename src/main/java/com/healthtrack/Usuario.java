package com.healthtrack;

public class Usuario {
    private String nombre;
    private double peso;

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void actualizarPeso(double nuevoPeso) {
        // error: En lugar de asignar el nuevo peso se está restando 1kg
        this.peso -= 1;
    }

    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + ", Peso Actual: " + peso + " kg");
    }
} 