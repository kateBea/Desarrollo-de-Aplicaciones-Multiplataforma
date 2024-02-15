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

class Impresora extends Thread {
  int mId;
  String mTextoImprimible;
  Semaphore mSem;
  Semaphore mSemHilos;
  public Impresora(int id) { 
    mId = id;
    mSem = new Semaphore(0);
    mSemHilos = new Semaphore(1);
  }
  public void imprimir(String texto) {
    ThreadUtils.acquire(mSemHilos);
    mTextoImprimible = texto;
    mSem.release();
  }
  public void run() {
    while(true) {
      ThreadUtils.acquire(mSem);
      System.out.println("Impresora " + mId + ": imprimiendo: " + mTextoImprimible);
      ThreadUtils.dormir();
      System.out.println("Impresora " + mId + ": Texto impreso " + mTextoImprimible);
      mSemHilos.release();
    }
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

class Ejer2 {
  public static void main (String[] args) {
    Semaphore semaforo = new Semaphore(1);
    Impresora impresora = new Impresora(1);
    impresora.start();
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
