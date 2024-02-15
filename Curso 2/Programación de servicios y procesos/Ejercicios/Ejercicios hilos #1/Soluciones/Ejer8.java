import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.Semaphore;

class Ejer8Mensaje {
	private Semaphore sem;
	private int n;
	
	public Ejer8Mensaje() {
		n = 0;
		sem = new Semaphore(1);
	}
	
	void incrementar() throws InterruptedException {
		sem.acquire();
		n++;
		System.out.println("Incrementar " + n);
		sem.release();
	}
	
	synchronized void decrementar() throws InterruptedException {
		sem.acquire();
		n--;
		System.out.println("Decrementar " + n);
		sem.release();
	}
}

class Ejer8Hilo1 extends Thread {
	private Ejer8Mensaje mMensaje;

	public Ejer8Hilo1(Ejer8Mensaje mensaje) {
		mMensaje = mensaje;
	}

	public void run() {
		while(true) {
			try {
				mMensaje.incrementar();
				sleep(ThreadLocalRandom.current().nextInt(1, 1000));
			} catch(InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}

class Ejer8Hilo2 extends Thread {
	private Ejer8Mensaje mMensaje;

	public Ejer8Hilo2(Ejer8Mensaje mensaje) {
		mMensaje = mensaje;
	}

	public void run() {
		while(true) {
			try {
				mMensaje.decrementar();
				sleep(ThreadLocalRandom.current().nextInt(1, 1000));
			} catch(InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}

class Ejer8 {
  public static void main(String args[]) {
	Ejer8Mensaje mensaje = new Ejer8Mensaje();
	
	Thread hilo1 = new Ejer8Hilo1(mensaje);
	Thread hilo2 = new Ejer8Hilo2(mensaje);
	
	hilo1.start();
	hilo2.start();
  }
}
