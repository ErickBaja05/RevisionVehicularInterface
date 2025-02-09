package LogicaRevision;

public class TuboEscape {

    private double valorEmisionGas;
    private boolean estadoTuboEscape;

    public TuboEscape() {
        this.valorEmisionGas = 0;
        this.estadoTuboEscape = false;
    }

    public TuboEscape(double valorEmisionGas) {
        this.valorEmisionGas = valorEmisionGas;
        this.estadoTuboEscape = false;
    }

    public double getValorEmisionGas() {
        return valorEmisionGas;
    }

    public void setValorEmisionGas(double valorEmisionGas) {
        this.valorEmisionGas = valorEmisionGas;
    }

    public boolean getEstadoTuboEscape() {
        return estadoTuboEscape;
    }

    public void setEstadoTuboEscape(String estadoTuboEscape) {
        this.estadoTuboEscape = !estadoTuboEscape.equals("Malo");
    }
}
