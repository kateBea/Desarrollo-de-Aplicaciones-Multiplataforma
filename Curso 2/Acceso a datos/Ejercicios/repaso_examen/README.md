# Etiquetas

- @XmlRootElement: Se utiliza para marcar una clase como el elemento raíz de un documento XML.
  
```Java
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
    // Atributos y métodos de la clase
}
```

- @XmlElement: Se utiliza para especificar el nombre del elemento XML que se asociará con un campo o método de una clase.

```Java
import javax.xml.bind.annotation.XmlElement;

public class Persona {
    @XmlElement
    private String nombre;
    
    // Otros atributos y métodos
}
```

- @XmlAccessorType: Se utiliza para especificar cómo se accederá a los campos de la clase para la serialización XML.
  
```Java
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    // Atributos y métodos de la clase
}
```

- @XmlAttribute: Se utiliza para especificar que un campo se debe representar como un atributo XML en lugar de un elemento.
  
```Java
import javax.xml.bind.annotation.XmlAttribute;

public class Persona {
    @XmlAttribute
    private int id;
    
    // Otros atributos y métodos
}
```

- Ejemplo completo:

```Java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBExample {
    public static void main(String[] args) throws JAXBException {
        // Crear un objeto Persona
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Juan");

        // Marshall (convertir objeto a XML)
        JAXBContext context = JAXBContext.newInstance(Persona.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(persona, writer);
        String xml = writer.toString();
        System.out.println("XML generado:\n" + xml);

        // Unmarshall (convertir XML a objeto)
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        Persona personaDeserializada = (Persona) unmarshaller.unmarshal(reader);
        System.out.println("Objeto deserializado:\n" + personaDeserializada.toString());
    }
}
```