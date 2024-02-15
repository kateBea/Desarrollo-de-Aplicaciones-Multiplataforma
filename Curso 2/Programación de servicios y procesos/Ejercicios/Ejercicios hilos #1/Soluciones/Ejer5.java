class Ejer5 {

  public static void main(String args[]) {
	// Se lee el archivo de forma asíncrona
	Ejer4 in1 = new Ejer4("plantilla.txt");
	
	int suma = 0;
	for(int i = 1; i < 100; i++)
		suma += i;
	
	String plantilla = in1.getContenidos();
	String salida = plantilla.replace("{suma}", "" + suma);
	
	Ejer3 out1 = new Ejer3("salida5.txt", salida);
	System.out.println("La suma es " + suma);
  }
}
