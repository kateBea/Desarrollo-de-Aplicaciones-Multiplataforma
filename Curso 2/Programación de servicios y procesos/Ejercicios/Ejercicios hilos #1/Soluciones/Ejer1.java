class Ejer1 implements Runnable 	{
	private String nombre;
	private int inicio, fin;

	public Ejer1(String nombre, int inicio, int fin) {
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
    Ejer1 e1 = new Ejer1("Hilo 1", 1, 50);
    Ejer1 e2 = new Ejer1("Hilo 2", 51, 100);
    Ejer1 e3 = new Ejer1("Hilo 3", 101, 150);
    Ejer1 e4 = new Ejer1("Hilo 4", 151, 200);
    Thread h1 = new Thread(e1);
    Thread h2 = new Thread(e2);
    Thread h3 = new Thread(e3);
    Thread h4 = new Thread(e4);

    h1.start();
    h2.start();
    h3.start();
    h4.start();
  }
}
