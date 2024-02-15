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
			buffer[i] = 0;
	}
}

class Lector extends Thread {
	private Compartido m;
	private int mHiloNumero;

	public Lector(Compartido compartido, int nHilo) {
		mHiloNumero = nHilo;
		m = compartido;
	}

	public void run() {
		while(true) {
			int silla = -1;
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
						for(int i = 0; i < m.buffer.length; i++)
							if(m.buffer[i] == 0) {
								silla = i;
								break;
							}
						System.out.println("Hilo " + mHiloNumero + " intentando ocupar silla " + silla);
		
				m.semaforo.acquire();
				m.nLectores--;
				// Se desbloquean los escritores
				if(m.nLectores == 0 && m.nEscritoresEsperando > 0)
					m.semaforoEscritor.release();
				m.semaforo.release();
			} catch(InterruptedException err) {
				System.err.println(err);
			}
	
			// Se lanza un escritor que trata de ocupar la silla
			Escritor e = new Escritor(m, silla, mHiloNumero);
			e.start();
			try {
				e.join();
			} catch(InterruptedException err) {
				System.err.println(err);
			}
			if(e.getSilla() == silla) {
				System.out.println("Hilo " + mHiloNumero + " ocupa la silla " + silla);
				break; // Silla ocupada, se sale del bucle
			}
		}
	}
}

class Escritor extends Thread {
	private Compartido m;
	private int mHiloNumero;
	private int silla;

	public Escritor(Compartido compartido, int silla, int nHilo) {
		m = compartido;
		mHiloNumero = nHilo;
		this.silla = silla;
	}

	public int getSilla() {
		return this.silla;
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
				if(m.buffer[silla] == 0)
					m.buffer[silla] = mHiloNumero;
				else
					silla = -1;
	
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

class Ejer1 {
	public static void main(String args[]) {
		Lector l[] = new Lector[10];
			Compartido compartido = new Compartido();
			for(int i = 0; i < l.length; i++) {
				l[i] = new Lector(compartido, i + 1);

				l[i].start();
			}
			for(int i = 0; i < l.length; i++) {
				try {
					l[i].join();
				} catch(InterruptedException err) {
					System.err.println(err);
				}
			}
		
			System.out.println("Ocupación final de las sillas:");

			for(int i = 0; i < compartido.buffer.length; i++) {
				System.out.println("Silla " + i + " ocupada por hilo " + compartido.buffer[i]);
			}
	}
}
