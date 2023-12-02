import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.w3c.dom.Element;

import daw.com.Teclado;

public class EscribirEmpleadoFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String respuesta ;
		Empleado empleado;
		ArrayList<Empleado> empleados = new ArrayList<>();
   		
		do
		{
			// Leer empleado
			empleado = new Empleado ();
			empleado.leerEmpleado();
			
			empleados.add(empleado);
			
			respuesta = Teclado.leerString("Introducir otro (S/N)");
			
		}while (respuesta.equals("S"));

		escribirFicheroTexto(empleados);
		escribirFicheroBinario (empleados);
		escribirFicherosSerializar(empleados);
		
	}
	
	public static void escribirFicheroTexto(ArrayList<Empleado> emps)
	{
		FileWriter brutoTexto;
		PrintWriter filtroTexto;
		
		try
		{
			brutoTexto = new FileWriter ("empleados.txt");
			filtroTexto = new PrintWriter (brutoTexto);
			
			for(Empleado e : emps)
			{
				filtroTexto.println(e.getId());
				filtroTexto.println(e.getNombre());
				filtroTexto.println(e.getDept());
				filtroTexto.println(e.getSueldo());
			}
			
			filtroTexto.close();
			brutoTexto.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	
	public static void escribirFicheroBinario(ArrayList<Empleado> emps)
	{
		FileOutputStream brutoBinario;
		DataOutputStream filtroBinario;
		
		try
		{
			brutoBinario = new FileOutputStream ("empleados.dat");
			filtroBinario = new DataOutputStream (brutoBinario);
			
			filtroBinario.writeInt(emps.size());
			
			for(Empleado e : emps)
			{
				filtroBinario.writeBytes(e.getId()+"\n");
				filtroBinario.writeBytes(e.getNombre()+"\n");
				filtroBinario.writeBytes(e.getDept()+"\n");
				filtroBinario.writeFloat(e.getSueldo());
			}
			
			filtroBinario.close();
			brutoBinario.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void escribirFicherosSerializar(ArrayList<Empleado> emps)
	{
		FileOutputStream brutoSerializable;
		ObjectOutputStream filtroSerializable;
		
		try
		{
			brutoSerializable = new FileOutputStream ("empleados.ser");
			filtroSerializable = new ObjectOutputStream (brutoSerializable);
			
			filtroSerializable.writeObject(emps);
	
			
			filtroSerializable.close();
			brutoSerializable.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
