package org.example;

import java.util.concurrent.Semaphore;

public class Hilo2 extends Thread {
    private final Semaphore m_WaitSem;
    private final Semaphore m_SecondaryWaitSem;

    public Hilo2(Semaphore sem, Semaphore secondary) {
        m_WaitSem = sem;
        m_SecondaryWaitSem = secondary;
    }

    @Override
    public void run() {
        try {
            m_WaitSem.acquire();
            System.out.println("Ejecutando tarea hilo 2 después de 3");

            m_SecondaryWaitSem.release();
            System.out.println("Ejecutando tarea hilo 2 antes de 1");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
