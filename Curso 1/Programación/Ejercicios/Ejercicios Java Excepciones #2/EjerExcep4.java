import parking.Aparcamiento;
import parking.AparcamientoException;
import parking.Automovil;
import parking.Camion;
import parking.Vehiculo;
import parking.Automovil.AutomovilType;
import parking.Camion.CamionType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjerExcep4 {
    private static class TiempoInvalido extends Exception {
        public TiempoInvalido(String msg) {
            super(msg);
        }
    }
    private static final Scanner reader = new Scanner(System.in);
    /**
     * se utilizará en waitTime() para el tiempo de espera 
     * entre retiradas de vehículos (mide el tiempo en segunods)
    */
    private static int tiempoDeEspera;

    public static void main(String[] args) throws InterruptedException {
        leerTiempoDeEspera();

        // creamos los vehiculos
        ArrayList<Vehiculo> vehiculos = getVehiculos();

        // mostramos todos los vehículos
        for (Vehiculo veh : vehiculos) 
            System.out.println(veh.toString());

        // creamos un aparmiento 
        Aparcamiento sanAndreas = new Aparcamiento(3);

        System.out.println("********** APARCAMOS VEHÍCULOS AL PARKING **********");
        try {
            // introducimos vehículos al aprcamiento
            sanAndreas.introducirVehiculo(vehiculos.get(0));

            // intentamos añadir el mismo vehóculo otra vez
            // sanAndreas.introducirVehiculo(vehiculos.get(0));

            sanAndreas.introducirVehiculo(vehiculos.get(1));
            sanAndreas.introducirVehiculo(vehiculos.get(2));

            // excedemos capacidad máxima
            sanAndreas.introducirVehiculo(vehiculos.get(0)); 

            System.out.printf("La máxima capacidad es [ %d ] y el número de plazas libres ahora es es [ %d ].\n", 
                sanAndreas.getMaxCapacidad(), sanAndreas.getCapacidad()); 
        }
        catch (AparcamientoException ae) {
            ae.printStackTrace();
        }
            
        System.out.println("********** RETIRAMOS VEHÍCULOS AL PARKING **********");
        try {
            retirarUnVehiculo(vehiculos.get(0), sanAndreas);
            retirarUnVehiculo(vehiculos.get(1), sanAndreas);
            retirarUnVehiculo(vehiculos.get(2), sanAndreas);
            
            // intentamos borrar uno que ya no existe
            retirarUnVehiculo(vehiculos.get(1), sanAndreas);
        }
        catch (AparcamientoException ae) {
            System.out.println(ae.getMessage());
            ae.printStackTrace();
        }
    }

    public static void leerTiempoDeEspera() {
        boolean acabar = false;

        while (!acabar) {
            System.out.print("Introduzca el tiempo de espera entre retirada de vehículos (en segundos): ");
            
            try {
                tiempoDeEspera = reader.nextInt();

                if (tiempoDeEspera < 0)
                    throw new TiempoInvalido("");

                acabar = true;

            }
            catch (InputMismatchException im) {
                // skip next tokens
                reader.next();
                System.out.println("Formato incorrecto. El valor debe ser entero no negativo");
            }
            catch (TiempoInvalido te) {
                System.out.println("Formato incorrecto. El valor debe ser entero no negativo");
            }
        }
    }
    public static ArrayList<Vehiculo> getVehiculos() {
        ArrayList<Vehiculo> res = new ArrayList<>();

        res.add(new Automovil("2754 HHR", false, AutomovilType.TODOTERRENO));
        res.add(new Automovil("3864 AAA", true, AutomovilType.FURGONETA));
        res.add(new Automovil("3761 OPR", true, AutomovilType.TODOTERRENO));
        res.add(new Automovil("4561 GHS", false, AutomovilType.TURISMO));
        res.add(new Automovil("1111 YOU", true, AutomovilType.TODOTERRENO));
        res.add(new Automovil("3951 MNA", false, AutomovilType.TURISMO));
        res.add(new Automovil("6996 NBA", true, AutomovilType.FURGONETA));

        res.add(new Camion("5861 BBS", true, CamionType.MAS_EJES));
        res.add(new Camion("4751 POR", true, CamionType.MENOS_EJES));
        res.add(new Camion("4658 MFB", false, CamionType.MENOS_EJES));

        return res;
    }

    public static void retirarUnVehiculo(Vehiculo target, Aparcamiento parking) throws AparcamientoException {
        try {
            waitTime();
        }
        catch(InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.printf("\n- Retirar el vehículo con matrícula '%s' cuesta %f euros.\n\n", 
            target.getMatricula(), parking.sacarVehiculo(target.getMatricula()));
    }

    // cesar ejecución de este hilo por un minuto
    public static void waitTime() throws InterruptedException {
        // cantidad de milisegundos por un segundo
        final int FACTOR = 1000;

        Thread.sleep(tiempoDeEspera * FACTOR);
    }
}