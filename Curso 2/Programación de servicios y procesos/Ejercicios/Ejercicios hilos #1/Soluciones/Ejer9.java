
import java.util.concurrent.Semaphore;

class Ejer9Cliente extends Thread {
	private Semaphore mCajas;
	private int mHilo;

	public Ejer9Cliente(Semaphore cajas, int hilo) {
		mCajas = cajas;
		mHilo = hilo;
	}

	public void run() {
		try {
			mCajas.acquire();
			System.out.println("El Hilo " + mHilo + " ha usado la caja");
			mCajas.release();
		} catch(InterruptedException e) {
			System.err.println(e);
		}
	}
}

class Ejer9 {
  public static void main(String args[]) {
	Semaphore cajas = new Semaphore(10);
	
	Thread hilos[] = new Thread[100];
	
	for(int i = 0; i < 100; i++)
		hilos[i] = new Ejer9Cliente(cajas, i);
	
	for(int i = 0; i < 100; i++)
		hilos[i].start();
  }
}
