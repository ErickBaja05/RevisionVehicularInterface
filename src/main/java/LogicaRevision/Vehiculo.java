package LogicaRevision;
import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Vehiculo implements Serializable {
    private int carId;
    protected String color;
    protected String marca;
    protected String modelo;
    protected String placa;
    protected Freno sistemaFrenos;
    protected Motor motor;
    protected Llanta[] llantas;
    protected Luz [] luces;
    protected Chasis chasis;
    protected Propietario propietario;
    protected int anio;
    protected TuboEscape tuboEscape;
    protected boolean estadoLuces = false;
    protected boolean estadoMotor= false;
    protected boolean estadoLlantas= true;
    protected boolean estadoChasis= true;
    protected boolean estadoFrenos= false;
    protected boolean estadoTuboEscape= false;
    protected boolean estadoAdicionales = false;

    public Vehiculo(int carId, String color, String marca, String modelo, String placa, int nFrenos, int nLlantas, Propietario propietario, int anio) {
        this.carId = carId;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        if(verficarPlaca(placa)){
            this.placa = placa;
        } else {
            throw new IllegalArgumentException("Placa Invalida");
        }
        this.sistemaFrenos = new Freno();
        this.motor = new Motor();
        this.llantas = new Llanta[nLlantas];
        for(int i = 0; i < nLlantas; i++){
            this.llantas[i] = new Llanta();
        }
        this.luces = new Luz[4]; // 0 DELANTERAS, 1 TRASERAS, 2 DIRECION, 3 NEBLINEROS
        for(int i = 0; i < 4; i++){
            this.luces[i] = new Luz();
        }
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

    public Freno getSistemaFrenos() {
        return this.sistemaFrenos;
    }

    public void setFrenos(Freno frenos) {
        this.sistemaFrenos = frenos;
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

    @Override
    public String toString(){
        return String.format("%s%n%s%n%s%n%s",this.marca, this.modelo, this.color,this.placa);
    }

    public void setSistemaFrenos(Freno sistemaFrenos) {
        this.sistemaFrenos = sistemaFrenos;
    }

    public boolean isEstadoLuces() {
        return estadoLuces;
    }

    public void setEstadoLuces(boolean estadoLuces) {
        this.estadoLuces = estadoLuces;
    }

    public boolean isEstadoMotor() {
        return estadoMotor;
    }

    public void setEstadoMotor(boolean estadoMotor) {
        this.estadoMotor = estadoMotor;
    }

    public boolean isEstadoLlantas() {
        return estadoLlantas;
    }

    public void setEstadoLlantas(boolean estadoLlantas) {
        this.estadoLlantas = estadoLlantas;
    }

    public boolean isEstadoChasis() {
        return estadoChasis;
    }

    public void setEstadoChasis(boolean estadoChasis) {
        this.estadoChasis = estadoChasis;
    }

    public boolean isEstadoFrenos() {
        return estadoFrenos;
    }

    public void setEstadoFrenos(boolean estadoFrenos) {
        this.estadoFrenos = estadoFrenos;
    }

    public boolean isEstadoTuboEscape() {
        return estadoTuboEscape;
    }

    public void setEstadoTuboEscape(boolean estadoTuboEscape) {
        this.estadoTuboEscape = estadoTuboEscape;
    }

    public boolean isEstadoAdicionales() {
        return estadoAdicionales;
    }

    public void setEstadoAdicionales(boolean estadoAdicionales) {
        this.estadoAdicionales = estadoAdicionales;
    }

    public void resetear(){
        this.estadoLuces = false;
        this.estadoMotor= false;
        this.estadoLlantas= true;
        this.estadoChasis= true;
        this.estadoFrenos= false;
        this.estadoTuboEscape= false;
        this.estadoAdicionales = false;
    }
}
