package pe.com.hotel_api.persistence.enums;

public enum EstadoReserva {
    PENDIENTE("Pendiente"),
    CONFIRMADA("Confirmada"),
    RESERVADA("Reservada"),
    CANCELADA("Cancelada"),
    COMPLETA("Completa");

    private final String estadoMinuscula;

    EstadoReserva(String estadoMinuscula) {
        this.estadoMinuscula = estadoMinuscula;
    }

    public String getEstadoMinuscula() {
        return estadoMinuscula;
    }

    public static EstadoReserva fromEstadoMinuscula(String estadoMinuscula) {
        for (EstadoReserva estado : EstadoReserva.values()) {
            if (estado.getEstadoMinuscula().equals(estadoMinuscula)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("No se ha encontrado un estado con el nombre " + estadoMinuscula);
    }
}
