package LogicaRevision;

public class Motor {
    private String tipoMotor;
    private double temperaturaMotor;
    private boolean fugaMotor;
    private String estadoMotor;

    public Motor(){
        this.tipoMotor = "";
        this.temperaturaMotor = 0;
        this.estadoMotor = "";
    }

    public Motor(String tipo, double temperaturaMotor, String estadoMotor) {
        this.tipoMotor = tipo;
        this.temperaturaMotor = temperaturaMotor;
        this.estadoMotor = estadoMotor;
    }

    public double getTemperaturaMotor(){
        return this.temperaturaMotor;
    }
    public String getTipoMotor() {
        return this.tipoMotor;
    }
    public String getEstadoMotor(){
        return this.estadoMotor;
    }

    public boolean tieneFugaMotor() {
        return this.fugaMotor;
    }
    public void setEstadoMotor(String estado){
        this.estadoMotor = estado;
    }

    public void setTipoMotor(String tipo) {
        this.tipoMotor = tipo;
    }

    public void setTemperaturaMotor(String temperatura) throws NumberFormatException {
        this.temperaturaMotor = Double.parseDouble(temperatura);
    }

    public void setFugaMotor(String fuga) {
        this.fugaMotor = fuga.equalsIgnoreCase("si");
    }

}
