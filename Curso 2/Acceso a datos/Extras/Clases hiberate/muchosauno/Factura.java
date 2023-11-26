package org.dam2.muchosauno;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.dam2.unoamuchos.Depart;
import org.dam2.unoamuchos.Empleado;
import org.dam2.unoamuchos.Depart.DepartBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "FACTURAS")
public class Factura {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
	
	private LocalDate fecha;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name="cliente_identificador")
	private Cliente cliente;

}
