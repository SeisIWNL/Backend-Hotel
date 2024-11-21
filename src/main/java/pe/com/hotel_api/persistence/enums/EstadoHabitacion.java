package pe.com.hotel_api.persistence.enums;

public enum EstadoHabitacion {
    DISPONIBLE("Disponible"),
    OCUPADA("Ocupada"),
    RESERVADA("Reservada"),
    MANTENIMIENTO("Mantenimiento");

    private final String estadoMinuscula;

    EstadoHabitacion(String estadoMinuscula) {
        this.estadoMinuscula = estadoMinuscula;
    }

    public String getEstadoMinuscula() {
        return estadoMinuscula;
    }

    public static EstadoHabitacion fromEstadoMinuscula(String estadoMinuscula) {
        for (EstadoHabitacion estado : EstadoHabitacion.values()) {
            if (estado.getEstadoMinuscula().equals(estadoMinuscula)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("No se ha encontrado un estado con el nombre " + estadoMinuscula);
    }
}
