package nominas;

public class TestGestionNominas {
    public static void main(String[] args) {
        // me creo distintos tipos de empleados
        Jefe j1 = new Jefe ("José Javier", "Ruiz", "123-A", 2250.60);
        EmpleadoComision c1 = new EmpleadoComision("Pedro", "Martinez Ruiz", "234-B", 1850.68, 1.5, 50);
        EmpleadoHora  h1 = new EmpleadoHora("María", "Ruiz Moreno", "245-C", 1450.65, 50);
        EmpleadoPieza p1 = new EmpleadoPieza("Juan", "Rodriguez", "675-S", 'H', "58478744" , "ggg@mm.com", 15, 20);

        System.out.println (j1.toString());
        System.out.println (c1.toString());
        System.out.println (h1.toString());
        System.out.println (p1.toString());

    }

}    