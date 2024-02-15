import java.util.concurrent.Semaphore;

class ThreadUtils {
  public static void acquire(Semaphore sem) {
    try {
      sem.acquire();
    } catch(InterruptedException e) {
      System.out.println(e);
    }
  }
  public static void dormir() {
    try {
      long tiempoEspera = (long)(Math.random() * 2000.0);
      Thread.sleep(tiempoEspera);
    } catch(InterruptedException e) {
      System.out.println(e);
    }
  }
}

class Impresora {
  int mId;
 public Impresora(int id) { 
    mId = id;
  }
  public void imprimir(String texto) {
    System.out.println("Impresora " + mId + ": imprimiendo: " + texto);
    ThreadUtils.dormir();
    System.out.println("Impresora " + mId + ": Texto impreso " + texto);
  }
}

class Hilo extends Thread {
  int mId;
  Impresora mImpresora;
  Semaphore mSem;
  public Hilo(int id, Impresora impresora, Semaphore semaforo) {
    mId = id;
    mSem = semaforo;
    mImpresora = impresora;
  }
  public void run() {
    while(true) {
      ThreadUtils.dormir();
      ThreadUtils.acquire(mSem);
      mImpresora.imprimir("Hilo " + mId);
      mSem.release();
    }
  }
}

class Ejer1 {
  public static void main (String[] args) {
    Semaphore semaforo = new Semaphore(1);
    Impresora impresora = new Impresora(1);
    Hilo hilos[] = new Hilo[100];
    for(int n = 0; n < hilos.length; n++) {
      hilos[n] = new Hilo(n, impresora, semaforo);
      hilos[n].start();
    }
    try {
      for(int n = 0; n < hilos.length; n++) {
        hilos[n].join();
      }
    } catch(InterruptedException e) {
      System.out.println(e);
    }
  }
}
