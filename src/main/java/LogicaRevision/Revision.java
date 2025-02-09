package LogicaRevision;

public class Revision {

    private int idRevision;
    private Propietario revisionPropietario;
    private Inspector revisionInspector;

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
        return String.format("RESULTADOS AQUI");

    }


}
