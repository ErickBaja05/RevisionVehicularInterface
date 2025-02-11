package LogicaRevision;

public class VehiculoPesado extends Vehiculo{
    private int capacidadCarga;
    private boolean llantaEmergencia;
    private boolean cinturonSeguridad;
    private boolean kitPrimerosAuxilios;
    private boolean tieneAgregados;
    public VehiculoPesado(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio, int capacidadCarga, String llantaEmergencia, String cinturonSeguridad, String kitPrimerosAuxilios) {
        super(carId, color, marca, modelo, placa, nFrenos, nLlantas, propietario, anio);
        this.capacidadCarga = capacidadCarga;
        this.llantaEmergencia = llantaEmergencia.equalsIgnoreCase("si");
        this.cinturonSeguridad = cinturonSeguridad.equalsIgnoreCase("si");
        this.kitPrimerosAuxilios = kitPrimerosAuxilios.equalsIgnoreCase("si");
    }
    public VehiculoPesado() {}



    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public boolean isLlantaEmergencia() {
        return llantaEmergencia;
    }

    public void setLlantaEmergencia(boolean llantaEmergencia) {
        this.llantaEmergencia = llantaEmergencia;
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

    public boolean isTieneAgregados() {
        return tieneAgregados;
    }

    public void setTieneAgregados(boolean tieneAgregados) {
        this.tieneAgregados = tieneAgregados;
    }
}
