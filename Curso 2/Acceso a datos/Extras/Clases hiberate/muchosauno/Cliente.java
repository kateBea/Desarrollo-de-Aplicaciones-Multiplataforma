package org.dam2.muchosauno;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dam2.muchosauno.Factura.FacturaBuilder;

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
@Table(name = "CLIENTES")
public class Cliente {
	
		@EqualsAndHashCode.Include
	 	@Id
	    //@GeneratedValue(strategy = GenerationType.TABLE)
	    private long id;
	    
	    @Column(name = "NOMBRE", nullable = false, length = 100)
	    private String nombre;

}
