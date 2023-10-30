package dam2.org.cartelera;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumGeneroDateAdapterXML extends XmlAdapter <String, Genero> {

	@Override
	public Genero unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub

		return Genero.valueOf(v.toUpperCase());
	}

	@Override
	public String marshal(Genero v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}

}
