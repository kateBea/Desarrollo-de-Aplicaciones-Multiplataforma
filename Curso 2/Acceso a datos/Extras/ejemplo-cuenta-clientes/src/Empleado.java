import daw.com.Teclado;

public class Empleado {

	private String id;
	private String nombre;
	private String dept;
	private float sueldo;
	

	
	
	public Empleado() 
	{
		this("","", "", 0);
	}

	public Empleado(String id, String nombre, String dept, float sueldo) 
	{
		this.id = id;
		this.nombre = nombre;
		this.dept = dept;
		this.sueldo = sueldo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", dept=" + dept + ", sueldo=" + sueldo + "]";
	}
	
	public void leerEmpleado()
	{
		
		id = Teclado.leerString("ID");
		nombre = Teclado.leerString("NOMBRE");
		dept = Teclado.leerString("DEPT");
		sueldo = Teclado.leerFloat("SALARIO");
		
	}
	
	
	
}
