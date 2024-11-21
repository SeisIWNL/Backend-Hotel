package pe.com.hotel_api.persistence.enums;

public enum RolUsuario {
    HUESPED("Huesped"),
    ADMIN("Admin");

    private final String rolMinuscula;

    RolUsuario(String rolMinuscula) {
        this.rolMinuscula = rolMinuscula;
    }

    public String getRolMinuscula() {
        return rolMinuscula;
    }

    public static RolUsuario fromStringToEnum(String rolMinuscula) {
        for (RolUsuario rol : RolUsuario.values()) {
            if (rol.getRolMinuscula().equalsIgnoreCase(rolMinuscula)) {
                return rol;
            }
        }
        throw new IllegalArgumentException("No se ha encontrado un rol con el nombre " + rolMinuscula);
    }
}
