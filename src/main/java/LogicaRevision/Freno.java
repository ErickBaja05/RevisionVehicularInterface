package LogicaRevision;

import java.io.Serializable;

public class Freno implements Serializable {

    private double calentaminetoFrenos;
    private String estadoPastillas;
    private boolean estadoFrenos;

    public Freno(){
        this.calentaminetoFrenos = 0;
        this.estadoPastillas = "";
        this.estadoFrenos = false;
    }

    public Freno(int calentaminetoFrenos, String estadoPastillas){
        this.calentaminetoFrenos = calentaminetoFrenos;
        this.estadoPastillas = estadoPastillas;
        this.estadoFrenos = false;
    }

    public double getCalentaminetoFrenos() {
        return calentaminetoFrenos;
    }

    public void setCalentaminetoFrenos(double calentaminetoFrenos) {
        this.calentaminetoFrenos = calentaminetoFrenos;
    }

    public String getEstadoPastillas() {
        return estadoPastillas;
    }

    public void setEstadoPastillas(String estadoPastillas) {
        this.estadoPastillas = estadoPastillas;
    }

    public boolean getEstadoFrenos() {
        return estadoFrenos;
    }

    public void setEstadoFrenos(String estadoFrenos) {
        this.estadoFrenos = !estadoFrenos.equals("Deteriorado");
    }
}
