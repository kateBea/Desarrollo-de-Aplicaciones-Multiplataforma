package poo.agencia;

import java.util.ArrayList;

import poo.agencia.Vehiculo.VehiculoType;
import poo.utils.MutableInteger;
import poo.utils.Pair;

/**
 * Representa una empresa
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Empresa {
    // CIF de esta Empresa
    private String m_Cif;
    // Nombre de esta Empresa
    private String m_Nombre;
    // Contiene el conjunto de Vehiculos alquilados de una empresa, cada elemento de la lista
    // representa (días de alquiler, (tipo de Vehículo, Vehículo))
    ArrayList<Pair<MutableInteger, Pair<VehiculoType, Vehiculo>>> m_Alquileres;

    /**
     * Incicializa esta Empresa con los valores que se pasan como 
     * parámetro, si las referencias son nulas, se consideran desconocios
     * @param cif CIF para esta Empresa
     * @param nombre Nombre para esta Empresa
     */
    public Empresa(String cif, String nombre) {
        m_Cif = cif == null ? "Unknown" : cif;
        m_Nombre = nombre == null ? "Unknown" : nombre;
        m_Alquileres = new ArrayList<>();
    }

    /**
     * Retorna el CIF de esta Empresa
     * @return CIF de esta Empresa
     */
    public String getCif() {
        return m_Cif;
    }

    /**
     * Cambia el CIF de esta Empresa por el que se pasa como
     * parámetro, si la referencia es nula, esta función no tiene efecto
     * @param cif Nuevo CIF para esta Empresa
     */
    public void setCif(String cif) {
        if (cif != null)
            m_Cif = cif;
        else 
            System.out.println("Referencia de CIF nula setCif()...");
    }

    /**
     * Retorna el nombre de esta Empresa
     * @return nombre de esta Empresa
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Cambia el nombre de esta Empresa por el que se pasa como
     * parámetro, si la referencia es nula, esta función no tiene efecto
     * @param nombre Nuevo nombre para esta Empresa
     */
    public void setNombre(String nombre) {
        if (nombre != null)
            m_Nombre = nombre;
        else 
            System.out.println("Referencia de nombre nula setNombre()...");
    }

    /**
     * Retorna cierto si esta Empresa y la del parámetro son la misma.
     * Se consideran iguales si tienen el mismo CIF y nombre
     * @param other Otra empre con la cual se compara esta
     * @return Cierto si son iguales, falso en caso contrario
     */
    public boolean equals(Empresa other) {
        return getCif().equalsIgnoreCase(other.getCif()) &&
                getNombre().equalsIgnoreCase(other.getNombre());
    }

    /**
    * Añade el Vehículo pasado como parámetro a la lista
    * de vehículos alquilados por esta Empresa. Si el número de 
    * días es negativo o la referencia es nula esta función no tiene efecto
    * @param dias Número de días del alquiler
    * @param vehiculo Vehículo a añadir a la lista de alquileres
    */
    public void addAlquiler(int dias, Vehiculo vehiculo, VehiculoType tipo) {
        addAlquiler(new Pair<>(dias, new Pair<>(tipo, vehiculo)));
    }

    /**
     * Añade el Vehículo pasado como parámetro a la lista
     * de vehículos alquilados por esta Empresa. Si el número de 
     * días es negativo o la referencia es nula esta función no tiene efecto
     * @param item Contiene el Vehículo a ser alquilado por esta empresa por los días indicados
     */
    public void addAlquiler(Pair<Integer, Pair<VehiculoType, Vehiculo>> item) {
        m_Alquileres.add(new Pair<>(new MutableInteger(item.getFirst()), item.getSecond()));
    }

    /**
     * Disminuye los días que le quedan de alquiler a los coches 
     * que tiene alquilados esta Empresa. Se duevlve una lista conteniendo
     * todos los vehículos para los cuales esta Empresa ha agotado el alquiler 
     * @param dias Número de días de alquiler que restar
     * @return Lista de vehículos que ya no están en alquiler
     */
    public ArrayList<Pair<VehiculoType, Vehiculo>> disminuirDiasAlquilerTodos() {
        // Lista que contendrá todos los Vehículo para los cuales este 
        // Empresa ha agota el tiempo de alquiler
        ArrayList<Pair<VehiculoType, Vehiculo>> resultado = new ArrayList<>();

        for (int i = 0; i < m_Alquileres.size(); ++i) {
            MutableInteger diasRestantes = m_Alquileres.get(i).getFirst();
            m_Alquileres.get(i).getFirst().setValue(diasRestantes.getValue() - 1);


            if (m_Alquileres.get(i).getFirst().getValue() == 0) {
                resultado.add(m_Alquileres.get(i).getSecond());
                // quitamos el alquiler de la lista 
                // de alquileres de esta Empresa
                m_Alquileres.remove(i);
            }
        }


        return resultado.isEmpty() ? null : resultado;
    }

    /**
     * Muestra los alquileres de esta Empresa
     */
    public void mostrarAlquileres() {
        System.out.println(getNombre());
        for (Pair<MutableInteger, Pair<VehiculoType, Vehiculo>> item : m_Alquileres) {
            System.out.printf(
                "%s %s %s quedan %d días de alquiler\n",
                item.getSecond().getSecond().getMarca(), 
                item.getSecond().getSecond().getModelo(), 
                item.getSecond().getSecond().getMatricula(),
                item.getFirst().getValue());
        }
    }

    /**
     * Retorna cierto si esta Empresa tiene alquileres,
     * falso en caso contrario
     * @return cierto si esta Empresa tiene alquileres
     */
    public boolean tieneAlquileres() {
        return !m_Alquileres.isEmpty();
    }
}
