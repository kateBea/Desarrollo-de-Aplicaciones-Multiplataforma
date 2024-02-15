// Solución al problema del Lector-Escritor con prioridad de lectura

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

class Compartido {
    public int nLectores;
    public Semaphore semaforoNLectores;
    public Semaphore semaforoRecurso;

    // Recurso: En este caso se usa un array, pero puede ser cualquier otro recurso
    public int temperaturas[];

    public Compartido() {
        semaforoNLectores = new Semaphore(1);
        nLectores = 0;
        semaforoRecurso = new Semaphore(1);

        // Se inicializa el recurso
        temperaturas = new int[10];
        for(int i = 0; i < temperaturas.length; i++)
            temperaturas[i] = 0;
    }
}

class Lector extends Thread {
    private Compartido m;
		private int mInvestigador;

    public Lector(Compartido compartido, int investigador) {
        m = compartido;
				mInvestigador = investigador;
    }

    public void run() {
			while(true) {
        try {
					  sleep(ThreadLocalRandom.current().nextInt(100, 2000));
            m.semaforoNLectores.acquire();
            m.nLectores++;
            
            if(m.nLectores == 1) // Se bloquean los escritores
                m.semaforoRecurso.acquire();

            m.semaforoNLectores.release();

                // Se lee el recurso
                System.out.print("Investigador " + mInvestigador + " lee las temperaturas ");
                for(int i = 0; i < m.temperaturas.length; i++) {
                    System.out.print(" " + m.temperaturas[i]);
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
}

class Escritor extends Thread {
    private Compartido m;
		private int mTermometro;

    public Escritor(Compartido compartido, int nTermometro) {
        m = compartido;
				mTermometro = nTermometro;
    }

    public void run() {
			while(true) { 
        try {
            m.semaforoRecurso.acquire();

                // Se lee escribe en el recurso
                m.temperaturas[mTermometro] = ThreadLocalRandom.current().nextInt(-10, 40);
                // System.out.println("Termometro " + mTermometro + " escribe " + m.temperaturas[mTermometro]);

            m.semaforoRecurso.release();

        } catch(InterruptedException e) {
            System.err.println(e);
        }
			}
    }
}

class Ejer2 {
    public static void main(String args[]) {
        Lector investigador[] = new Lector[2];
        Escritor termometro[] = new Escritor[10];
        Compartido compartido = new Compartido();

				for(int i = 0; i < investigador.length; i++) {
					investigador[i] = new Lector(compartido, i);
					investigador[i].start();
				}
        for(int i = 0; i < termometro.length; i++) {
          termometro[i] = new Escritor(compartido, i);
          termometro[i].start();
        }
    }
}
