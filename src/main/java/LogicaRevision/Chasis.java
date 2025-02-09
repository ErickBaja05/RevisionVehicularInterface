package LogicaRevision;

public class Chasis {

    private int corrosionChasis;
    private int alineacionChasis;
    private int suspensionChasis;
    private boolean estadoChasis;

    public Chasis(){
        this.corrosionChasis = 0;
        this.alineacionChasis = 0;
        this.suspensionChasis = 0;
    }

    public int getCorrosionChasis() {
        return corrosionChasis;
    }

    public void setCorrosionChasis(int corrosionChasis) {
        this.corrosionChasis = corrosionChasis;
    }

    public int getAlineacionChasis() {
        return alineacionChasis;
    }

    public void setAlineacionChasis(int alineacionChasis) {
        this.alineacionChasis = alineacionChasis;
    }

    public int getSuspensionChasis() {
        return suspensionChasis;
    }

    public void setSuspensionChasis(int suspensionChasis) {
        this.suspensionChasis = suspensionChasis;
    }

    public boolean getEstadoChasis() {
        return estadoChasis;
    }

    public void setEstadoChasis(String estadoChasis) {
        this.estadoChasis = !estadoChasis.equals("Malo");
    }
}
