package dam2.pruebadom;

import java.time.LocalDate;

import daw.com.Teclado;

public class ControladorEmpleadoConsola implements Controlador<Empleado> {

	@Override
	public void leerClave(Empleado pojo) {
		// TODO Auto-generated method stub

		pojo.setId (Teclado.leerString("ID"));

	}

	@Override
	public void leerOtrosDatos(Empleado pojo) {
		// TODO Auto-generated method stub
		pojo.setNombre (Teclado.leerString("NOMBRE"));
		pojo.setDept (Teclado.leerString("DEPT"));
		pojo.setSueldo (Teclado.leerFloat("SALARIO"));
		// usa fomrato ISO año-mes-dia
		//pojo.setFechaNacimiento (LocalDate.parse(Teclado.leerString("FECHA NACIMIENTO")));
		

	}

}
