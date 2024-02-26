package dam2.taller.modelo;

public enum Estado {
    EN_ESPERA { @Override public String toString() { return "En espera"; }},
    EN_PROCESO { @Override public String toString() { return "En proceso"; }},
    FINALIZADO { @Override public String toString() { return "Finalizado"; }},
}
