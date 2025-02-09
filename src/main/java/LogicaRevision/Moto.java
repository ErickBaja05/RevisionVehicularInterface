package LogicaRevision;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio, int cilindraje) {
        super(carId, color, marca, modelo, placa, nFrenos, nLlantas, propietario, anio);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}






