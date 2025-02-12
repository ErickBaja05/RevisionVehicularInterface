package LogicaRevision;

import java.io.Serializable;

public class Ant implements Serializable {
    private Revision revision;

    public Ant(Revision revision) {
        this.revision = revision;
    }


    public void generateFine(Revision revision) {

        Multa multa = new Multa();
        if (this.revision.getNumeroErrores() > 0){
            multa.setCostoMulta(50);
            multa.setTipoMulta();
            revision.getRevisionPropietario().setMultaNoPasar(multa);
        }


    }
}