import parking.Aparcameiento;
import parking.Automovil;
import parking.Camion;
import parking.Vehiculo;
import parking.Automovil.AutomovilType;
import parking.Camion.CamionType;

import java.util.ArrayList;

public class MainParking {
    public static void main(String[] args) throws InterruptedException {
        // creamos los vehiculos
        ArrayList<Vehiculo> vehiculos = getVehiculos();

        // mostramos todos los vehículos
        for (Vehiculo veh : vehiculos) 
            System.out.println(veh.toString());

        // creamos un aparmiento 
        Aparcameiento sanAndreas = new Aparcameiento(3);

        // introducimos vehículos al aprcamiento
        sanAndreas.introducirVehiculo(vehiculos.get(0));
        // intentamos añadir el mismo vehóculo otra vez
        sanAndreas.introducirVehiculo(vehiculos.get(0));

        sanAndreas.introducirVehiculo(vehiculos.get(1));
        sanAndreas.introducirVehiculo(vehiculos.get(2));

        // excedemos capacidad máxima
        sanAndreas.introducirVehiculo(vehiculos.get(0)); 
        System.out.printf("La máxima capacidad era [ %d ] y el número de plazas libres ahora es es [ %d ].\n", 
            sanAndreas.getMaxCapacidad(), sanAndreas.getCapacidad()); 
            
        // temporales para mostrar para 
        // recoger valores y mostrar pantalla
        String tempMat;
        double importe;
            
        // waitThreeSecs();
        waitAMin();
        tempMat = vehiculos.get(1).getMatricula();
        importe = sanAndreas.sacarVehiculo(vehiculos.get(1).getMatricula());
        System.out.printf("Retirar el vehículo con matrícula '%s' cuesta %f euros.\n", tempMat, importe);

        waitAMin();
        tempMat = vehiculos.get(2).getMatricula();
        importe = sanAndreas.sacarVehiculo(vehiculos.get(2));
        System.out.printf("Retirar el vehículo con matrícula '%s' cuesta %f euros.\n", tempMat, importe);

        waitAMin();
        tempMat = vehiculos.get(2).getMatricula();
        importe = sanAndreas.sacarVehiculo(vehiculos.get(0).getMatricula());
        System.out.printf("Retirar el vehículo con matrícula '%s' cuesta %f euros.\n", tempMat, importe);

        // intentamos borrar uno que ya no existe
        sanAndreas.sacarVehiculo(vehiculos.get(1).getMatricula());


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

    // cesar ejecución de este hilo por 3 segundos
    public static void waitThreeSecs() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print(". ");
        Thread.sleep(1000);
        System.out.print(". ");
        Thread.sleep(1000);
        System.out.print('.');
        System.out.println();
    }

    // cesar ejecución de este hilo por un minuto
    public static void waitAMin() throws InterruptedException {
        final long SECS_TO_MIN = 60;

        Thread.sleep(1000 * SECS_TO_MIN);
    }
}