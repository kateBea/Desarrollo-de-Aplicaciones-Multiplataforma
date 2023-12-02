import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LeerEmpleadoFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ArrayList<Empleado> empleados;
		
		empleados = leerFicheroTexto ();
		mostrarEmpleados (empleados);
	
		empleados = leerFicheroBinario ();
		mostrarEmpleados (empleados);
		
		empleados = leerFicheroSerializar ();
		mostrarEmpleados (empleados);

	}
	
	public static ArrayList<Empleado> leerFicheroBinario ()
	{
		
		ArrayList<Empleado> emps = new ArrayList<>();
		
		FileInputStream brutoTexto;
		DataInputStream filtroTexto;
		Empleado e;
		int cuantos = 0;
		
		try
		{
			brutoTexto = new FileInputStream ("empleados.dat");
			filtroTexto = new DataInputStream (brutoTexto);
			
			cuantos = filtroTexto.readInt();
			
			for (int i = 0; i < cuantos; i++)
			{
				e = new Empleado();
			
				e.setId(filtroTexto.readLine());
				e.setNombre(filtroTexto.readLine());
				e.setDept(filtroTexto.readLine());
				e.setSueldo(filtroTexto.readFloat());
				
				emps.add(e);

			}
			
			filtroTexto.close();
			brutoTexto.close();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		
		
		return emps;
	}

	public static ArrayList<Empleado> leerFicheroTexto ()
	{
		
		ArrayList<Empleado> emps = new ArrayList<>();
		
		FileReader brutoTexto;
		BufferedReader filtroTexto;
		Empleado e;
		
		try
		{
			brutoTexto = new FileReader ("empleados.txt");
			filtroTexto = new BufferedReader (brutoTexto);
			
			while (filtroTexto.ready())
			{
				e = new Empleado();
			
				e.setId(filtroTexto.readLine());
				e.setNombre(filtroTexto.readLine());
				e.setDept(filtroTexto.readLine());
				e.setSueldo(Float.parseFloat(filtroTexto.readLine()));
				
				emps.add(e);

			}
			
			filtroTexto.close();
			brutoTexto.close();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		
		
		return emps;
	}

	
	public static ArrayList<Empleado> leerFicheroSerializar ()
	{
		
		ArrayList<Empleado> emps = null;
		
		FileInputStream brutoSerializar;
		ObjectInputStream filtroSerializar;

		
		try
		{
			brutoSerializar = new FileInputStream ("empleados.ser");
			filtroSerializar = new ObjectInputStream (brutoSerializar);
			
			emps = (ArrayList<Empleado>) filtroSerializar.readObject();
			
			filtroSerializar.close();
			brutoSerializar.close();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		
		
		return emps;
	}
	
	public static void mostrarEmpleados (ArrayList<Empleado> emps)
	{
		for (Empleado e: emps)
			System.out.println(e.toString());
		
	}

}
