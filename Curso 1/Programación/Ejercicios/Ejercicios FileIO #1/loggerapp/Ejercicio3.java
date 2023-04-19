package loggerapp;

public class Ejercicio3 {
    public static void main(String[] args) {
        Logger.write("changes.log", "hecho cambio en bases de datos", 
                                                "añadido nuevo empleado a lista de empleados");

        Logger.write("changes.log", "eliminada base de datos", 
                                    "los empleados se han ido a tomar un café");

                            
    }
}