package dam2.pruebadom;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import daw.com.Teclado;

public class LocalDateAdapter extends XmlAdapter <String, LocalDate>{

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return LocalDate.parse(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}


	

}
