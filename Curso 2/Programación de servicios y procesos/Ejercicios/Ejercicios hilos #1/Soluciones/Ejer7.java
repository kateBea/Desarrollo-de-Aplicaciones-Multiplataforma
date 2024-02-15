import java.util.concurrent.ThreadLocalRandom;

class Ejer7Mensaje {
	private int n = 0;
	synchronized void incrementar() {
		n++;
		System.out.println("Incrementar " + n);
	}
	
	synchronized void decrementar() {
		n--;
		System.out.println("Decrementar " + n);
	}
}

class Ejer7Hilo1 extends Thread {
	private Ejer7Mensaje mMensaje;

	public Ejer7Hilo1(Ejer7Mensaje mensaje) {
		mMensaje = mensaje;
	}

	public void run() {
		while(true) {
			mMensaje.incrementar();
			try {
				sleep(ThreadLocalRandom.current().nextInt(1, 1000));
			} catch(InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}

class Ejer7Hilo2 extends Thread {
	private Ejer7Mensaje mMensaje;

	public Ejer7Hilo2(Ejer7Mensaje mensaje) {
		mMensaje = mensaje;
	}

	public void run() {
		while(true) {
			mMensaje.decrementar();
			try {
				sleep(ThreadLocalRandom.current().nextInt(1, 1000));
			} catch(InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}

class Ejer7 {
  public static void main(String args[]) {
	Ejer7Mensaje mensaje = new Ejer7Mensaje();
	
	Thread hilo1 = new Ejer7Hilo1(mensaje);
	Thread hilo2 = new Ejer7Hilo2(mensaje);
	
	hilo1.start();
	hilo2.start();
  }
}
