package nominas;

import empleados.Empleado;
import java.time.LocalDate;
import empleados.Departamento;
import empleados.Empresa;
import empleados.Persona;

public class Nomina {
    private Empresa m_Empresa;
    private Departamento m_Departamento;
    private Empleado m_Empleado;
    private LocalDate m_Fecha;
    private double m_Salario;
    private double m_Retencion;
    private double m_SalarioNeto;

    private double calcularNeto() {
        return m_Salario - m_Salario * (m_Retencion / 100.0);
    }

    public Nomina(Empresa empresa, Departamento departamento, Empleado empleado, double retencion) {
        m_Empresa = empresa;
        m_Departamento = departamento;
        m_Empleado = empleado;
        m_Fecha = new LocalDate();

        if (m_Retencion >= 0.0 && m_Retencion <= 100.0)
            m_Retencion = .0;

        m_SalarioNeto = calcularNeto();
    }

    public Nomina(Empleado empleado, double retencion) {
        m_Empresa = empleado.getDepartamento().getEmpresa();
        m_Departamento = empleado.getDepartamento();
        m_Empleado = empleado;
        m_Fecha = new LocalDate();
        if (m_Retencion >= 0.0 && m_Retencion <= 100.0)
            m_Retencion = .0;

        m_SalarioNeto = calcularNeto();
    }

    public double getSueldo() {
        // salario bruto
        return m_Sueldo;
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
        m_Salario = bruto;
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
        m_Fecha.toString(), m_Salario, m_SalarioNeto, m_Retencion);
    }
}