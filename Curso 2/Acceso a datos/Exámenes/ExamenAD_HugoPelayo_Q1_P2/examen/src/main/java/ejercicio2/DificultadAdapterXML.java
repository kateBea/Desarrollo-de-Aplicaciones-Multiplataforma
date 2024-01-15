package ejercicio2;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DificultadAdapterXML extends XmlAdapter<String, Dificultad> {

    @Override
    public Dificultad unmarshal(String v) throws Exception {
        return Dificultad.from(v);
    }

    @Override
    public String marshal(Dificultad v) throws Exception {
        return v.toString();
    }
    
}
