package com.simuladorHuertos.resources;
import java.util.ArrayList;

public class Huerto {
    private int capacidad;
    private ArrayList<String> vegetalesDisponibles = new ArrayList<String>();

    public Huerto(int CapacidadMax) {
        this.capacidad = CapacidadMax;
    }

    synchronized public void agregarVegetal(String NombreProductor, String nuevoVegetal) throws InterruptedException {
        while (this.vegetalesDisponibles.size() >= this.capacidad) {
            wait();
        }
        this.vegetalesDisponibles.add(nuevoVegetal);
        System.out.println("El productor " + NombreProductor + " ha generado " + nuevoVegetal);
        notifyAll();
    }

    synchronized public String consumirVegetal(String nombreCliente) throws InterruptedException {
        while (this.vegetalesDisponibles.size() == 0) {
            wait();
        }
        String vegetalParaConsumir = this.vegetalesDisponibles.remove(0);
        notifyAll();
        return vegetalParaConsumir;
    }
}