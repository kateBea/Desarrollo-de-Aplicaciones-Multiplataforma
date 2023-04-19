import java.awt.*;
import java.awt.event.*;

public class HolaVentanas extends Frame {

	Label etiqueta = new Label("Hola Ventanas!", Label.CENTER);

	public static void main(String args[]){
	  	HolaVentanas hv = new HolaVentanas();
		hv.setup();
	}

	// Constructor de la clase   
	public HolaVentanas() {	   	 
	 	super("Ejemplo Ventana");             
	 	// Se instancia y registra un receptor de eventos de ventana para
		// concluir el programa cuando se cierre el Farme
	 	addWindowListener(new WindowAdapter() {
	 	  	public void windowClosing(WindowEvent we){	  		 	  	  
	 	  		dispose();
	 	  		System.exit(0);
	 	  	}  		 	  	
	 	  });	
	}

	public void setup() {
		add("Center",etiqueta);
		setSize(200,200);
		show();
	}
}

