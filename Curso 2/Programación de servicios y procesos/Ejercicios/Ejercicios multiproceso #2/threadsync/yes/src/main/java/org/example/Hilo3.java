package org.example;

import java.util.concurrent.Semaphore;

public class Hilo3 extends Thread {
    private final Semaphore m_WaitSem;

    public Hilo3(Semaphore sem) {
        m_WaitSem = sem;
    }

    @Override
    public void run() {
        // Ejecutar tarea...
        System.out.println("Ejecutando tarea hilo 3");

        // Liberar
        m_WaitSem.release();
    }
}
