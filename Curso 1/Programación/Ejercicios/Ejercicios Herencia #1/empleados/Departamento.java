package empleados;

import java.util.ArrayList;

public class Departamento {
    private ArrayList<Empleado> m_Empleados;
    private Empresa m_Empresa;
    private String m_Id;
    private String m_Localizacion;
    private String m_Nombre;

    public Departamento(String id, String localizacion, String nombre, Empresa empresa) {
        m_Empleados = new ArrayList<>();
        m_Empresa = empresa;
        m_Id = id;
        m_Localizacion = localizacion;
        m_Nombre = nombre;
    }

    private boolean existeEmpleado(Empleado target) {
        // asumimos que no existe el empleado
        // porque vamos a realizar una busqueda
        boolean encontrado = false;
        int indice = 0;

        while (indice < m_Empleados.size() && !(encontrado))
            encontrado = m_Empleados.get(indice++).equals(target);

        return encontrado;
    }

    public void altaEmpleado(Empleado item) {
        // si el empleado no existe, se añade
        if (!existeEmpleado(item))
            m_Empleados.add(item);
        else
            System.out.println("Error: el empleado ya existe...");

    }

    public void bajaEmpleado(Empleado item) {
        // si el empleado existe, se borra
        if (existeEmpleado(item))
            m_Empleados.remove(item);
        else
            System.out.println("Error: el empleado no existe...");
    }

    public ArrayList<Empleado> getEmpleados() {
        return m_Empleados;
    }

    public Empresa getEmpresa() {
        return m_Empresa;
    }

    public String getId() {
        return m_Id;
    }

    public String getLocalizacion() {
        return m_Localizacion;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public void setEmpresa(Empresa other) {
        m_Empresa = other;
    }

    public void setId(String id) {
        m_Id = id;
    }

    public void setLocalizacion(String loc) {
        m_Localizacion = loc;
    }

    public void setNombre(String nombre) {
        m_Nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("ID departamento:: %s\n" +
                            "Nombre departamento: %s\n" +
                            "Localización: %s\n" +
                            "Empresa: %s\n" +
                            "Total de empleados: %d" +
                            "---------------------------",
        m_Id, m_Nombre, m_Localizacion, m_Empresa.getNombre(), m_Empleados.size());
    }
}
