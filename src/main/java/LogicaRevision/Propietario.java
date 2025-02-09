package LogicaRevision;

public class Propietario {

    private String idPropietario;
    private String nombrePropietario;
    private String telefonoPropietario;
    private String correoPropietario;
    private Vehiculo vehiculoPropietario;

    public Propietario(String idPropietario, String nombrePropietario, String telefonoPropietario, String correoPropietario, Vehiculo vehiculoPropietario) {
        this.idPropietario = idPropietario;
        this.nombrePropietario = nombrePropietario;
        this.telefonoPropietario = telefonoPropietario;
        this.correoPropietario = correoPropietario;
        this.vehiculoPropietario = vehiculoPropietario;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getTelefonoPropietario() {
        return telefonoPropietario;
    }

    public void setTelefonoPropietario(String telefonoPropietario) {
        this.telefonoPropietario = telefonoPropietario;
    }

    public String getCorreoPropietario() {
        return correoPropietario;
    }

    public void setCorreoPropietario(String correoPropietario) {
        this.correoPropietario = correoPropietario;
    }

    public Vehiculo getVehiculoPropietario() {
        return vehiculoPropietario;
    }

    public void setVehiculoPropietario(Vehiculo vehiculoPropietario) {
        this.vehiculoPropietario = vehiculoPropietario;
    }


}
