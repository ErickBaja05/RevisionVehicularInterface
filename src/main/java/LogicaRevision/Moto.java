package LogicaRevision;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio, int cilindraje) {
        super(carId, color, marca, modelo, placa, nFrenos, nLlantas, propietario, anio);

    }
    public Moto() {}
    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    @Override
    public boolean verficarPlaca(String placa){
        String regex = "^[A-Z]{2}-\\d{3}[A-Z]$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(placa);
        return coincidencia.matches();

    }
}






