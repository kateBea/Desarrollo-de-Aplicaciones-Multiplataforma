/*
 * Ejemplo de herencia
 */
package nominas;

 public abstract class Empleado{
    private String nombre;
    private String apellidos;
    private String identificador;
    private Character sexo;
    private String tfno;
    private String email;

    /**
     * Método constructor de la clase Empleado
     * crea objetos empleados con valores iniciales
     * para todos sus parámetros
     * @param nombre Nombre del empleado
     * @param apellido Apellido del empleado
     * @param identificador Identificador del empleado
     * @param sexo 'H' hombre. 'M' mujer. '?' Desconocido
     * @param tfno Teléfono del empleado
     * @param email Email del empleado
     */
    public Empleado (String nombre,
                    String apellido,
                    String identificador,   
                    Character sexo,
                    String tfno,
                    String email){
        this.nombre=nombre;
        this.apellidos=apellido;
        this.identificador=identificador;
        this.sexo=sexo;
        this.tfno=tfno;
        this.email=email;
    }

    /**
     * Método constructor de la clase Empleado que crea objetos 
     * empleados con valores para sus atributos nombre, apellidos e identificador
     * @param nombre Nombre del empleado
     * @param apellidos Apellidos del empleado
     * @param identificador Identificador del empleado
     */
    public Empleado (String nombre, String apellidos, String identificador){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.identificador=identificador;
    }
    /**
     * Método que devuelve el nombre del empleado
     * @return nombre del empleado
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Método que modifica el nombre de un empleado por uno nuevo que le envíamo
     * como parámetro
     * @param nuevo_nombre Nuevo nombre del empleado
     */
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }

    /**
     * Método que devuelve el apellido del empleado
     * @return apellidos del empleado
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método que devuelve el identificador de un empleado
     * @return identificador del empleado
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Método que devuelve el género del empleado
     * @return género del empleado 'H' hombre 'M' mujer '?' desconocido
     */
    public Character getSexo() {
        return sexo;
    }

    /**
     * Método que devuelve el teléfono de un empleado
     * @return teléfono del empleado
     */
    public String getTfno() {
        return tfno;
    }

    /**
     * Método que devuelve el email de un empleado
     * @return email del empleado
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que modifica los apellidos de un empleado por 
     * el valor que recibe como parámetro
     * @param apellidos con el nuevo apellido
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método que modifica el identificador de un empleado
     * con el nuevo valor que recibe como parámetro
     * @param identificador nuevo identificador del empleado
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Método que modifica el valor del género del empleado
     * con el nuevo valor que recibe como parámetro
     * @param sexo nuevo valor 'H' hombre 'M' mujer '?' desconocido
     */
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
    /**
     * Método que modifica el valor del tfno de un empleado
     * con el nuevo valor que recibe como parámetro
     * @param tfno nuevo tfno del empleado
     */
    public void setTfno(String tfno) {
        this.tfno = tfno;
    }
    /**
     * Método que modifica el valor del email de un empleado
     * con el nuevo valor que recibe como parámetro
     * @param email nuevo email de empleado
     */

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos + ", identificador=" + identificador
                + ", sexo=" + sexo + ", tfno=" + tfno + ", email=" + email + "]";
    }

    abstract double sueldo(); //método abstracto que se implementa en las clases derivadas

 }