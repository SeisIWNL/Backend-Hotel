package pe.com.hotel_api.persistence.enums;

public enum EstadoSede {
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No Disponible");

    private final String estadoMinuscula;

    EstadoSede(String estadoMinuscula) {
        this.estadoMinuscula = estadoMinuscula;
    }

    public String getEstadoMinuscula() {
        return estadoMinuscula;
    }

    public static EstadoSede fromStringToEnum(String estadoMinuscula) {
        for (EstadoSede estado : EstadoSede.values()) {
            if (estado.getEstadoMinuscula().equalsIgnoreCase(estadoMinuscula)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("No se ha encontrado un estado con el nombre " + estadoMinuscula);
    }
}
