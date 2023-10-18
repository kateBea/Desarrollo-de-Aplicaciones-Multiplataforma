package dam2.pruebadom;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import daw.com.Teclado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;


// Anotaciones Lombok
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

// Anotaciones XML
@XmlRootElement // Podría ser un elemento raíz, no es necesaria
@XmlType (propOrder = { "nombre", "dept", "sueldo", "fechaNacimiento"}) // orden en el xml, sino es alfabético
@XmlAccessorType(XmlAccessType.FIELD) // Permite poner las anotaciones en lo atributos
public class Empleado {
		
		@EqualsAndHashCode.Include
		@NonNull
		@XmlAttribute
		private String id;
		private String nombre;
		private String dept;
		private float sueldo;
		// Adaptador a tipos no básicos
		//@XmlJavaTypeAdapter(LocalDateAdapter.class)
		//private LocalDate fechaNacimiento;
		
	
}
