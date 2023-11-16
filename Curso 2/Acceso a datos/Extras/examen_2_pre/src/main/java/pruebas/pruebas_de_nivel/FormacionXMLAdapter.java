package pruebas.pruebas_de_nivel;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;

public class FormacionXMLAdapter extends XmlAdapter<String, Formacion> {
    @Override
    public Formacion unmarshal(String v) throws Exception {
        return Arrays.stream(Formacion.values()).filter(formacion -> formacion.toString().equalsIgnoreCase(v)).
                findFirst().orElse(Formacion.PRESENCIAL);
    }

    @Override
    public String marshal(Formacion v) throws Exception {
        return v.toString();
    }
}
