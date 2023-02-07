package productos;

public class Producto {
    private String codigo;
    private String nombre;
    private String tipo;
    private double precio;
    private int existencias;

    public Producto(String codigo, String nombre, String tipo, double precio, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.existencias = existencias;
    }

    public Producto(String nombre, String codigo, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = "Desconocido";
        this.precio = -1.0;
        this.existencias = 0;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public boolean equals(Producto other) {
        return this.codigo.equalsIgnoreCase(other.getCodigo()) &&
                this.nombre.equalsIgnoreCase(other.getNombre()) &&
                this.tipo.equalsIgnoreCase(other.getTipo()); 
    }
}