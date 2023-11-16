import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Modulos {
	private ArrayList<Modulo> modulos;

	public Modulos() {
		
		this.modulos = new ArrayList<>();
	}

	@XmlElement(name="modulo")
	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Modulos [modulos=" + modulos.toString() + "]";
	}
	
	
	

}
