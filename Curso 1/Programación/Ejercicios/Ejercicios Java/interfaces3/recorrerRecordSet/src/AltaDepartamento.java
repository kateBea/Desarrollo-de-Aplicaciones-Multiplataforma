import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AltaDepartamento extends JFrame implements ActionListener {
    //componentes
    private static JTextField  txtId = new JTextField(5);
    private static JTextField  txtName = new JTextField(10);

    private   static Connection cnx=null;   
    private static Statement  stmt=null;             
    private  static ResultSet  rs=null;
    
    
    public AltaDepartamento(){
        super("Alta Departamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setup();
    }

    private void setup(){
        Font myFont = new Font ("Segoe print", Font.BOLD, 22);
        JLabel lbTitle = new JLabel("BIENVENIDOS",JLabel.CENTER);
        lbTitle.setFont(myFont);        
        JLabel lbMensaje = new JLabel("");
        JLabel lbId = new JLabel("Id departamento:");
        JLabel lbName = new JLabel("Titulo departamento:");

        JButton btnSiguiente = new JButton (">>");
        JButton btnAnterior = new JButton ("<<");
        JButton btnAlta = new  JButton ("Alta");
        JPanel panelCentral = new JPanel();      
        JPanel panelBotonera = new JPanel();
        btnAlta.addActionListener(this);
        btnSiguiente.addActionListener(this);
        btnAnterior.addActionListener(this);

      
        panelBotonera.add(btnSiguiente);
        panelBotonera.add(btnAlta);
        panelBotonera.add(btnAnterior);

        txtId.setEnabled(false);
        txtName.setEnabled(false);

        JPanel panelId = new JPanel ();
        panelId.setLayout(new FlowLayout());
        panelId.add(lbId);
        panelId.add(txtId);


        JPanel panelName = new JPanel ();
        panelName.setLayout(new FlowLayout());
        panelName.add(lbName);
        panelName.add(txtName);



        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout (3,1));
        panel1.add(panelId);     
        panel1.add(panelName);
       

        panelCentral.setLayout(new GridLayout (3,2));
     
        panelCentral.add(panelId);     
        panelCentral.add(panelName);
     
        
        setLayout(new GridLayout (4,1));
        add( lbTitle);
        add(panelCentral );
        add(panelBotonera );
        add(lbMensaje );
        
        
        setSize(600,300); //damos tamaño

        setVisible(true);
        
    }
    private void alta_dpto(){
        txtId.setText("");txtName.setText("");
        txtId.setEnabled(true);
        txtName.setEnabled(true);

        

    }

    private static void next(){
        //si no ha llegado al final
        try{
                Integer id=null;          
                
                if(rs.next()){
                    id = rs.getInt("dep_no");
                    System.out.println(id);   
                    txtId.setText(String.valueOf(id)); 
                    txtName.setText(rs.getString("dnombre")); 
                }                       

            
        }catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
         }
    

    }


    private static void prev(){
        //si no ha llegado al final
        try{
                Integer id=null;         
                String name=null; 
                
                if(rs.previous()){
                    id = rs.getInt("dep_no");
                    System.out.println(id);   
                    txtId.setText(String.valueOf(id)); 
                    txtName.setText(rs.getString("dnombre"));  
                }                       

            
        }catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
         }
    

    }
    public void actionPerformed (ActionEvent ev){
        JButton btn = (JButton) ev.getSource();
        String texto = btn.getActionCommand().toString();
        System.out.println (texto);
        switch(texto){
            case "Alta":
                alta_dpto();
                break;

            case "<<":
                prev();
                break;

            case ">>":
                
                next();
                break;
        }

    }

    private static  boolean loadDriver(String driver){        
        try {
            Class.forName (driver);
            System.out.print ("Driver cargado correctamente.\n");
            return true;
        } catch (Exception e) {
            System.out.print ("No se pudo cargar el driver" + e);
            return false;
        }   
    }
    private static void conectaBD(){
        if (loadDriver("com.mysql.cj.jdbc.Driver")==false){
            System.out.print ("No se pudo cargar el driver");
            return;
        }
        
    }
    private static void setConnection(String server, String dbName, String user, String pass){
        String url= "jdbc:mysql://" + server + "/" +dbName;
        try{
            cnx =DriverManager.getConnection(url, user, pass);
            System.out.println ("Conexión a la BD " + dbName + " OK. \n");
        }catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
    public static ResultSet getResulSet (String sql){
        ResultSet resul=null;
        try{
            stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // Se crea una sentencia jdbc para realizar la consulta  
            rs = stmt.executeQuery(sql); // Se ejecuta la sentencia y se recibe un resultado            
            if (rs.next ()) {//se valida si hay resultados                    
                resul= rs;
            }else {
                System.out.println ("No hay resultados");  
                return resul;              
            }                      
            
        }catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
        }catch (Exception e){
                System.out.println("Exception: " + e.getMessage());
        }
        return resul;
    }
    private static void cargarDatos(ResultSet rs){
       try{
            Integer id =rs.getInt("dep_no");
            txtId.setText(String.valueOf(id));
            String name =rs.getString("dnombre");
            txtName.setText(name);
       }catch (SQLException sqe){
            System.out.println("SQLException: " + sqe.getMessage());
       } 
    }

    public static void main (String[] args) {
        AltaDepartamento ad =new AltaDepartamento();
        conectaBD();
        setConnection("localhost:3306", "curso" ,"root","Password1234" ); 
        String sql = "SELECT * FROM DEPARTAMENTOS";
        ResultSet rs=getResulSet(sql);
        if (rs!=null) cargarDatos(rs);
    }
}
