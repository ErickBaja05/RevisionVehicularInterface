package LogicaRevision;

import java.io.Serializable;

public class Revision implements Serializable {
    public static final long serialVersionUID = 1L;
    private int idRevision;
    private Propietario revisionPropietario;
    private Inspector revisionInspector;
    private StringBuilder observaciones =  new StringBuilder();
    private int numeroErrores = 0;
    private boolean revisionCompletada = false;

    public Revision(int idRevision, Propietario revisionPropietario, Inspector revisionInspector) {
        this.idRevision = idRevision;
        this.revisionPropietario = revisionPropietario;
        this.revisionInspector = revisionInspector;
    }

    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    public Propietario getRevisionPropietario() {
        return revisionPropietario;
    }

    public void setRevisionPropietario(Propietario revisionPropietario) {
        this.revisionPropietario = revisionPropietario;
    }

    public Inspector getRevisionInspector() {
        return revisionInspector;
    }

    public void setRevisionInspector(Inspector revisionInspector) {
        this.revisionInspector = revisionInspector;
    }

    public String mostrarResultados() {

        System.out.println("Resultados de Revision: ");
        return String.format("%s%n%s",this.getRevisionPropietario(),this.observaciones);

    }

    public void setObservaciones(String observaciones) {
        this.observaciones.append(observaciones + "\n");
    }
    public void aumentarError(){
        this.numeroErrores++;
    }

    public StringBuilder getObservaciones() {
        return observaciones;
    }

    public int getNumeroErrores() {
        return numeroErrores;
    }

    public void setObservaciones(StringBuilder observaciones) {
        this.observaciones = observaciones;
    }

    public void setNumeroErrores(int numeroErrores) {
        this.numeroErrores = numeroErrores;
    }

    public boolean isRevisionCompletada() {
        return revisionCompletada;
    }

    public void setRevisionCompletada(boolean revisionCompletada) {
        this.revisionCompletada = revisionCompletada;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n", this.numeroErrores >0? "NO APROBADO": "APROBADO", this.getRevisionPropietario(), this.getRevisionPropietario().getVehiculoPropietario());
    }
}
