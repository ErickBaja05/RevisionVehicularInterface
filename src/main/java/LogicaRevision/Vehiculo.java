package LogicaRevision;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Vehiculo {
    private int carId;
    protected String color;
    protected String marca;
    protected String modelo;
    protected String placa;
    protected Freno[] frenos;
    protected Motor motor;
    protected Llanta[] llantas;
    protected Luz [] luces;
    protected Chasis chasis;
    protected Propietario propietario;
    protected int anio;
    protected TuboEscape tuboEscape;

    public Vehiculo(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio) {
        this.carId = carId;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.frenos = new Freno[nFrenos];
        this.motor = new Motor();
        this.llantas = new Llanta[nLlantas];
        this.luces = new Luz[3]; // 0 DELANTERAS, 1 TRASERAS, 2 DIRECCIONALES
        this.chasis = new Chasis();
        this.propietario = propietario;
        this.anio = anio;
        this.tuboEscape = new TuboEscape();
    }
    public Vehiculo() {}

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws IllegalArgumentException {
        if(verficarPlaca(placa)){
            this.placa = placa;
        } else {
            throw new IllegalArgumentException("Placa Invalida");
        }
    }

    public Freno[] getFrenos() {
        return frenos;
    }

    public void setFrenos(Freno[] frenos) {
        this.frenos = frenos;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }


    public Llanta[] getLlantas() {
        return llantas;
    }

    public void setLlantas(Llanta[] llantas) {
        this.llantas = llantas;
    }


    public Luz[] getLuces() {
        return luces;
    }

    public void setLuces(Luz[] luces) {
        this.luces = luces;
    }

    public Chasis getChasis() {
        return chasis;
    }

    public void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public TuboEscape getTuboEscape() {
        return tuboEscape;
    }

    public void setTuboEscape(TuboEscape tuboEscape) {
        this.tuboEscape = tuboEscape;
    }
    public boolean verficarPlaca(String placa){
        String regex = "^[ABCEGHIJKLMNOPQRSTUVWXYXZ][A-Z]{2}-\\d{3,4}$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(placa);
        return coincidencia.matches();

    }
}
