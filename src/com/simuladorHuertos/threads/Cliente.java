package com.simuladorHuertos.threads;

import com.simuladorHuertos.resources.Huerto;

public class Cliente extends Thread {

    private String nombre;
    private Huerto huerto;
    private int consumirMax;
    private final long TIEMPO_CONSUMO;

    public Cliente(String nombreCliente, int maxConsumir, int tiempoConsumoSeg, Huerto huerto) {
        this.nombre = nombreCliente;
        this.consumirMax = maxConsumir;
        this.huerto = huerto;
        this.TIEMPO_CONSUMO = tiempoConsumoSeg * 1000;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.consumirMax; i++) {
            try {
                String vegetalConsumido = this.huerto.consumirVegetal(this.nombre);
                Thread.sleep(this.TIEMPO_CONSUMO);
                System.out.println("El cliente " + this.nombre + " ha consumido " + vegetalConsumido);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}