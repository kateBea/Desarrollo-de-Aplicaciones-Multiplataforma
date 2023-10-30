package ejemplos_de_uso.ejemplo_uso_jaxb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//Anotaciones Lombok
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

//Anotaciones XML
@XmlRootElement(name="empresa")
@XmlType (propOrder = { "nombreEmpresa", "lista"})
@XmlAccessorType(XmlAccessType.FIELD) 

public class Empleados 
{
		@EqualsAndHashCode.Include
		@NonNull
		private String nombreEmpresa;

 		@XmlElementWrapper(name="empleados") // Indicar que es un contenedor
 		@XmlElement(name="empleado") // elemento repetido del contenedor
		private List<Empleado> lista; 
 		
 		public void addEmpleado (Empleado empleado)
 		{
 			if (lista == null)
 				lista = new ArrayList<>();
 			
 			lista.add(empleado);
 		}
		

}

