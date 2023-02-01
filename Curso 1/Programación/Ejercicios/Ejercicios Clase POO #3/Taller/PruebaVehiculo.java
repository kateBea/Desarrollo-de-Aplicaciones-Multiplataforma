package Taller;

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

        System.out.println("********** Test Cambio de marchas **********");
        v1.setMarcha((byte)-3);
        v1.setMarcha((byte)4);
        v2.setMarcha((byte)5);
        v3.setMarcha((byte)1);

        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());

        System.out.println("Pruebas con el paquete de Taller...");

        // generamos todas las piezas y las añadimos a los coches
        // no prestar mucha atención a los precios de reparación gracias :-)
        Pieza[] piezas = new Pieza[]{
            new Pieza("Luna", 3.55),
            new Pieza("Parabrisas", 2.56),
            new Pieza("Motor", 47.5),
            new Pieza("Llantas", 15.33),
            new Pieza("Faros antiniebla", 22.43),
            new Pieza("Retrovisor", 11.2)
        };

        v1.addPiezas(piezas);
        v2.addPiezas(piezas);
        v3.addPiezas(piezas);

        v1.mostraPiezas();
        System.out.println();
        v2.mostraPiezas();
        System.out.println();
        v3.mostraPiezas();

        Taller arcor = new Taller("Arcor", "652 22 88 11", 3.4);

        System.out.printf("Reparación de " + v3.getMarca() + " " + v3.getModelo() + ": %.3f euro(s)\n",
            arcor.repararVehiculo(v3, 4.6));

    }
}
