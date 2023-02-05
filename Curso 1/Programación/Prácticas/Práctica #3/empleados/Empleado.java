package empleados;

/**
 * <h2></h2>
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Empleado extends Persona {
    private String m_Cargo;
    private Departamento m_Departamento;
    private double m_Sueldo;

    public Empleado(Persona persona, String cargo, Departamento dpt, double sueldo) {
        super(persona);

        m_Cargo = cargo;
        m_Departamento = dpt;
        m_Sueldo = sueldo;
    }

    public boolean equals(Empleado other) {
        // se asume que ambos empleados son iguales
        // si son la misma persona
        return super.equals(other);
    }

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

    public String getCargo() {
        return m_Cargo;
    }

    public Departamento getDepartamento() {
        return m_Departamento;
    }

    public double getSueldo() {
        return m_Sueldo;
    }

    public void setCargo(String cargo) {
        m_Cargo = cargo;
    }

    public void setDepartamento(Departamento dpt) {
        m_Departamento = dpt;
    }

    public void setSueldo(double sueldo) {
        m_Sueldo = sueldo;
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
