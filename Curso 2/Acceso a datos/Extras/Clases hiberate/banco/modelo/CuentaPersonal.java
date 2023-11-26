package org.dam2.banco.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=true)
@SuperBuilder

@Entity
public class CuentaPersonal extends Cuenta implements Serializable {
	
	
	public static final float COMISION = 0.002f;
	public static final float MAXIMOCOMISION = 4f;
	
	
	private boolean credito;
	
	@Override
	public float maximoNegativo() {
		float maximo = 0;
		
		maximo = totalAvales() / 2;
		
		return -maximo;
	}

	@Override
	public float getComision() {
		// TODO Auto-generated method stub
		return COMISION;
	}

	@Override
	public float getMaximoComision() {
		// TODO Auto-generated method stub
		return MAXIMOCOMISION;
	}

	

}
