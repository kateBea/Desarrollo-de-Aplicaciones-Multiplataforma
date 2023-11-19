package pruebas.pruebas_de_nivel;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Arrays;
import java.util.Optional;

public class CategoriaXMLAdapter extends XmlAdapter<String, Categoria> {
    @Override
    public Categoria unmarshal(String v) {
        return Arrays.stream(Categoria.values()).filter(categoria -> categoria.toString().equalsIgnoreCase(v)).
                findFirst().orElse(Categoria.DESCONOCIDO);
    }

    @Override
    public String marshal(Categoria v) {
        return v.toString();
    }
}
