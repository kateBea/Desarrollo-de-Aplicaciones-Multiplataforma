package org.example;

import java.util.concurrent.Semaphore;

public class Hilo1 extends Thread {
    private final Semaphore m_WaitSem;

    public Hilo1(Semaphore sem) {
        m_WaitSem = sem;
    }

    @Override
    public void run() {
        try {
            m_WaitSem.acquire();

            System.out.println("Ejecutando tarea hilo 1");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
