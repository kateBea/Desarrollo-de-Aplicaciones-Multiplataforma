package poo;

import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import poo.agencia.Empresa;
import poo.agencia.Vehiculo;
import poo.agencia.Vehiculo.VehiculoType;
import poo.utils.Pair;
import poo.agencia.Furgoneta;
import poo.agencia.Coche;
import poo.agencia.Moto;

public class PracticaAlquilerVehiculos {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    private static ArrayList<Pair<VehiculoType, Vehiculo>> noAlquilados;
    private static ArrayList<Empresa> empresas;


    public static void main(String[] args) {
        int seleccion;
        int contadorDias;
        int cantidadDeDias;
        int vehiculoAlquilado;

        // inicializar flota de vehículos
        // Se asume que sólo hay una agencia que alquila vehículos

        inicializarAlquileres();
        inicializarEmpresas();

        // al principio no tenemos nigún vehículo alquilado
        contadorDias = 1;

        System.out.println("DIA " + (contadorDias));
        do {
            // si el valor es -1 avanzamos día, si es -2 salimos de la aplicación
            // si es mayor de 1 seleccionamos una empresa
            seleccion = pedirEmpresa();
            

            if (seleccion == -1) {
                ++contadorDias;
                mostrarStock();
                reducirDiasAlquiler();
                
                System.out.println("DIA " + (contadorDias));
            }
            else if (seleccion > 0) {
                System.out.println(empresas.get(seleccion - 1).getNombre() + "\n");
                vehiculoAlquilado = pedirVehiculo();
                cantidadDeDias = pedirDias();
                addAlquiler(vehiculoAlquilado, cantidadDeDias, empresas.get(seleccion - 1));

            }

            System.out.println();
        }
        while (seleccion != -2);
    }

    public static void addAlquiler(int tipo, int dias, Empresa emp) {
        switch (tipo) {
            case 1 -> marcarAlquiler(VehiculoType.COCHE, dias, emp);
            case 2 -> marcarAlquiler(VehiculoType.FURGONETA, dias, emp);
            case 3 -> marcarAlquiler(VehiculoType.MOTO, dias, emp);
        }

        
    }

    public static void reducirDiasAlquiler() {
        ArrayList<Pair<VehiculoType, Vehiculo>> alquileresFinalizados;

        for (Empresa empresa : empresas) {
            alquileresFinalizados = empresa.disminuirDiasAlquilerTodos();

            if (alquileresFinalizados != null) {
                for (Pair<VehiculoType, Vehiculo> item : alquileresFinalizados) 
                    noAlquilados.add(item);
            }
        }
    }

    public static void marcarAlquiler(VehiculoType tipo, int dias, Empresa emp) {
        boolean encontrado = false;
        boolean encontradoEmpresa = false;
        int indice = 0;
        int indiceEmpresa = 0;

        // Miramos si quedan Vehículos del tipo indicado
        while (indice < noAlquilados.size() && !encontrado) {
            encontrado = noAlquilados.get(indice).getFirst().equals(tipo);
            // avanzamos si no se ha encontrado
            indice += !encontrado ? 1 : 0;
        }

        // buscamos la empresa
        while (indiceEmpresa < empresas.size() && !encontradoEmpresa) {
            encontradoEmpresa = empresas.get(indiceEmpresa).equals(emp);
            // avanzamos si no se ha encontrado
            indiceEmpresa += !encontradoEmpresa ? 1 : 0;
        }
        
        if (encontrado && encontradoEmpresa) {
            empresas.get(indiceEmpresa).addAlquiler(dias, noAlquilados.get(indice).getSecond(), noAlquilados.get(indice).getFirst());

            noAlquilados.remove(noAlquilados.get(indice));
            
        }

        else {
            switch(tipo) {
                case COCHE -> System.out.println("No quedan soches disponibles\n");
                case FURGONETA -> System.out.println("No quedan furgonetas disponibles\n");
                case MOTO -> System.out.println("No quedan motos disponibles\n");
            }

        }
    }

