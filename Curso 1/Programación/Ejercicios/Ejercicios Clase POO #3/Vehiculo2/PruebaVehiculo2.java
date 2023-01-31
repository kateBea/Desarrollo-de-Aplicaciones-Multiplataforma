package Vehiculo2;

public class PruebaVehiculo2 {
    public static void main(String[] args) {
        Vehiculo2 v1 = new Vehiculo2("Opel", "Astra", "1234-BCD", 0.0, false);
        Vehiculo2 v2 = new Vehiculo2("BMW", "S1", "2345-EFG", 80.0, false);
        Vehiculo2 v3 = new Vehiculo2();
        
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
