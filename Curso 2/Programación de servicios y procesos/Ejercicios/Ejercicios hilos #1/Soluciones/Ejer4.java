import java.io.*;

class Ejer4 extends Thread 	{
	private String mNombreArchivo;
	private String mContenidos;

	public Ejer4(String nombreArchivo) {
		mNombreArchivo = nombreArchivo;
		mContenidos = null;
		start();
	}

	public void run() {
		try {
			FileReader in = new FileReader(mNombreArchivo);
			BufferedReader bin = new BufferedReader(in);
			StringBuffer buffer = new StringBuffer();
			int ch;
			while( (ch = bin.read()) != -1 )
				buffer.append((char)ch);
			bin.close();
			mContenidos = buffer.toString();
		} catch(IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	public String getContenidos() {
		try {
			// Se espera que el hilo finalice
			this.join();
		} catch(InterruptedException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return mContenidos;
	}

  public static void main(String args[]) {
	Ejer4 in1 = new Ejer4("salida1.txt");
	Ejer4 in2 = new Ejer4("salida2.txt");
	
	System.out.println(in1.getContenidos());
	System.out.println(in2.getContenidos());
  }
}