    public static void mostrarStock() {
        System.out.println("\nCoches sin alquilar");
        System.out.println("===================");
        mostrarTipo(VehiculoType.COCHE);

        System.out.println("\nFurgonetas sin alquilar");
        System.out.println("=======================");
        mostrarTipo(VehiculoType.FURGONETA);

        System.out.println("\nMotos sin alquilar");
        System.out.println("==================");
        mostrarTipo(VehiculoType.MOTO);

        System.out.println('\n');
        
        for (Empresa empresa : empresas) {
            empresa.mostrarAlquileres();
            System.out.println();
        }
        
    }

    public static void mostrarTipo(VehiculoType tipo) {
        for (Pair<VehiculoType, Vehiculo> item : noAlquilados) 
            if (item.getFirst() == tipo)
                System.out.printf(
                    "%s %s %s\n", 
                    item.getSecond().getMarca(), 
                    item.getSecond().getModelo(), 
                    item.getSecond().getMatricula());
    }

    public static int pedirEmpresa() {
        int resultado;
        boolean acabado = false;

        do {
            System.out.printf("¿Qué empresa desea alquilar un vehículo? [1, %d]: ", empresas.size());
            try {
                resultado = Integer.parseInt(reader.readLine());
                acabado = (resultado > 0 && resultado <= empresas.size()) || resultado == -2 || resultado == -1;
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error al leer el índice de empresa");
                resultado = -3;
            }
        }
        while (!acabado);

        return resultado;
    }

    public static int pedirVehiculo() {
        int resultado;

        do {
            System.out.printf("¿Qué vehículo se desea alquilar? [1.- Coche 2.-Furgoneta 3.- Moto]: ");
            try {
                resultado = Integer.parseInt(reader.readLine());

                if (!(resultado > 0 && resultado < 4))
                    System.out.println("Índice de vehículo inválido...");
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error al leer el índice de vehículo");
                resultado = -1;
            }
        }
        while (!(resultado > 0 && resultado < 4));

        return resultado;
    }

    public static int pedirDias() {
        int resultado;

        do {
            System.out.printf("¿Durante cuántos días?: ");
            try {
                resultado = Integer.parseInt(reader.readLine());

                if (resultado < 0)
                    System.out.println("Valor de días inválido...");
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error al leer la cantidad de días");
                resultado = -1;
            }
        }
        while (resultado < 0);

        return resultado;
    }

    public static void inicializarAlquileres() {
        noAlquilados = new ArrayList<>();

        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("5557LH", "Ford", "Transit", 33.2, 4)));
        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("2356LBM", "Seat", "Leon", 22.4, 4)));
        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("9845LKS", "Renault", "Clio", 33.2, 4)));
        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("4365LLF", "Citroen", "C3", 33.2, 4)));
        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("7423KZF", "Peugeot", "208", 33.2, 4)));
        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("7190LLB", "Volkswagen", "Golf", 37.2, 4)));
        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("1122KTL", "Mercedes", "CLAs", 33.2, 4)));
        noAlquilados.add(new Pair<>(VehiculoType.COCHE, new Coche("4447LLM", "Seat", "Ateca", 28.3, 4)));

        noAlquilados.add(new Pair<>(VehiculoType.FURGONETA,new Furgoneta("1198KZZ", "Peugeot", "Boxer", 38.91, 102.4)));
        noAlquilados.add(new Pair<>(VehiculoType.FURGONETA,new Furgoneta("4321LCC", "Renault", "Kangoo ZE", 48.2, 156.4)));
        noAlquilados.add(new Pair<>(VehiculoType.FURGONETA,new Furgoneta("5672YYT", "Mercedes-Bez", "Vito Mixto 113C", 55.2, 170.3)));

        noAlquilados.add(new Pair<>(VehiculoType.MOTO,new Moto("9987LDD", "Kawaski", "J300", 19.44, true)));
        noAlquilados.add(new Pair<>(VehiculoType.MOTO,new Moto("5554LDD", "Yamaha", "NMAX", 22.44, true)));
    }

    public static void inicializarEmpresas() {
        empresas = new ArrayList<>();

        empresas.add(new Empresa("B-76345879", "IKEA"));
        empresas.add(new Empresa("C-00373762", "Media Markt"));
        empresas.add(new Empresa("R-92872101", "Carrefour"));
        empresas.add(new Empresa("F-20834281", "Alcampo"));
        empresas.add(new Empresa("T-00283621", "KIABI"));
    }

}