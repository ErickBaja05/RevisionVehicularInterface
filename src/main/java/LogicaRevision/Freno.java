package LogicaRevision;

public class Freno {

    private int calentaminetoFrenos;
    private int estadoPastillas;
    private boolean estadoFrenos;

    public Freno(){
        this.calentaminetoFrenos = 0;
        this.estadoPastillas = 0;
        this.estadoFrenos = false;
    }

    public Freno(int calentaminetoFrenos, int estadoPastillas){
        this.calentaminetoFrenos = calentaminetoFrenos;
        this.estadoPastillas = estadoPastillas;
        this.estadoFrenos = false;
    }

    public int getCalentaminetoFrenos() {
        return calentaminetoFrenos;
    }

    public void setCalentaminetoFrenos(int calentaminetoFrenos) {
        this.calentaminetoFrenos = calentaminetoFrenos;
    }

    public int getEstadoPastillas() {
        return estadoPastillas;
    }

    public void setEstadoPastillas(int estadoPastillas) {
        this.estadoPastillas = estadoPastillas;
    }

    public boolean getEstadoFrenos() {
        return estadoFrenos;
    }

    public void setEstadoFrenos(String estadoFrenos) {
        this.estadoFrenos = !estadoFrenos.equals("Deteriorado");
    }
}
