package nominas;

import java.util.ArrayList;

/**
 * <h2>Representa un departamento</h2> 
 * 
 * Esta clase representa un departamento. Los departamentos
 * son elementos que forman parte de una empresa. Para cada 
 * departamento se conoce la empresa a la que pertenece y el 
 * conjunto de empleados que lo forman
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Departamento {
    // Conjunto de empleados de este departamento
    private ArrayList<Empleado> m_Empleados;
    // Empresa a la que pertenece este departamento
    private Empresa m_Empresa;
    // Identificador de este departamento
    private String m_Id;
    // Localización (ciudad) de este departamento
    private String m_Localizacion;
    // Nombre de este departamento
    private String m_Nombre;

    /*
     * Función auxiliar que realiza una búsqueda lineal sobre la lista de empleados 
     * y retorna cierto si el empleado target existe en el departamento, retorna falso
     * en caso contrario
     */
    private boolean existeEmpleado(Empleado target) {
        // asumimos que no existe el empleado
        // porque vamos a realizar una busqueda
        boolean encontrado = false;
        int indice = 0;

        while (indice < m_Empleados.size() && !(encontrado))
            encontrado = m_Empleados.get(indice++).equals(target);

        return encontrado;
    }

    /**
     * Inicializa los datos de este departamento a partir de los
     * que se pasan como parámetros
     * 
     * @param id Identificador que se asigna a este departamento
     * @param localizacion Localización que se asigna a este departamento
     * @param nombre Nombre que se asigna a este departamento
     * @param empresa Empresa que se asigna a este departamento
     */
    public Departamento(String id, String localizacion, String nombre, Empresa empresa) {
        m_Empleados = new ArrayList<>();
        m_Empresa = empresa;
        m_Id = id;
        m_Localizacion = localizacion;
        m_Nombre = nombre;
    }

    /**
     * Añade el emplea que se pasa como parámetro a la lista
     * de empleados de este departamento. Si el empleado ya existía
     * esta función to tiene efecto
     * 
     * @param item Empleado que se añade a este departamento
     */
    public void altaEmpleado(Empleado item) {
        // si el empleado no existe, se añade
        if (!existeEmpleado(item))
            m_Empleados.add(item);
        else
            System.out.println("Error: el empleado ya existe...");

    }

    /**
     * Elimina el empleado que se pasa como parámetro de la
     * lista de empleados de este departamento. Si el empleado
     * no existe esta función no tiene efecto
     * 
     * @param item Empleado a eliminar de este departamento
     */
    public void bajaEmpleado(Empleado item) {
        // si el empleado existe, se borra
        if (existeEmpleado(item))
            m_Empleados.remove(item);
        else
            System.out.println("Error: el empleado no existe...");
    }

    /**
     * Devuelve la lista de empleados de este departamento
     * 
     * @return Lista de empleados de este departamento
     */
    public ArrayList<Empleado> getEmpleados() {
        return m_Empleados;
    }

    /**
     * Devuelve la empresa de este departamento
     * 
     * @return Empresa de este departamento
     */
    public Empresa getEmpresa() {
        return m_Empresa;
    }

    /**
     * Devuelve el identificador de este departamento
     * 
     * @return Identificador de este departamento
     */
    public String getId() {
        return m_Id;
    }

    /**
     * Devuelve la localización de este departamento
     * 
     * @return Localización de este departamento
     */
    public String getLocalizacion() {
        return m_Localizacion;
    }

    /**
     * Devuelve el nombre de este departamento
     * 
     * @return Nombre de este departamento
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Cambia la empresa de este departamento a la que se pasa
     * como parámetro, si el parámetro es nulo, esta función
     * no tiene efecto
     * 
     * @param other Nueva empresa de este departamento
     */
    public void setEmpresa(Empresa other) {
        if (other != null)
            m_Empresa = other;
    }

    /**
     * Cambia el identificador de este departamento. Si el identificador
     * es nulo, esta función no tiene efecto
     * 
     * @param id Nuevo identificador de este departamento
     */
    public void setId(String id) {
        if (id != null)
            m_Id = id;
    }

    /**
     * Cambia la localización de este departamento al que se pasa
     * como parámetro. Si el parámetro es nulo, esta función
     * no tiene efecto
     * 
     * @param loc Nueva localización de este departamento
     */
    public void setLocalizacion(String loc) {
        if (loc != null)
            m_Localizacion = loc;
    }

    /**
     * Cambia el nombre de este departamento al que se pasa como parámetro.
     * Si el parámetro es nulo, esta función no tiene efecto
     * 
     * @param nombre Nuevo nombre de esta empresa
     */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
    }

    /**
     * Retorna una cadena de caracteres formateada describiendo
     * este departamento
     * 
     * @return Un String formateado representando este departamento
     */
    @Override
    public String toString() {
        return String.format("-- Datos Departamento ----\n" +
                            "ID departamento: %s\n" +
                            "Nombre departamento: %s\n" +
                            "Localización: %s\n" +
                            "Empresa: %s\n" +
                            "Total de empleados: %d\n" +
                            "---------------------------",
        m_Id, m_Nombre, m_Localizacion, m_Empresa.getNombre(), m_Empleados.size());
    }
}
