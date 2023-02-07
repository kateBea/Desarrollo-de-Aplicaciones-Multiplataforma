package parking;

import java.util.ArrayList;

/**
 * <h2>Representa un Aparcamiento o Parking</h2>
 * 
 * Un Aparcamiento o Parking es una clase que representa un contenedor 
 * de Vehículos. Estos se almacenan a un coste o importe cálculo del
 * cual son responsables los distintos vehículos almacenados. El aprcamiento
 * <b>tiene una capacidad limitada que se ajusta según se aparcan o retiran vehículos</b>.
 * Si por motivos de obras se amplia el parking se puede aumentar la capacidad del 
 * mismo, en dicho caso se retirarán todos los coches que haya en él y la capacidad será
 * restaurada a la nueva capacidad máxmima. Es importante destacar también que la 
 * matrícula es única entre todos los vehículos.
 * 
 * @author Hugo Pelayo 
 * @version 1.0
 */

public final class Aparcamiento {
    // Contiene todos los vehículos almacenados
    ArrayList<Vehiculo> m_Vechiculos;
    // Capacidad del aparcamiento
    int m_Capacidad;

    /**
     * Inicializa un aparcamiento con una capacidad máxima igual
     * a la que se pasa como parámetro. No hay ningún
     * vehículo aparcado
     * 
     * @param limite Capacidad inicial del aparcamiento
     */
    public Aparcamiento(int limite) {
        m_Vechiculos = new ArrayList<>();
        m_Capacidad = limite;
    }

    /**
     * Añade un nuevo vehículo al aparcamiento comprobando que no está. Si no hay capacidad
     * suficiente no se añade el vehículo y se informa de ello con un mensaje apropidado
     * @param v El vehículo a ser añadido
     */
    public void introducirVehiculo(Vehiculo v) {
        // se asume que el vehículo no existe porque se va buscar
        boolean encontrado = false;
        int indice = 0;

        if (m_Capacidad != 0) {
            while (indice < m_Vechiculos.size() && !encontrado)
                encontrado = m_Vechiculos.get(indice++).equals(v);
    
            if (!encontrado) {
                m_Vechiculos.add(v);
    
                // capacidad se reduce porque nos quedamos
                // con menos plazas
                --m_Capacidad;
            }
            else 
                System.out.printf("El vehículo con matrícula [ %s ] a ser añadido ya existe\n",
                    v.getMatricula());
        }
        else 
            System.out.println("Error: No se pudo completar la operación, plazas insuficientes...");
    }

    /**
     * Saca el vehículo que se pasa como parámetro del aparcamiento si existe y
     * devuelve el importe a cobrar por sacar el vehículo, en caso de no existir 
     * el vehículo esta función no tiene efecto y retorna -1
     * 
     * @param v Vehículo a ser retirado del aprcamiento
     * @return Devuelve el importe a cobrar por sacar el vehículo
     */
    public double sacarVehiculo(Vehiculo v) {
        // se asume que el vehículo no existe porque se va buscar
        boolean encontrado = false;
        double importe = -1.0;
        int indice = 0;

        while (indice < m_Vechiculos.size() && !encontrado)
            encontrado = m_Vechiculos.get(indice++).equals(v);

        if (encontrado) {
            importe = m_Vechiculos.get(indice - 1).calcularImporte(null);

            // borramos índice - 1 porque al salir del bucle
            // se habrá incrementado el índice en uno
            m_Vechiculos.remove(indice - 1);
            ++m_Capacidad;
        }
        else 
            System.out.printf("El vehículo con matrícula [ %s ] a ser sacado no existe\n",
                v.getMatricula());

        return importe;
    }

    /**
     * Saca el vehículo que se pasa como parámetro del aparcamiento si existe y
     * devuelve el importe a cobrar por sacar el vehículo, en caso de no existir 
     * el vehículo esta función no tiene efecto y retorna -1
     * 
     * @param matricula Matrícula del vehículo a ser retirado del aprcamiento
     * @return Devuelve el importe a cobrar por sacar el vehículo
     */
    public double sacarVehiculo(String matricula) {
        // se asume que el vehículo no existe porque se va buscar
        boolean encontrado = false;
        double importe = -1.0;
        int indice = 0;

        while (indice < m_Vechiculos.size() && !encontrado)
            encontrado = m_Vechiculos.get(indice++).equals(matricula);

        if (encontrado) {
            importe = m_Vechiculos.get(indice - 1).calcularImporte(null);

            // borramos índice - 1 porque al salir del bucle
            // se habrá incrementado el índice en uno
            m_Vechiculos.remove(indice - 1);
            ++m_Capacidad;
        }
        else 
            System.out.printf("El vehículo con matrícula [ %s ] a ser sacado no existe\n",
                matricula);

        return importe;
    }

    /**
     * Devuelve la capacidad o plazas restantes de este aparcamiento
     * 
     * @return La capacidad o plazas restantes de este aparcamiento
     */
    public int getCapacidad() {
        return m_Capacidad;
    }

    /**
     * Devuelve la máxima capacidad o plazas de este aparcamiento
     * 
     * @return La máxima capacidad o plazas restantes de este aparcamiento
     */
    public int getMaxCapacidad() {
        return m_Capacidad + m_Vechiculos.size();
    }

    /**
     * Cambia la capacidad de este aparcamiento al que se pasa como parámetro.
     * Si el parámetro es negativo esta función no tiene efecto y se imprime
     * un mensaje apropiado informando de ello
     * 
     * @param capacidad Nueva capacidad del aparcamiento
     */
    public void setCapacidad(int capacidad) {
        if (capacidad < 0) 
            System.out.println("Valor de capacidad no válido.");
        else {
            m_Capacidad = capacidad;
            m_Vechiculos.clear();
        }
    }

    /**
     * Retorna la lista de vehículos en este aprcamiento
     * 
     * @return Lista de vehículos aparcados actualmente
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return m_Vechiculos;
    }

    /**
     * Devuelve el número total de plazas ocupadas actualmente en el
     * aparcamiento
     * 
     * @return Total de plazas ocupadas
     */
    public int getPlazasOcupadas() {
        return m_Vechiculos.size();
    }

    /**
     * Retorna un Strign formateado representando este aparcamiento
     * 
     * @return Un String representando este aparcamiento
     */
    @Override
    public String toString() {
        return String.format("Total de vhículos aparcados: %d\n" +
                            "Vantes: %d restante (s)\n" +
                            "------------------------------------",
        m_Vechiculos.size(), m_Capacidad);
    }
}
