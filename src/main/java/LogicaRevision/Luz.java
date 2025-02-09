package LogicaRevision;

public class Luz {

    private boolean estadoLuz;
    private String intensidadLuz;
    private String pasoLuz;

    public void setEstadoLuz(boolean estadoLuz) {
        this.estadoLuz = estadoLuz;
    }

    public Luz() {
        estadoLuz = true;
        intensidadLuz = "Ideal";
    }

    public boolean getEstadoLuz() {
        return estadoLuz;
    }

    public void setEstadoLuz(String estadoLuz) {
        this.estadoLuz = !estadoLuz.equalsIgnoreCase("Quemadas");

    }
    public String getIntensidadLuz() {
        return intensidadLuz;
    }

    public void setIntensidadLuz(String intensidadLuz) {
        this.intensidadLuz = intensidadLuz;
    }

    public String getPasoLuz() {
        return pasoLuz;
    }

    public void setPasoLuz(String pasoLuz) {
        this.pasoLuz = pasoLuz;
    }
}
