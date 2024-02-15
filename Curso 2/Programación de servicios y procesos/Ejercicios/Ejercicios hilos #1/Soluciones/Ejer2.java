class Ejer2 extends Thread 	{
	private String nombre;
	private int inicio, fin;

	public Ejer2(String nombre, int inicio, int fin) {
		this.nombre = nombre;
		this.inicio = inicio;
		this.fin = fin;
	}

	public void run() {
		for(int i = inicio; i <= fin; i++) {
			System.out.println(nombre + " " + i);
		}
	}

  public static void main(String args[]) {
	Contador contador = new Contador();
    Thread h1 = new Ejer2("Hilo 1", 1, 50);
    Thread h2 = new Ejer2("Hilo 2", 51, 100);
    Thread h3 = new Ejer2("Hilo 3", 101, 150);
    Thread h4 = new Ejer2("Hilo 4", 151, 200);
    
    h1.start();
    h2.start();
    h3.start();
    h4.start();
  }
}
