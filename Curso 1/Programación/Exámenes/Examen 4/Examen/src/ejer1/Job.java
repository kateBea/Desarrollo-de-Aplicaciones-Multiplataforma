package ejer1;

public class Job {
    private int id;
    private String titulo;
    private double minSalario;
    private double maxSalario;

    
    public Job(int id, String titulo, double maxSalario, double minSalario) {
        this.id = id;
        this.titulo = titulo;
        this.maxSalario = maxSalario;
        this.minSalario = minSalario;
    }

    public Job(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.maxSalario = .0;
        this.minSalario = .0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMinSalario() {
        return minSalario;
    }

    public void setMinSalario(double minSalario) {
        this.minSalario = minSalario;
    }

    public double getMaxSalario() {
        return maxSalario;
    }

    public void setMaxSalario(double maxSalario) {
        this.maxSalario = maxSalario;
    }  

    @Override
    public String toString() {
        return String.format(
            "id= '%d' titulo = '%s' Salario maximo = '%.3f' Salario minimo = '%.3f'",
            getId(), getTitulo(), getMaxSalario(), getMinSalario() 
        );
    }
}
