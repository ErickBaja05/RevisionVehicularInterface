package LogicaRevision;

public class VehiculoLiviano extends Vehiculo {
    private boolean llantaEmergencia;
    private String tipoTransmision;
    private boolean cinturonSeguridad;
    private boolean kitPrimerosAuxilios;
    private boolean tieneAgregados;

    public VehiculoLiviano(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio, String llantaEmergencia, String tipoTransmision, String cinturonSeguridad, String kitPrimerosAuxilios) {
        super(carId, color, marca, modelo, placa, nFrenos, nLlantas, propietario, anio);
        this.llantaEmergencia = llantaEmergencia.equalsIgnoreCase("si");
        this.cinturonSeguridad = cinturonSeguridad.equalsIgnoreCase("si");
        this.kitPrimerosAuxilios = kitPrimerosAuxilios.equalsIgnoreCase("si");
        if(tipoTransmision == null){
            throw new NullPointerException("Debe seleccionar almenos una opcion");
        }else{
            this.tipoTransmision = tipoTransmision;
        }


    }
    public VehiculoLiviano() {}


    public boolean isLlantaEmergencia() {
        return llantaEmergencia;
    }

    public void setLlantaEmergencia(String llantaEmergencia) {
        this.llantaEmergencia = llantaEmergencia.equalsIgnoreCase("si");
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

    public void setCinturonSeguridad(String cinturonSeguridad) {
        this.cinturonSeguridad = cinturonSeguridad.equalsIgnoreCase("si");
    }

    public boolean isKitPrimerosAuxilios() {
        return kitPrimerosAuxilios;
    }

    public void setKitPrimerosAuxilios(String kitPrimerosAuxilios) {
        this.kitPrimerosAuxilios = kitPrimerosAuxilios.equalsIgnoreCase("si");
    }
    public boolean isTieneAgregados() {
        return tieneAgregados;
    }

    public void setTieneAgregados(boolean tieneAgregados) {
        this.tieneAgregados = tieneAgregados;
    }
    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(),this.tipoTransmision);
    }
}
