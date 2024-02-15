
import java.util.concurrent.Semaphore;

class Buffer {
	public Semaphore binario, vacios, llenos;
	public int buffer[];
	public int N; // Tamaño del buffer
	public int cabeza, cola;
	public Buffer(int N) {
		this.N = N;
		binario = new Semaphore(1);
		vacios = new Semaphore(N);
		llenos = new Semaphore(0);
		buffer = new int[N];
		cabeza = cola = 0;
	}
}

class Productor extends Thread {
	private Buffer mBuffer;
	private String mNombre;
	private int an, ann;

	public Productor(Buffer buffer, String nombre) {
		mBuffer = buffer;
		mNombre = nombre;
		an = 1;
		ann = 0;
	}

	public void run() {
		try {
			int a;
			for(int i = 0; i < 10; i++) {
				
				mBuffer.vacios.acquire();
				mBuffer.binario.acquire();

					mBuffer.buffer[mBuffer.cabeza] = ann;
					System.out.println("El Hilo productor " + mNombre + " ha insertado " + ann);
					mBuffer.cabeza = (mBuffer.cabeza + 1) % mBuffer.N;
				
				mBuffer.binario.release();
				mBuffer.llenos.release();
				
				a = an + ann;
				ann = an;
				an = a;
			}
			System.out.println("Fin del Hilo productor " + mNombre);
		} catch(InterruptedException e) {
			System.err.println(e);
		}
	}
}

class Consumidor extends Thread {
	private Buffer mBuffer;
	private String mNombre;

	public Consumidor(Buffer buffer, String nombre) {
		mBuffer = buffer;
		mNombre = nombre;
	}

	public void run() {
		try {
			int i;
			while(true) {
				mBuffer.llenos.acquire();
				mBuffer.binario.acquire();
					
					i = mBuffer.buffer[mBuffer.cola];
					mBuffer.cola = (mBuffer.cola + 1) % mBuffer.N;
				
				mBuffer.binario.release();
				mBuffer.vacios.release();
				
				System.out.println("El Hilo consumidor " + mNombre + " i= " + 2 * i);
			}
		} catch(InterruptedException e) {
			System.err.println(e);
		}
	}
}


class ProductorConsumidor {
  public static void main(String args[]) {
	Buffer buffer = new Buffer(10);
	
	Consumidor  consumidores[] = new Consumidor[5];
	Productor productor = new Productor(buffer, "P");
	
	for(int i = 0; i < 5; i++) { 
		consumidores[i] = new Consumidor(buffer, "C" + i);
		consumidores[i].start();
	}
	
	productor.start();
  }
}
