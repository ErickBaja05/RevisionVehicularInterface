package LogicaRevision;

public class ManagerPropietario {
    public static Propietario propietario;

    public static Propietario getPropietario() {
        return propietario;
    }

    public static void setPropietario(Propietario propietario) {
        ManagerPropietario.propietario = propietario;
    }
}
