import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseLogic {
    //Clase que representa la logica de una base de datos

    Connection conexion;
    Statement sentencia;
    ResultSet resuSet;
    static int index;

    public DataBaseLogic(){

    }
    public void connectDB(String url, String user, String password){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+url, user, password);
        System.out.println("CONEXION EXITOSA");
    }catch(SQLException sqle){
            System.out.println(sqle.toString());
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public String[] showSelect(int indiceEntrada){
        //Metodo que se encarga de sacar los datos de las select necesarias
        String[] result = new String[3];
        try{
        sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Para poder scrollear con los datos
        resuSet = sentencia.executeQuery("SELECT * FROM departamentos");
    
    
            if(resuSet.absolute(indiceEntrada)){//Si ResultSet tiene contenido en la columna N (indiceEntrada) 
                
                result[0] = resuSet.getString("DEP_NO");//Obtiene el contenido de la posicion IndiceEntrada y cuyo nombre de columna sea DEP_NO...
                result[1] = resuSet.getString("DNOMBRE");
                result[2] = resuSet.getString("LOCALIDAD");
                
            }
            else{//Si el index es mayor que el numero de datos, lo forzamos a 1 y volvemos a llamar al metodo
                MostrarDatos.index = 1;
            }
        }catch(SQLException sqlx){
            System.out.println(sqlx.toString());
        }
        if (result[0] == null)
            result =  showSelect(MostrarDatos.index);

        return result;
        
       }


       public boolean uploadData(String dpto, String name, String location){
        //Metodo que se encarga de subir los datos que se encuentre en los textfield a la base de datos
        try{
        sentencia = conexion.createStatement();
        boolean queryEjecutada = sentencia.execute("INSERT INTO DEPARTAMENTOS VALUES (" 
                                        +   dpto +","
                                        + "'" + name +"',"
                                        + "'" + location+"')");
        
        if(!queryEjecutada)//Query ha sido insertar datos
            System.out.println("INSERT CON EXITO");
        
        }catch(SQLException sqlx){
            System.out.println(sqlx.toString());
        }
        return false;
       }
    
}
