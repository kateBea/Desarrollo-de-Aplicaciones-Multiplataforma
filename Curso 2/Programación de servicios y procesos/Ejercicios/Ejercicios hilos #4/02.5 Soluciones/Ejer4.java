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
  boolean mImprimiendo;
  public Impresora(int id) { 
    mId = id;
    mSem = new Semaphore(0);
    mSemHilos = new Semaphore(1);
    mImprimiendo = false;
  }
  public void imprimir(String texto) {
    ThreadUtils.acquire(mSemHilos);
    System.out.println("Impresora " + mId + ": Se solicita imprimir el texto " + texto);
    mTextoImprimible = texto;
    mSem.release();
  }
  public void run() {
    while(true) {
      ThreadUtils.acquire(mSem);
      mImprimiendo = true;
      System.out.println("Impresora " + mId + ": imprimiendo: " + mTextoImprimible);
      ThreadUtils.dormir();
      System.out.println("Impresora " + mId + ": Texto impreso " + mTextoImprimible);
      mImprimiendo = false;
      mSemHilos.release();
    }
  }
  public boolean imprimiendo() {
    return mImprimiendo;
  }
}

class Impresoras {
  Semaphore mSemControl;
  Semaphore mSemImpresoras;
  Impresora mImpresoras[];
  public Impresoras(int nImpresoras) {
    mImpresoras = new Impresora[nImpresoras];
    mSemControl = new Semaphore(nImpresoras);
    mSemImpresoras = new Semaphore(1);
    for(int n = 0; n < mImpresoras.length; n++) {
      mImpresoras[n] = new Impresora(n);
      mImpresoras[n].start();
    }
  }
  public void imprimir(String texto) {
    ThreadUtils.acquire(mSemControl);
    ThreadUtils.acquire(mSemImpresoras);
    for(Impresora impresora : mImpresoras) {
      if(!impresora.imprimiendo()) {
        impresora.imprimir(texto);
        break;
      }
    }
    mSemImpresoras.release();
    mSemControl.release();
  }
}

class Hilo extends Thread {
  int mId;
  Impresoras mImpresoras;
  public Hilo(int id, Impresoras impresoras) {
    mId = id;
    mImpresoras = impresoras;
  }
  public void run() {
    while(true) {
      ThreadUtils.dormir();
      mImpresoras.imprimir("Hilo " + mId);
    }
  }
}

class Ejer4 {
  public static void main (String[] args) {
    Impresoras impresoras = new Impresoras(10);
    Hilo hilos[] = new Hilo[100];
    for(int n = 0; n < hilos.length; n++) {
      hilos[n] = new Hilo(n, impresoras);
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
