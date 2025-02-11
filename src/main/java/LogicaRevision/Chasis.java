package LogicaRevision;

import java.io.Serializable;

public class Chasis implements Serializable {

    private String corrosionChasis;
    private String alineacionChasis;
    private String suspensionChasis;
    private boolean estadoChasis;

    public Chasis(){
        this.corrosionChasis = "";
        this.alineacionChasis = "";
        this.suspensionChasis = "";
    }

    public String getCorrosionChasis() {
        return corrosionChasis;
    }

    public void setCorrosionChasis(String corrosionChasis) {
        this.corrosionChasis = corrosionChasis;
    }

    public String getAlineacionChasis() {
        return alineacionChasis;
    }

    public void setAlineacionChasis(String alineacionChasis) {
        this.alineacionChasis = alineacionChasis;
    }

    public String getSuspensionChasis() {
        return suspensionChasis;
    }

    public void setSuspensionChasis(String suspensionChasis) {
        this.suspensionChasis = suspensionChasis;
    }

    public boolean getEstadoChasis() {
        return estadoChasis;
    }

    public void setEstadoChasis(boolean estadoChasis) {
        this.estadoChasis = estadoChasis;
    }
}
