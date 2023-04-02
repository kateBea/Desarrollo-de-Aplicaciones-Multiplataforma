package poo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;

import poo.agencia.Empresa;
import poo.agencia.Vehiculo;
import poo.agencia.Furgoneta;
import poo.agencia.Coche;
import poo.agencia.Moto;

public class PracticaAlquilerVehiculos {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    private static ArrayList<Coche> coches;
    private static ArrayList<Empresa> empresas;
    private static ArrayList<Moto> motos;
    private static ArrayList<Furgoneta> furgonetas;

    private static TreeMap<String, ArrayList<Vehiculo>> enAlquiler; // guarda lo que tiene alquyilado cada empresa
    private static ArrayList<Integer> diasDeAlquiler;
    private static ArrayList<Integer> tipoAlquilado; //1: coche, 2: furgoneta, 3:moto


    public static void main(String[] args) {
        int seleccion;
        int vehiculoAlquilado;
        int cantidadDeDias;

        int contadorDias = 1;

        // inicializar flota de vehículos
        // Se asume que sólo hay una agencia que alquila vehículos
        inicializarCoches();
        inicializarEmpresas();
        inicializarMotos();
        inicializarFurgonetas();

        enAlquiler = new TreeMap<>();
        diasDeAlquiler = new ArrayList<>();
        tipoAlquilado = new ArrayList<>();

        System.out.println("DIA " + (contadorDias++));
        do {
            seleccion = pedirEmpresa();

            if (seleccion == -1) {
                mostrarStock();
                reducirDiasAlquiler();
                System.out.println("\nDIA " + (contadorDias++));
                continue;
            }
            else if (seleccion != 2) {
                System.out.println(empresas.get(seleccion - 1).getNombre());
    
                System.out.println();
                vehiculoAlquilado = pedirVehiculo();
    
                System.out.println();
                cantidadDeDias = pedirDias();
                addAlquiler(vehiculoAlquilado, cantidadDeDias, empresas.get(seleccion - 1));
            }

        }
        while (seleccion != -2);
    }

    public static void addAlquiler(int vehiculo, int dias, Empresa emp) {
        if (!enAlquiler.containsKey(emp.getNombre()))
            enAlquiler.put(emp.getNombre(), new ArrayList<>());

        Vehiculo temp = getVehiculoParaAlquilar(vehiculo);

        if (temp != null) {
            enAlquiler.get(emp.getNombre()).add(temp);
            diasDeAlquiler.add(dias);
        }
    }

    public static void reducirDiasAlquiler() {
        int diasActuales;
        ArrayList<Integer> actualizado = new ArrayList<>(diasDeAlquiler.size());

        for (int index = 0; index < diasDeAlquiler.size(); ++index) {
            diasActuales = diasDeAlquiler.get(index) - 1;

            if (diasActuales == 0)
                devolverAlquilado(index);
            else
                actualizado.add(diasActuales - 1);
        }

        diasDeAlquiler = actualizado;
    }

    public static void devolverAlquilado(int indice) {
        int indiceTarget = 0;
        int indiceIn = 0;
        Set<Map.Entry<String,ArrayList<Vehiculo>>> entradas = enAlquiler.entrySet();
        Iterator<Map.Entry<String,ArrayList<Vehiculo>>> it = entradas.iterator();

        while (it.hasNext()) {
            // recorrer todas las empresas
            Map.Entry<String,ArrayList<Vehiculo>> entrada = it.next();

            indiceIn = 0;
            while (indiceIn < entrada.getValue().size()) {
                // recorrer los alquileres de cada empresa
                if (indiceTarget == indice) {

                }

                ++indiceTarget;
            }
        }


        switch (tipoAlquilado.get(indice)) {
            case 1 -> {
                // coche
            }
            case 2 -> {
                // furgoneta
            }
            case 3 -> {
                // moto
            }
        }
    }


    public static Vehiculo getVehiculoParaAlquilar(int vehiculo) {
        Vehiculo resultado = null;

        switch(vehiculo) {
            case 1 -> {
                // coche
                if (!coches.isEmpty()) {
                    resultado = coches.get(0);
                    tipoAlquilado.add(1);
                    coches.remove(0);
                }
                else 
                    System.out.println("No quedan soches disponibles\n");
            }
            case 2 -> {
                // furgoneta
                if (!furgonetas.isEmpty()) {
                    resultado = furgonetas.get(0);
                    tipoAlquilado.add(2);
                    furgonetas.remove(0);
                }
                else 
                    System.out.println("No quedan furgonetas disponibles\n");
            }
            default -> {
                // moto
                if (!motos.isEmpty()) {
                    resultado = motos.get(0);
                    tipoAlquilado.add(3);
                    motos.remove(0);
                }
                else 
                    System.out.println("No quedan motos disponibles\n");
            }
        }

        return resultado;
    }

