package org.dam2.unoamuchos;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Depart {

	@EqualsAndHashCode.Include
	@Id
	private String deptNo;
	
	private String dname;
	private String loc;
	
	
	 @Singular
	 
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)// Por defecto LAZY
	 // Evitar tabla intermedia Depto-Empleado
	 @JoinColumn(name="FK_DEPTNO")
	 private Set<Empleado> empleados;

	
		
}
