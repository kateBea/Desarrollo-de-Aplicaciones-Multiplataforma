/**
 * Hugo Pelayo
 * 15 Feb 2024
 * Examen PSP
 * */


import java.util.Random;
import java.util.concurrent.Semaphore;

class LibroRegistro {
    public Semaphore semaforo, semaforoLector, semaforoEscritor;
    public int nLectores, nLectoresEsperando, nEscritoresEsperando;
    public boolean escribiendo;

    // Recurso compartido (false -> está libre, true -> está ocupada)
    public boolean habitaciones[];

    public LibroRegistro(int size) {
        semaforo = new Semaphore(1);
        semaforoLector = new Semaphore(0);
        semaforoEscritor = new Semaphore(0);
        nLectores = nLectoresEsperando = nEscritoresEsperando = 0;
        escribiendo = false;

        // Se inicializa el recurso compartido
        habitaciones = new boolean[size];
        for (int i = 0; i < habitaciones.length; i++)
            habitaciones[i] = false;
    }
}

class Agente extends Thread {
    private LibroRegistro m;
    private int mHiloNumero;

    public Agente(LibroRegistro compartido, int nHilo) {
        mHiloNumero = nHilo;
        m = compartido;
    }

    public void run() {
        while (true) {
            int habitacion = -1;
            try {
                m.semaforo.acquire();
                if (m.escribiendo || m.nEscritoresEsperando > 0) {
                    m.nLectoresEsperando++;
                    m.semaforo.release();
                    m.semaforoLector.acquire();
                    m.semaforo.acquire();
                    m.nLectoresEsperando--;
                }
                m.nLectores++;
                if (m.nLectoresEsperando > 0) // Desbloqueo encadenado se desbloquean
                    m.semaforoLector.release(); // todos los lectores que estén esperando
                m.semaforo.release();

                // Se lee el recurso
                // Generamos un índice al azar de habityación y consultamos disponibilidad
                habitacion = (new Random()).nextInt(0, 100);
                if (m.habitaciones[habitacion] == true) {
                    System.out
                            .println("Agente " + mHiloNumero + ": habitación " + habitacion + " está ocupada");
                } else {
                    System.out.println("Agente " + mHiloNumero + ": habitación " + habitacion + " está libre");
                }

                m.semaforo.acquire();
                m.nLectores--;
                // Se desbloquean los escritores
                if (m.nLectores == 0 && m.nEscritoresEsperando > 0)
                    m.semaforoEscritor.release();
                m.semaforo.release();
            } catch (InterruptedException err) {
                System.err.println(err);
            }

            // Se duerme el agente por un tiempo
            try {
                System.out.println("Durmiendo agente " + mHiloNumero);
                Thread.sleep((new Random()).nextInt(0, 2) * 1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}


class Recepcionista extends Thread {
    private LibroRegistro m;
    private int mHiloNumero;
    private int indiceHabitacion;

    public Recepcionista(LibroRegistro compartido, int nHilo) {
        m = compartido;
        mHiloNumero = nHilo;
        indiceHabitacion = -1;
    }

    public int getIndiceHabitacion() {
        return this.indiceHabitacion;
    }

    public void run() {
        while (true) {

            try {
                m.semaforo.acquire();
                if (m.nLectores > 0 || m.escribiendo) {
                    m.nEscritoresEsperando++;
                    m.semaforo.release();
                    m.semaforoEscritor.acquire();
                    m.nEscritoresEsperando--;
                }
                m.escribiendo = true;
                m.semaforo.release();

                // Se escribe en el recurso
                indiceHabitacion = (new Random()).nextInt(0, 100);

                if (m.habitaciones[indiceHabitacion] == false) {
                    System.out.println(
                            "Recepcionista " + mHiloNumero + ": ocupando habitación " + indiceHabitacion);
                    m.habitaciones[indiceHabitacion] = true;
                } else {
                    System.out.println(
                            "Recepcionista " + mHiloNumero + ": se libera habitación " + indiceHabitacion);
                }

                m.semaforo.acquire();
                m.escribiendo = false;
                // Se desbloquea primero a los escritores en espera,
                // después se desbloquea a los lectores:
                if (m.nEscritoresEsperando > 0)
                    m.semaforoEscritor.release();
                else if (m.nLectoresEsperando > 0)
                    m.semaforoLector.release();
                m.semaforo.release();
            } catch (InterruptedException err) {
                System.err.println(err);
            }

            // Se duerme el recepcionista por un tiempo
            try {
                System.out.println("Durmiendo recepcionista " + mHiloNumero);
                Thread.sleep((new Random()).nextInt(0, 5) * 1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

class Ejer1 {
    public static void main(String args[]) {
        Agente agentes[] = new Agente[10];
        LibroRegistro compartido = new LibroRegistro(100);
        Recepcionista recepcionistas[] = new Recepcionista[10];

        for (int i = 0; i < agentes.length; i++) {
            // tienen mismo size
            agentes[i] = new Agente(compartido, i + 1);
            recepcionistas[i] = new Recepcionista(compartido, i + 1);

            agentes[i].start();
            recepcionistas[i].start();
        }

        // No necesario porque los hilos están en bucle infinito
        for (int i = 0; i < recepcionistas.length; i++) {
            try {
                agentes[i].join();
                recepcionistas[i].join();
            } catch (InterruptedException err) {
                System.err.println(err);
            }
        }
    }
}
