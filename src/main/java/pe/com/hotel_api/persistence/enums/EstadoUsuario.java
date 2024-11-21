package pe.com.hotel_api.persistence.enums;

public enum EstadoUsuario {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private final String estadoMinuscula;

    EstadoUsuario(String estadoMinuscula) {
        this.estadoMinuscula = estadoMinuscula;
    }

    public String getEstadoMinuscula() {
        return estadoMinuscula;
    }

    public static EstadoUsuario fromStringToEnum(String estadoMinuscula) {
        for (EstadoUsuario estado : EstadoUsuario.values()) {
            if (estado.getEstadoMinuscula().equalsIgnoreCase(estadoMinuscula)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("No se ha encontrado un estado con el nombre " + estadoMinuscula);
    }
}
