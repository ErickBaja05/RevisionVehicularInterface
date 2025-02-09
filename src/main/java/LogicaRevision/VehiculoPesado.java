package LogicaRevision;

public class VehiculoPesado extends Vehiculo{
    private int capacidadCarga;
    private boolean llantaEmergencia;
    private boolean cinturonSeguridad;
    private boolean kitPrimerosAuxilios;

    public VehiculoPesado(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio, int capacidadCarga, boolean llantaEmergencia, boolean cinturonSeguridad, boolean kitPrimerosAuxilios) {
        super(carId, color, marca, modelo, placa, nFrenos, nLlantas, propietario, anio);
        this.capacidadCarga = capacidadCarga;
        this.llantaEmergencia = llantaEmergencia;
        this.cinturonSeguridad = cinturonSeguridad;
        this.kitPrimerosAuxilios = kitPrimerosAuxilios;
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
}
