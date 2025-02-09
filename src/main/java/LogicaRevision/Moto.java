package LogicaRevision;

public class Moto extends Vehiculo{
    private int cilindraje;
    private String tipoMoto;
    private boolean tieneMaletero;
    public Moto(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio, int cilindraje, String tipoMoto, boolean tieneMaletero) {
        super(carId,color,marca,modelo,placa,nFrenos,nLlantas,propietario,anio);
        this.cilindraje = cilindraje;
        this.tipoMoto = tipoMoto;
        this.tieneMaletero = tieneMaletero;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    public boolean isTieneMaletero() {
        return tieneMaletero;
    }

    public void setTieneMaletero(boolean tieneMaletero) {
        this.tieneMaletero = tieneMaletero;
    }
}





