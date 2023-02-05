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
     * Inicializa los atributos de esta nómina a partir de los que se
     * pasan como parámetros
     * 
     * @param empleado Empleado al que pertenece esta nómina
     * @param retencion Retención a aplicar sobre el salario bruto
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

    /**
     * Devuelve el salario bruto correspondiente a esta nómina
     * 
     * @return Salario bruto de esta nómina
     */
    public double getSalarioBruto() {
        return m_SalarioBruto;
    }

    /**
     * Devuelve la retención correspondiente a esta nómina
     * 
     * @return Retención de esta nómina
     */
    public double getRetencion() {
        return m_Retencion;
    }

    /**
     * Devuelve el salario neto correspondiente a esta nómina
     * 
     * @return Salario neto de esta nómina
     */
    public double getSalarioNeto() {
        return m_SalarioNeto;
    }

    /**
     * Devuelve la empresa del empleado con esta nómina
     * 
     * @return Empresa de esta nómina
     */
    public Empresa getEmpresa() {
        return m_Empresa;
    }

    /**
     * Devuelve departamento del empleado con esta nómina
     * 
     * @return Departamento de esta nómina
     */
    public Departamento getDepartamento() {
        return m_Departamento;
    }

    /**
     * Devuelve el empleado al que pertenece esta nómina
     * 
     * @return Empleado con esta nómina
     */
    public Empleado getEmpleado() {
        return m_Empleado;
    }

    /**
     * Devuelve la fecha en que se emitió esta nómina
     * 
     * @return Fecha de emisión de esta nómina
     */
    public LocalDate getFechaLocal() {
        // aunque LocalDate.now() sea static
        // podría no devolver la fecha de emisión que tenemos
        // guardada en el atributo privado m_Fecha, por eso
        // retornamos m_Fecha y no LocalDate.now()
        return m_Fecha;
    }


    /**
     * Cambia la empresa de esta nómina a la que se pasa por parámetro
     * 
     * @param empresa Nueva empresa de esta nómina
     */
    public void setEmpresa(Empresa empresa) {
        m_Empresa = empresa;
    }

    /**
     * Cambia el departamento de esta nómina al que se pasa por parámetro
     * 
     * @param departamento Nuevo departamento de esta nómina 
     */
    public void setDepartamento(Departamento departamento) {
        m_Departamento = departamento;
    }

    /**
     * Cambia el empleado al que pertenece esta nómina
     * 
     * @param empleado Nuevo empleado de esta nómina
     */
    public void setEmpleado(Empleado empleado) {
        m_Empleado = empleado;
    }

    /**
     * Cambia el salario bruto de esta nómina
     * 
     * @param bruto Nuevo salario bruto de esta nómina
     */
    public void setSalarioBruto(double bruto) {
        if (!(bruto < 0.0)) {
            m_SalarioBruto = bruto;
            m_SalarioNeto = calcularNeto();
        }
        else 
            System.out.println("Valor de salario bruto inválido");

    }

    /**
     * Cambia la retención a aplicar sobre esta nómina
     * 
     * @param retencion Nuevo retención a aplicar sobre esta nómina
     */
    public void setRetencion(double retencion) {
        if (m_Retencion >= 0.0 && m_Retencion <= 100.0)
            m_Retencion = .0;
        else 
            System.out.println("Valor de retención no válido...");
    }
    
    /**
     * Retorna una cadena de caracteres formateada describiendo
     * esta nómina
     * 
     * @return Un String formateado representando esta nómina
     */
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