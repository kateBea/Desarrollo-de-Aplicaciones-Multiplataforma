/*
 * Examen 3ª Evaluación
 * Este fichero se comenzó a desarrollar para crear una interfaz para gestionar los empleados
 * Tiene errores de compilación, por lo que previamente deberás solucionarlos y a partir de eso
 * continuar para crear la interfaz acordada con el cliente
 */

public class GestionEmpleados_alumnos  {
    //componentes
    JTextField txtId = new JTextField(5);
    JTextField txtFirstName = new JTextField(10);
   
    
  
    
    public GestionEmpleados_alumnos(){
       
        
        this.setup();
    }

    private void setup(){
        Font myFont = new Font ("Segoe print", Font.BOLD, 22);
        JLabel lbTitle = new JLabel("BIENVENIDOS A LA GESTIÓN DE EMPLEADOS",JLabel.CENTER);
        lbTitle.setFont(myFont);
        lbTitle.setForeground(Color.blue);  

        

        JLabel lbMensaje = new JLabel("Estado: ok");
        JLabel lbId = new JLabel("Id:");
        JLabel lbFirstName = new JLabel("Nombre:");
        

  




        
        //---- se crea un panel para colocar los controles etiqueta y caja de texto para cada dato

        JPanel panelId = new JPanel (); //panel para los controles del código empleado
        panelId.setLayout(new FlowLayout());
        panelId.add(lbId);
        panelId.add(txtId);


        JPanel panelFirstName = new JPanel ();//panel para los controles del nombre 
        panelFirstName.setLayout(new FlowLayout());
        panelFirstName.add(lbFirstName);
        panelFirstName.add(txtFirstName);

       
        //---- se crea un panelCentral para colocar cada uno de los paneles que tenemos para cada dato de empleado
               
        JPanel panelCentral = new JPanel (); 
        panelCentral.setLayout(new GridLayout (2,1));     
        panelCentral.add(panelId);     
        panelCentral.add(panelFirstName);
        
     
        //---- se crea un panel para mostrar la información inferior en un mensaje y en un futuro tal vez botones
        JPanel panelSur = new JPanel(new GridLayout(1,2));
        panelSur.add(lbMensaje);
        
  

        setLayout(new BorderLayout());
        add("North", lbTitle);
        add("Center", panelCentral );
        add("South", panelSur );
  
        
        
        setSize(600,200); 

        setVisible(true);
        
    }
    
    
    public static void main (String[] args) {
        GestionEmpleados_alumnos ad =new GestionEmpleados_alumnos();
   
    }
}
