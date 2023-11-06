package ejercicios_jaxb_1.Cartelera_Solucion;

import java.time.LocalDate;
import java.util.Arrays;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumEdadAdapterXML extends XmlAdapter <String, Edad> {

	@Override
	public Edad unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		
		Edad edad = Arrays.stream(Edad.values()).
						filter(e -> e.toString().equals(v)).
						findFirst().
						orElse(Edad.TODOSLOSPUBLICOS);;
		
		return edad;
	}

	@Override
	public String marshal(Edad v) throws Exception {
		// TODO Auto-generated method stub
		return v== null?null:v.toString();
	}

}
