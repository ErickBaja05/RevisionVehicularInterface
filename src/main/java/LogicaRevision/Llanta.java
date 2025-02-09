package LogicaRevision;

public class Llanta {

    private double bandaRodadura;
    private double presionLlanta;
    private String estadoLlanta;

    public Llanta() {
        this.bandaRodadura = 0;
        this.presionLlanta = 0;
    }

    public double getBandaRodadura() {
        return bandaRodadura;
    }

    public void setBandaRodadura(String rodadura) throws Exception {
        double bandaRodaduraValor = 0.0;
                bandaRodaduraValor = Double.parseDouble(rodadura);
        this.bandaRodadura = bandaRodaduraValor;
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
        this.estadoLlanta = estadoLlanta;
    }

    public String getEstadoLlanta() {
        return this.estadoLlanta;
    }
}