    public static void mostrarStock() {
        System.out.println("\nCoches sin alquilar");
        System.out.println("===================");
        for (Coche coche : coches) 
            System.out.printf("%s %s %s\n", coche.getMarca(), coche.getModelo(), coche.getMatricula());

        System.out.println("\nFurgonetas sin alquilar");
        System.out.println("=======================");
        for (Furgoneta furgo : furgonetas) 
            System.out.printf("%s %s %s\n", furgo.getMarca(), furgo.getModelo(), furgo.getMatricula());

        System.out.println("\nMotos sin alquilar");
        System.out.println("==================");
        for (Moto moto : motos) 
            System.out.printf("%s %s %s\n", moto.getMarca(), moto.getModelo(), moto.getMatricula());

        System.out.println("\n\n");
        int indiceDiasAlquiler = 0;
        for (Map.Entry<String,ArrayList<Vehiculo>> entrada : enAlquiler.entrySet()) {
            System.out.println(entrada.getKey());
            // TODO: mostrar el coche alquilado y por cuantos días
            // pasados esos días el coche se tiene que devolver al listado de coches que se pueden alquilar

            for (Vehiculo vh : entrada.getValue()) {
                System.out.printf(
                    "%s %s %s quedan %d días de alquiler\n", 
                    vh.getMarca(), 
                    vh.getModelo(), 
                    vh.getMatricula(),

                    // se resta el tamaño porque los alquileres se
                    // inserten en diasDeAlquiler desde el final
                    diasDeAlquiler.get(indiceDiasAlquiler++)
                );

            }

            System.out.println();
        }
    }

    public static int pedirEmpresa() {
        int resultado = -2;

        do {
            System.out.printf("¿Qué empresa desea alquilar un vehículo? [1, %d]: ", empresas.size());
            try {
                resultado = Integer.parseInt(reader.readLine());
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error al leer el índice de empresa");
            }
        }
        while (!(resultado > -3 && resultado < empresas.size()));

        return resultado;
    }

    public static int pedirVehiculo() {
        int resultado = -2;

        do {
            System.out.printf("¿Qué vehículo se desea alquilar? [1.- Coche 2.-Furgoneta 3.- Moto]: ");
            try {
                resultado = Integer.parseInt(reader.readLine());
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error al leer el índice de vehículo");
            }
        }
        while (!(resultado > 0 && resultado < 4));

        return resultado;
    }

    public static int pedirDias() {
        int resultado = -2;

        do {
            System.out.printf("¿Durante cuántos días?: ");
            try {
                resultado = Integer.parseInt(reader.readLine());
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error al leer la cantidad de días");
            }
        }
        while (resultado < 0);

        return resultado;
    }


    public static void inicializarCoches() {
        coches = new ArrayList<>();

        coches.add(new Coche("5557LH", "Ford", "Transit", 33.2, 4));
        coches.add(new Coche("2356LBM", "Seat", "Leon", 22.4, 4));
        coches.add(new Coche("9845LKS", "Renault", "Clio", 33.2, 4));
        coches.add(new Coche("4365LLF", "Citroen", "C3", 33.2, 4));
        coches.add(new Coche("7423KZF", "Peugeot", "208", 33.2, 4));
        coches.add(new Coche("7190LLB", "Volkswagen", "Golf", 37.2, 4));
        coches.add(new Coche("1122KTL", "Mercedes", "CLAs", 33.2, 4));
        coches.add(new Coche("4447LLM", "Seat", "Ateca", 28.3, 4));
    }

    public static void inicializarEmpresas() {
        empresas = new ArrayList<>();

        empresas.add(new Empresa("B-76345879", "IKEA"));
        empresas.add(new Empresa("C-00373762", "Media Markt"));
        empresas.add(new Empresa("R-92872101", "Carrefour"));
        empresas.add(new Empresa("F-20834281", "Alcampo"));
        empresas.add(new Empresa("T-00283621", "KIABI"));
    }

    public static void inicializarMotos() {
        motos = new ArrayList<>();

        motos.add(new Moto("9987LDD", "Kawaski", "J300", 19.44, true));
        motos.add(new Moto("5554LDD", "Yamaha", "NMAX", 22.44, true));
    }

    public static void inicializarFurgonetas() {
        furgonetas = new ArrayList<>();

        furgonetas.add(new Furgoneta("1198KZZ", "Peugeot", "Boxer", 38.91, 102.4));
        furgonetas.add(new Furgoneta("4321LCC", "Renault", "Kangoo ZE", 48.2, 156.4));
    }

}