package LogicaRevision;

import java.io.Serializable;

public class Llanta implements Serializable {

    private String bandaRodadura;
    private double presionLlanta;
    private String estadoLlanta;

    public Llanta() {
        this.bandaRodadura = "";
        this.presionLlanta = 0;
    }

    public String getBandaRodadura() {
        return bandaRodadura;
    }

    public void setBandaRodadura(String rodadura) throws IllegalArgumentException {
        if(rodadura == null){
            throw new IllegalArgumentException("Llanta rodadura nula");
        }else{
            this.bandaRodadura = rodadura;
        }
    }

    public double getPresionLlanta() {
        return this.presionLlanta;
    }

    public void setPresionLlanta(String presionLlanta) throws NumberFormatException {
        double presionValor = 0.0;
        presionValor = Double.parseDouble(presionLlanta);
        this.presionLlanta = presionValor;

    }

    public void setEstadoLlanta(String estadoLlanta) {
        if(estadoLlanta == null){
            throw new NullPointerException("Debe seleccionar una opcion ");
        }else{
            this.estadoLlanta = estadoLlanta;
        }

    }

    public String getEstadoLlanta() {
        return this.estadoLlanta;
    }
}

