import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
         //Creación de objetos
         Connection conexion;
         Statement sentencia;
         ResultSet resultado;
 
         System.out.print("Iniciando el programa...");
 
         //0. Cargar el driver para la BD
     
         try {
             Class.forName ("com.mysql.jdbc.Driver");
         } catch (Exception e) {
             System.out.print ("No se pudo cargar el driver" + e);
             return;
         }
 
         // 1. Conectarse bd
 
         try {
             conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso", "root", "Password1234");
             boolean valid = conexion.isValid(50000);
             System.out.println(valid ? "TEST OK" : "TEST FAIL");
             sentencia = conexion.createStatement();
 
           
 
             resultado = sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
             while (resultado.next()){
                 System.out.println ("Departamento: " + resultado.getString("DNOMBRE"));
             }
 
             sentencia.close();
             resultado.close();
             conexion.close();
 
 
         }catch(SQLException sqle){
             System.out.println("Error: " + sqle);
          
         }catch (Exception e) {
             System.out.print ("No se pudo realizar conexión");
             return;
         }
    }
}
