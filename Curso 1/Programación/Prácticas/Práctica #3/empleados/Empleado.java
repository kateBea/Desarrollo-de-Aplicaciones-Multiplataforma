package empleados;

/**
 * <h2>Representa un empleado</h2>
 * 
 * Esta clase representa un empleado que es también una persona.
 * Del empleado podemos saber propiedades como el departamento al cual
 * pertenece, su cargo en la empresa en que está y el sueldo que tiene.
 * Cabe destacar que este sueldo hace referencia a su salario bruto,
 * es decir, sin aplicación de retenciones. Para conocer el salario 
 * neto de este empleado deberíamos construir su nómina.
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Empleado extends Persona {
    // Cargo de este empleado
    private String m_Cargo;
    // Departamento de este empleado
    private Departamento m_Departamento;
    // Salario bruto de este empleado
    private double m_Sueldo;
    
    /**
     * Retorna cierto si este empleado es el mismo que
     * el que se pasa por parámetro, falso en caso contrario
     * 
     * @param other Empleado al cual se compara este empleado
     * @return  Cierto si este empleado y other son el mismo, falso en caso contrario
     */
    public boolean equals(Empleado other) {
        // se asume que ambos empleados son iguales
        // si son la misma persona
        return super.equals(other);
    }

    /**
     * Inicializa los datos de esta persona con los que se pasan
     * por parámetro
     * 
     * @param persona Persona que se asigna a este empleado
     * @param cargo Cargo que se asigna a este empleado
     * @param dpt Departamento que se asigna a este empleado
     * @param sueldo Sueldo que se asigna a este empleado
     */
    public Empleado(Persona persona, String cargo, Departamento dpt, double sueldo) {
        super(persona);

        m_Cargo = cargo;
        m_Departamento = dpt;
        m_Sueldo = sueldo < 0.0 ? .0 : sueldo;
    }

    /**
     * Inicializa los datos de esta persona con los que se pasan
     * por parámetro
     * 
     * @param dni Dni que se asigna a este empleado
     * @param nombre Nombre que se asigna a este empleado
     * @param edad Edad que se asigna a este empleado
     * @param estado Estado civil que se asigna a este empleado
     * @param sueldo Sueldo que se asigna a este empleado
     * @param cargo Cargo que asigna a este empleado
     * @param dpt Departamento que se asigna a este empleado
     */
    public Empleado(String dni, 
                    String nombre, 
                    int edad, 
                    String estado, 
                    double sueldo, 
                    String cargo, 
                    Departamento dpt) {
        super(dni, nombre, estado, edad);

        m_Cargo = cargo;
        m_Departamento = dpt;
        m_Sueldo = sueldo;
    }

    /**
     * Devuelve el cargo que tiene asignado este empleado
     * 
     * @return Cargo de este empleado
     */
    public String getCargo() {
        return m_Cargo;
    }

    /**
     * Devuelve el departamento al que pertenece este empleado
     * 
     * @return Departamento de este empleado
     */
    public Departamento getDepartamento() {
        return m_Departamento;
    }

    /**
     * Devuelve el salario bruto de este empleado, es decir,
     * el salario sin aplicación de retenciones
     * 
     * @return
     */
    public double getSueldo() {
        return m_Sueldo;
    }

    /**
     * Cambia el cargo de este empleado al que se pasa como
     * parámetro
     * 
     * @param cargo Nuevo cargo de este empleado
     */
    public void setCargo(String cargo) {
        m_Cargo = cargo;
    }

    /**
     * Cambia el departamento de este empleado por el que se pasa
     * por parámetro
     * 
     * @param dpt Nuevo departamento de este empleado
     */
    public void setDepartamento(Departamento dpt) {
        m_Departamento = dpt;
    }

    /**
     * Cambia el salario bruto de este empleado por el que
     * se pasa por parámetro. Si el parámetro es negativo
     * no se realiza ningún cambio y se imprime un mensaje
     * apropiado
     * 
     * @param sueldo Nuevo salario de este empleado
     */
    public void setSueldo(double sueldo) {
        if (!(sueldo < .0)) {
            m_Sueldo = sueldo;
        }
        else 
            System.out.println("Valor de sueldo no válido");
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nCargo: %s\n" +
                                                "%s\n" +
                                                "Sueldo: %.4f\n" +
                                                "---------------------------",
        m_Cargo, m_Departamento.toString(), m_Sueldo);
    }

}
