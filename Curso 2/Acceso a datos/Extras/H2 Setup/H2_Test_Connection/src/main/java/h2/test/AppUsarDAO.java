package h2.test;

import java.time.LocalDate;

import daw.com.Teclado;

public class AppUsarDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartDAO dao = new DepartDAO();
		Depart depart;
		String deptno;
		
		
		// Mostrar todos los departamentos
		dao.findAll().forEach(System.out::println);
		
		// Mostrar un departamento
		deptno = Teclado.leerString("indicar codigo depto");
		
		dao.findById(deptno).ifPresent(System.out::println);
		
		
		// Insertar un departamento
		depart = Depart.builder().build();
		
		depart.setDeptNo(Teclado.leerString("nº departamento"));
		depart.setDname(Teclado.leerString("Nombre"));
		depart.setLoc(Teclado.leerString("Localizado en: "));
		depart.setFechaCreacion(LocalDate.parse(Teclado.leerString("Fecha creacion")));
		
		if (dao.save(depart) > 0)
			System.out.println("Departamento insertado correctamente");
	}

}
