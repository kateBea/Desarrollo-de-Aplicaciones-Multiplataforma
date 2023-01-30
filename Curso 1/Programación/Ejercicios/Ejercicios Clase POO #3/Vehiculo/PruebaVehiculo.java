package Vehiculo;

public class PruebaVehiculo {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Opel", "Astra", "1234-BCD", 0.0, false);
        Vehiculo v2 = new Vehiculo("BMW", "S1", "2345-EFG", 80.0, false);
        Vehiculo v3 = new Vehiculo();
        
        v3.setMatricula("4323-QWE");
        v3.setMarca("Audi");
        v3.setModelo("A3");
        v3.setVelocidad(100.0);
        v3.switchLuces(true);

        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
    }
}
