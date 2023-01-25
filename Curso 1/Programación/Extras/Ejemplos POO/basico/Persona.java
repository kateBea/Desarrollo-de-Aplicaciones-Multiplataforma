/*
 *  UT 5: Clases y objetos
 *  Modelar una clase Persona con los siguientes atributos
 *  - nombre, apellido1, apellido2, dni, profesión, edad
 *  - añadir el contructor y los métodos que permitan asignar 
 *    y devolver los valores a los atributos
 */
package basico;
public class Persona{
    // Atributos de la clase
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String profesion;
    private int edad;
    


    // Métodos

    /* Método constructor: se ejecuta al crear la instancia
     * Podemos crear varios métodos constructores
     */

    public Persona (String nombre,
                    String apellido1,
                    String apellido2,
                    String dni,
                    String profesion,
                    int edad) {

        this.nombre = nombre;
        //operador this para hacer referencia al atributo y 
        //distinguirlo del nombre parámetro
        this.apellido1= apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.profesion=profesion;
        this.edad=edad;
    }

    public Persona (String nombre, String apellido1, 
                    String apellido2, String dni){

        this.apellido1= apellido1;
        this.apellido2=apellido2;
        this.nombre = nombre;
        this.dni=dni;
    
    }

    //métodos get/set por cada atributo
    public String getNombre(){
        return nombre;
    }
    public void setNombre (String nuevo_nombre){
        nombre = nuevo_nombre;
    }

    public String getApellido1(){
        return apellido1;
    }
    public void setApellido1 (String nuevo_ap1){
        apellido1 = nuevo_ap1;
    }
    
    public String getApellido2(){
        return apellido2;
    }
    public void setApellido2 (String nuevo_ap2){
        apellido2 = nuevo_ap2;
    }

    public String getProfesion(){
        return profesion;
    }
    public void setProfesion (String nueva_profesion){
        profesion=nueva_profesion;
    }
    public String getDNI(){
        return dni;
    }
    public void setDNI (String nuevo_dni){
        dni = nuevo_dni;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad (int nueva_edad){
        edad = nueva_edad;
    }





}