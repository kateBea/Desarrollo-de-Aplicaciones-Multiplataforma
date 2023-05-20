package ejer1;

import java.util.ArrayList;

public class Department {
    private int id;
    private String localizacion;
    private ArrayList<Employee> coordinadores;

    public Department(int id, String localizacion) {
        this.id = id;
        this.localizacion = localizacion;
        coordinadores = new ArrayList<>();
    }

    public Department(int id, String localizacion, ArrayList<Employee> coords) {
        this.id = id;
        this.localizacion = localizacion;
        coordinadores = coords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public ArrayList<Employee> getCoordinadores() {
        return coordinadores;
    }

    public void setCoordinadores(ArrayList<Employee> coordinadores) {
        this.coordinadores = coordinadores;
    }  
    
    public void addCoordinador(Employee coord) {
        this.coordinadores.add(coord);
    }

    @Override
    public String toString() {
        return String.format("id= '%d' localizacion= '%s'", getId(), getLocalizacion());
    }
}
