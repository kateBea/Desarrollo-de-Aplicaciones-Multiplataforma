// Solución al problema del Lector-Escritor con prioridad de lectura

import java.util.concurrent.Semaphore;

class Compartido {
    public int nLectores;
    public Semaphore semaforoNLectores;
    public Semaphore semaforoRecurso;

    // Recurso: En este caso se usa un array, pero puede ser cualquier otro recurso
    public int buffer[];

    public Compartido() {
        semaforoNLectores = new Semaphore(1);
        nLectores = 0;
        semaforoRecurso = new Semaphore(1);

        // Se inicializa el recurso
        buffer = new int[10];
        for(int i = 0; i < buffer.length; i++)
            buffer[i] = i * 2;
    }
}

class Lector extends Thread {
    private Compartido m;

    public Lector(Compartido compartido) {
        m = compartido;
    }

    public void run() {
        try {
            m.semaforoNLectores.acquire();
            m.nLectores++;
            
            if(m.nLectores == 1) // Se bloquean los escritores
                m.semaforoRecurso.acquire();

            m.semaforoNLectores.release();

                // Se lee el recurso
                System.out.print("Leyendo");
                for(int i = 0; i < m.buffer.length; i++) {
                    System.out.print(" " + m.buffer[i]);
                }
                System.out.println();

            m.semaforoNLectores.acquire();
            m.nLectores--;
            
            if(m.nLectores == 0) // El último lector, libera a los escritores
                m.semaforoRecurso.release();

            m.semaforoNLectores.release();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
    }
}

class Escritor extends Thread {
    private Compartido m;

    public Escritor(Compartido compartido) {
        m = compartido;
    }

    public void run() {
        try {
            m.semaforoRecurso.acquire();

                // Se lee escribe en el recurso
                System.out.println("Escribiendo");
                for(int i = 0; i < m.buffer.length; i++) {
                    m.buffer[i] = m.buffer[i] + 1;
                }

            m.semaforoRecurso.release();

        } catch(InterruptedException e) {
            System.err.println(e);
        }
    }
}

class PrioridadLectura {
    public static void main(String args[]) {
        Lector l[] = new Lector[2];
        Escritor e[] = new Escritor[2];
        Compartido compartido = new Compartido();

        while(true) {
            for(int i = 0; i < l.length; i++) {
                l[i] = new Lector(compartido);
                e[i] = new Escritor(compartido);

                l[i].start();
                e[i].start();
            }

            for(int i = 0; i < l.length; i++) {
                try {
                    l[i].join();
                    e[i].join();
                } catch(InterruptedException err) {
                    System.err.println(err);
                }
            }
        }
    }
}