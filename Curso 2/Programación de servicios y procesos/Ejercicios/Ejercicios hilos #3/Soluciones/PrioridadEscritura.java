import java.util.concurrent.Semaphore;

class Compartido {
	public Semaphore semaforo, semaforoLector, semaforoEscritor;
	public int nLectores, nLectoresEsperando, nEscritoresEsperando;
	public boolean escribiendo;
	
	// Recurso compartido
	public int buffer[];

	public Compartido() {
		semaforo = new Semaphore(1);
		semaforoLector = new Semaphore(0);
		semaforoEscritor = new Semaphore(0);
		nLectores = nLectoresEsperando = nEscritoresEsperando = 0;
		escribiendo = false;

		// Se inicializa el recurso compartido
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
			m.semaforo.acquire();
			if(m.escribiendo || m.nEscritoresEsperando > 0) {
				m.nLectoresEsperando++;
				m.semaforo.release();
				m.semaforoLector.acquire();
				m.semaforo.acquire();
				m.nLectoresEsperando--;
			}
			m.nLectores++;
			if(m.nLectoresEsperando > 0)	// Desbloqueo encadenado se desbloquean 
				m.semaforoLector.release();	// todos los lectores que estén esperando
			m.semaforo.release();
	
					// Se lee el recurso
					System.out.print("Lector");
					for(int i = 0; i < m.buffer.length; i++)
						System.out.print(" " + m.buffer[i]);
					System.out.println();
	
			m.semaforo.acquire();
			m.nLectores--;
			// Se desbloquean los escritores
			if(m.nLectores == 0 && m.nEscritoresEsperando > 0)
				m.semaforoEscritor.release();
			m.semaforo.release();
		} catch(InterruptedException err) {
			System.err.println(err);
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
			m.semaforo.acquire();
			if(m.nLectores > 0 || m.escribiendo) {
				m.nEscritoresEsperando++;
				m.semaforo.release();
				m.semaforoEscritor.acquire();
				m.nEscritoresEsperando--;
			}
			m.escribiendo = true;
			m.semaforo.release();
	
				// Se escribe en el recurso
				System.out.println("Escritor");
				for(int i = 0; i < m.buffer.length; i++)
					m.buffer[i]++;
	
			m.semaforo.acquire();
			m.escribiendo = false;
			// Se desbloquea primero a los escritores en espera,
			// después se desbloquea a los lectores:
			if(m.nEscritoresEsperando > 0)
				m.semaforoEscritor.release();
			else if(m.nLectoresEsperando > 0)
				m.semaforoLector.release();
			m.semaforo.release();
		} catch(InterruptedException err) {
			System.err.println(err);
		}
	}
}

class PrioridadEscritura {
	public static void main(String args[]) {
		Compartido compartido = new Compartido();
		Lector l[] = new Lector[10];
		Escritor e[] = new Escritor[10];

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
