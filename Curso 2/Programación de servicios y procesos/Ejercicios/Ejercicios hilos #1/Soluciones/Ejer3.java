import java.io.*;

class Ejer3 extends Thread 	{
	private String mNombreArchivo;
	private String mContenidos;

	public Ejer3(String nombreArchivo, String contenidos) {
		mNombreArchivo = nombreArchivo;
		mContenidos = contenidos;
		start();
	}

	public void run() {
		try {
			FileWriter out = new FileWriter(mNombreArchivo);
			BufferedWriter bout = new BufferedWriter(out);
			bout.write(mContenidos);
			bout.close();
		} catch(IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

  public static void main(String args[]) {
	Ejer3 out1 = new Ejer3("salida1.txt", "Hola mundo 1\n");
	Ejer3 out2 = new Ejer3("salida2.txt", "Hola mundo 2\n");
  }
}
