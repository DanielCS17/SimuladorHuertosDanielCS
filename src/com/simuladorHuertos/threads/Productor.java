package com.simuladorHuertos.threads;

import com.simuladorHuertos.resources.Huerto;

public class Productor extends Thread{
    private String nombre;
    private int produccionMax;
    private int tiempoCrecimientoSegMax;
    private Huerto huerto;

    public Productor(String nombreProductor, int maxProduccion, int tiempoMaxCrecimiento, Huerto huerto) {
        this.nombre = nombreProductor;
        this.produccionMax = maxProduccion;
        this.tiempoCrecimientoSegMax = tiempoMaxCrecimiento;
        this.huerto = huerto;
    }

    private String vegetalAleatorio() {
        String[] vegetal = {"lettuce",  "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};
        return vegetal[(int) (Math.random() * (vegetal.length - 1))];
    }

    private long tiempoCrecimientoAleatorio() {
        return (long) (Math.random() * (this.tiempoCrecimientoSegMax - 1)) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.produccionMax; i++) {
            try {
                String vegetalProducido = this.vegetalAleatorio();
                long growTime = this.tiempoCrecimientoAleatorio();
                Thread.sleep(growTime * 1000);
                this.huerto.agregarVegetal(this.nombre, vegetalProducido);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}