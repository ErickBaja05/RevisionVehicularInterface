package LogicaRevision;

public class VehiculoLiviano extends Vehiculo {
    private boolean llantaEmergencia;
    private String tipoTransmision;
    private boolean cinturonSeguridad;
    private boolean kitPrimerosAuxilios;

    public VehiculoLiviano(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio, boolean llantaEmergencia, String tipoTransmision, boolean cinturonSeguridad, boolean kitPrimerosAuxilios) {
        super(carId, color, marca, modelo, placa, nFrenos, nLlantas, propietario, anio);
        this.llantaEmergencia = llantaEmergencia;
        this.tipoTransmision = tipoTransmision;
        this.cinturonSeguridad = cinturonSeguridad;
        this.kitPrimerosAuxilios = kitPrimerosAuxilios;
    }
    public VehiculoLiviano() {}

    public boolean isLlantaEmergencia() {
        return llantaEmergencia;
    }

    public void setLlantaEmergencia(boolean llantaEmergencia) {
        this.llantaEmergencia = llantaEmergencia;
    }

    public String getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(String tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }

    public boolean isCinturonSeguridad() {
        return cinturonSeguridad;
    }

    public void setCinturonSeguridad(boolean cinturonSeguridad) {
        this.cinturonSeguridad = cinturonSeguridad;
    }

    public boolean isKitPrimerosAuxilios() {
        return kitPrimerosAuxilios;
    }

    public void setKitPrimerosAuxilios(boolean kitPrimerosAuxilios) {
        this.kitPrimerosAuxilios = kitPrimerosAuxilios;
    }
}
