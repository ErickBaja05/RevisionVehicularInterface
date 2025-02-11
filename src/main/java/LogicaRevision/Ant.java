package LogicaRevision;

import java.io.Serializable;

public class Ant implements Serializable {
    private Revision revision;
    private Propietario propietario;

    public Ant(Revision revision) {
        this.revision = revision;
    }

    // RECEIVES A OWNER WHOSE FINE VALUE IS MODIFIED
    public void generateFine(Revision revision) {

        Multa multa = new Multa();
        if (this.revision.getNumeroErrores() > 0){
            multa.setCostoMulta(50);
            multa.setTipoMulta();
            revision.getRevisionPropietario().setMultaNoPasar(multa);
        }


    }
}