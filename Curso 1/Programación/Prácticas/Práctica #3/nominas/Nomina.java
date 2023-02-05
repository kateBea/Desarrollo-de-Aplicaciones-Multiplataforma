package nominas;

import empleados.Empleado;
import java.time.LocalDate;
import empleados.Departamento;
import empleados.Empresa;

/**
 * <h2>Representa la nómina de un empleado</h2>
 * 
 * Esta clase representa la nómina de un Empleado. Permite gestionar
 * el salario neto y el salario bruto de un empleado. 
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Nomina {
    // Empresa a la que pertence el empleado con esta nómina
    private Empresa m_Empresa;
    // Departamento al que pertenece el empleado con esta nómina
    private Departamento m_Departamento;
    // Empleado al que pertenece esta nómina
    private Empleado m_Empleado;
    // Fecha de emisión de esta nómina
    private LocalDate m_Fecha;
    // Salario bruto del empleado con esta nómina
    private double m_SalarioBruto; 
    // Retención sobre el salario bruto
    private double m_Retencion;
    // Salario neto del empleado con esta nómina
    private double m_SalarioNeto;

    /*
     * Función auxiliar que calcula el salario neto de esta nómina
     * a partir de la retención y el salario bruto
     */
    private double calcularNeto() {
        return m_SalarioBruto - m_SalarioBruto * (m_Retencion / 100.0);
    }

    /**
     * Inicializa los atributos de esta nómina a partir de los que se
     * pasan como parámetros
     * 
     * @param empresa Empresa que se asigna al empleado con esta nómina
     * @param departamento Departamento que se asigna al empleado con esta nómina
     * @param empleado Empleado al que pertenece esta nómina
     * @param retencion Retención a aplicar sobre el salario bruto
     */
    public Nomina(Empresa empresa, Departamento departamento, Empleado empleado, double retencion) {
        m_Empresa = empresa;
        m_Departamento = departamento;
        m_Empleado = empleado;
        m_SalarioBruto = empleado.getSueldo();
        m_Fecha = LocalDate.now();

        if (!(m_Retencion >= 0.0 && m_Retencion <= 100.0))
            m_Retencion = .0;

        m_SalarioNeto = calcularNeto();
    }

    /**
     * 
     * @param empleado
     * @param retencion
     */
    public Nomina(Empleado empleado, double retencion) {
        m_Empresa = empleado.getDepartamento().getEmpresa();
        m_Departamento = empleado.getDepartamento();
        m_Empleado = empleado;
        m_SalarioBruto = empleado.getSueldo();
        m_Fecha = LocalDate.now();

        if (!(m_Retencion >= 0.0 && m_Retencion <= 100.0))
            m_Retencion = .0;

        m_SalarioNeto = calcularNeto();
    }

    public double getSalarioBruto() {
        return m_SalarioBruto;
    }

    public double getRetencion() {
        return m_Retencion;
    }

    public double getSalarioNeto() {
        return m_SalarioNeto;
    }

    public Empresa getEmpresa() {
        return m_Empresa;
    }

    public Departamento getDepartamento() {
        return m_Departamento;
    }

    public Empleado getEmpleado() {
        return m_Empleado;
    }

    public LocalDate getFechaLocal() {
        // no es necesario m_LocalDate porque
        // now es static
        return LocalDate.now();
    }

    public void setEmpresa(Empresa empresa) {
        m_Empresa = empresa;
    }

    public void setDepartamento(Departamento departamento) {
        m_Departamento = departamento;
    }

    public void setEmpleado(Empleado empleado) {
        m_Empleado = empleado;
    }

    public void setSalarioBruto(double bruto) {
        if (!(bruto < 0.0)) {
            m_SalarioBruto = bruto;
            m_SalarioNeto = calcularNeto();
        }
        else 
            System.out.println("Valor de salario bruto inválido");

    }

    public void setRetencion(double retencion) {
        if (m_Retencion >= 0.0 && m_Retencion <= 100.0)
            m_Retencion = .0;
        else 
            System.out.println("Valor de retención no válido...");
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                            "%s\n" +
                            "%s\n" +
                            "%s\n" +
                            "Salario bruto: %.4f\n" +
                            "Salario neto: %.4f\n" +
                            "Retención: %.4f",
        m_Empresa.toString(), m_Departamento.toString(), m_Empleado.toString(),
        m_Fecha.toString(), m_SalarioBruto, m_SalarioNeto, m_Retencion);
    }
}