package LogicaRevision;

import java.io.Serializable;

public class Inspector implements Serializable {

    private int idInspector;
    private String nombreInspector;

    public Inspector(int idInspector, String nombreInspector) {
        this.idInspector = idInspector;
        this.nombreInspector = nombreInspector;
    }

    public int getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(int idInspector) {
        this.idInspector = idInspector;
    }

    public String getNombreInspector() {
        return nombreInspector;
    }

    public void setNombreInspector(String nombreInspector) {
        this.nombreInspector = nombreInspector;
    }

    public void imprimirInformacionVehiculo() {

    }

    public void imprimirInformacionPropiertario() {

    }

    public void revisarLuces(Vehiculo vehiculo, Revision revision) {
        if(revisarIntensidadLuces(vehiculo, revision) && revisarEstadoLuces(vehiculo,revision)) {
            vehiculo.setEstadoLuces(true);
        }
        else{
            vehiculo.setEstadoLuces(false);
        }

    }
    public boolean revisarIntensidadLuces(Vehiculo vehiculo, Revision revision) {
        Luz[] luces = vehiculo.getLuces();
        String intensidad;
        boolean resultado = false;
        for (int i = 0; i < luces.length; i++) {
            intensidad = luces[i].getIntensidadLuz();
            if (intensidad.equals("Deficiente")) {
                switch (i){
                    case 0:
                        revision.setObservaciones("Intensidad de luces delanteras: deficiente");
                        break;
                    case 1:
                        revision.setObservaciones("Intensidad de luces traseras: deficiente");
                        break;
                    case 2:
                        revision.setObservaciones("Intensidad de luces de parqueo: deficiente");
                        break;
                    case 3:
                        revision.setObservaciones("Intensidad de luces neblineras: deficiente");
                        break;
                }
                revision.aumentarError();
            }else{
                resultado = true;
            }
        }
        return resultado;
    }

    public boolean revisarEstadoLuces(Vehiculo vehiculo, Revision revision) {
        Luz[] luces = vehiculo.getLuces();
        boolean estado = false;
        int contadorLucesQuemadas = 0;
        for (int i = 0; i < luces.length; i++) {
            estado = luces[i].getEstadoLuz();
            if(!estado){
                contadorLucesQuemadas++;
            }

        }
        if(contadorLucesQuemadas >0){
            revision.setObservaciones("Existen luces quemadas");
            revision.aumentarError();
            return false;
        }
        return true;
    }

    // Revisión del Chasis
    public void revisarEstadoChasis(Vehiculo vehiculo, Revision revision) {
        revisarAlineamientoChasis(vehiculo, revision);
        revisarCorrosionChasis(vehiculo, revision);
        revisarSuspensionChasis(vehiculo, revision);
    }

    public void revisarAlineamientoChasis(Vehiculo vehiculo, Revision revision) {
        String estado = vehiculo.getChasis().getAlineacionChasis();
        if (estado.equalsIgnoreCase("Deficiente")) {
            revision.setObservaciones("Alineamiento chasis deficiente");
            vehiculo.setEstadoChasis(false);
            revision.aumentarError();
        }
    }

    public void revisarCorrosionChasis(Vehiculo vehiculo, Revision revision) {
        String estado = vehiculo.getChasis().getCorrosionChasis();
        if(!(estado.equalsIgnoreCase("No"))){
            revision.setObservaciones("Corrosion en chasis");
            vehiculo.setEstadoChasis(false);
            revision.aumentarError();
        }
    }

    public void revisarSuspensionChasis(Vehiculo vehiculo,Revision revision) {
        String estado = vehiculo.getChasis().getSuspensionChasis();
        if (estado.equalsIgnoreCase("Deficiente")) {
            revision.setObservaciones("Suspension chasis deficiente");
            vehiculo.setEstadoChasis(false);
            revision.aumentarError();
        }

    }

    public void revisarEstadoMotor(Vehiculo vehiculo, Revision revision) {
        double temperaturaMotor = vehiculo.getMotor().getTemperaturaMotor();
        boolean tieneFugas = vehiculo.getMotor().tieneFugaMotor();
        boolean resultado = false;
        if(tieneFugas) {
            vehiculo.getMotor().setEstadoMotor("Deficiente");
            revision.setObservaciones("Fugas Motor");
        }
        if ((temperaturaMotor >= 90 && temperaturaMotor <= 100)) {
            vehiculo.getMotor().setEstadoMotor("Bueno");
        }else if ((temperaturaMotor > 100 && temperaturaMotor <= 110)) {
            vehiculo.getMotor().setEstadoMotor("Regular");
        } else {
            vehiculo.getMotor().setEstadoMotor("Deficiente");
            revision.setObservaciones("Motor deficiente con temperaturas muy altas");
        }

        if (vehiculo.getMotor().getEstadoMotor().equals("Bueno")
                || vehiculo.getMotor().getEstadoMotor().equals("Regular")) {
            vehiculo.setEstadoMotor(true);
            resultado = true;
        }
        if(!resultado){
            revision.aumentarError();
        }


    }

    public void revisarEstadoTubodeEscape(Vehiculo vehiculo, Revision revision) {

        double valorEmisionGas = vehiculo.getTuboEscape().getValorEmisionGas();
        String tipoMotor = vehiculo.getMotor().getTipoMotor();
        int anio = vehiculo.getAnio();
        boolean result = false;

        switch (tipoMotor) {
            case "Electrico":
                vehiculo.getTuboEscape().setEstadoTuboEscape("Bueno");
                vehiculo.setEstadoTuboEscape(true);
                result = true;
                break;
            case "Gasolina":
                if (anio <= 1989 && valorEmisionGas <= 6.5) {
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Bueno");
                    vehiculo.setEstadoTuboEscape(true);
                    result = true;
                }else if ((anio > 1989 && anio <= 1999) && valorEmisionGas <= 3.5){
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Bueno");
                    vehiculo.setEstadoTuboEscape(true);
                }
                else if (anio > 1999 && valorEmisionGas <= 1) {
                    vehiculo.setEstadoTuboEscape(true);
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Bueno");
                    result = true;
                }else {
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Deficiente");
                }
                break;
            case "Diesel":
                if (anio <= 1989 && valorEmisionGas <= 2.5) {
                    vehiculo.setEstadoTuboEscape(true);
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Bueno");
                    result = true;
                } else if (anio > 1989 && anio <= 1999 && valorEmisionGas <= 1) {
                    vehiculo.setEstadoTuboEscape(true);
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Bueno");
                } else if (anio > 1999 && valorEmisionGas <= 0.5) {
                    vehiculo.setEstadoTuboEscape(true);
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Bueno");
                    result = true;
                }
                else {
                    vehiculo.getTuboEscape().setEstadoTuboEscape("Deficiente");

                }
        }
        if (!result) {
            revision.aumentarError();
            revision.setObservaciones("Mala Emision de gases");
        }

}

    public void revisarEstadoLlantas(Vehiculo vehiculo, Revision revision) {

        Llanta [] llantas = vehiculo.getLlantas();
        String rodadura;
        Double presion;
        int contadorLLantasLisas = 0;
        int contadorLlantasMalaPresion = 0;
        if(vehiculo instanceof Moto) {
            for (int i = 0; i < llantas.length; i++) {
                rodadura = llantas[i].getBandaRodadura();
                presion = llantas[i].getPresionLlanta();
                if((rodadura.equalsIgnoreCase("Ideal") || rodadura.equalsIgnoreCase("Aceptable")) && (presion >= 28 && presion <= 34)) {
                    vehiculo.getLlantas()[i].setEstadoLlanta("Bueno");
                }
                if(rodadura.equalsIgnoreCase("Deficiente")){
                    vehiculo.getLlantas()[i].setEstadoLlanta("Deficiente");
                    contadorLLantasLisas++;
                }
                if(presion < 28 || presion > 34 ){
                    vehiculo.getLlantas()[i].setEstadoLlanta("Deficiente");
                    contadorLlantasMalaPresion++;
                }
            }
            if(contadorLLantasLisas > 0){
                vehiculo.setEstadoLlantas(false);
                revision.aumentarError();
                revision.setObservaciones("Existen llantas lisas");
            }
            if(contadorLlantasMalaPresion > 0){
                vehiculo.setEstadoLlantas(false);
                revision.aumentarError();
                revision.setObservaciones("Existen llantas con presion inadecuada");
            }

        }else if(vehiculo instanceof VehiculoLiviano){
            for (int i = 0; i < llantas.length; i++) {
                rodadura = llantas[i].getBandaRodadura();
                presion = llantas[i].getPresionLlanta();
                if((rodadura.equalsIgnoreCase("Ideal") || rodadura.equalsIgnoreCase("Aceptable")) && (presion >= 30 && presion <= 42)) {
                    vehiculo.getLlantas()[i].setEstadoLlanta("Bueno");
                }
                if(rodadura.equalsIgnoreCase("Deficiente")){
                    vehiculo.getLlantas()[i].setEstadoLlanta("Deficiente");
                    contadorLLantasLisas++;
                }
                if(presion < 30 || presion > 42 ){
                    vehiculo.getLlantas()[i].setEstadoLlanta("Deficiente");
                    contadorLlantasMalaPresion++;
                }
            }
            if(contadorLLantasLisas > 0){
                vehiculo.setEstadoLlantas(false);
                revision.aumentarError();
                revision.setObservaciones("Existen llantas lisas");
            }
            if(contadorLlantasMalaPresion > 0){
                vehiculo.setEstadoLlantas(false);
                revision.aumentarError();
                revision.setObservaciones("Existen llantas con presion inadecuada");
            }

        }else{
            for (int i = 0; i < llantas.length; i++) {
                rodadura = llantas[i].getBandaRodadura();
                presion = llantas[i].getPresionLlanta();
                if((rodadura.equalsIgnoreCase("Ideal") || rodadura.equalsIgnoreCase("Aceptable")) && (presion >= 115 && presion <= 125)) {
                    vehiculo.getLlantas()[i].setEstadoLlanta("Bueno");
                }
                if(rodadura.equalsIgnoreCase("Deficiente")){
                    vehiculo.getLlantas()[i].setEstadoLlanta("Deficiente");
                    contadorLLantasLisas++;
                }
                if(presion < 115 || presion > 125 ){
                    vehiculo.getLlantas()[i].setEstadoLlanta("Deficiente");
                    contadorLlantasMalaPresion++;
                }
            }
            if(contadorLLantasLisas > 0){
                vehiculo.setEstadoLlantas(false);
                revision.aumentarError();
                revision.setObservaciones("Existen llantas lisas");
            }
            if(contadorLlantasMalaPresion > 0){
                vehiculo.setEstadoLlantas(false);
                revision.aumentarError();
                revision.setObservaciones("Existen llantas con presion inadecuada");
            }
        }
    }

    public void revisarEstadoFrenos(Vehiculo vehiculo, Revision revision) {

        boolean resultado = false;
        double calentamientoFrenos = vehiculo.getSistemaFrenos().getCalentaminetoFrenos();
        String estadoPastillas = vehiculo.getSistemaFrenos().getEstadoPastillas();

        if (estadoPastillas.equalsIgnoreCase("Ideal") && calentamientoFrenos <= 350){

            vehiculo.getSistemaFrenos().setEstadoFrenos("Bueno");
            vehiculo.setEstadoFrenos(true);
            resultado = true;
        } else if (estadoPastillas.equalsIgnoreCase("Aceptable") && calentamientoFrenos < 350) {
            vehiculo.getSistemaFrenos().setEstadoFrenos("Bueno");
            vehiculo.setEstadoFrenos(true);
            resultado = true;
        } else {
            vehiculo.getSistemaFrenos().setEstadoFrenos("Deficiente");
        }

        if (estadoPastillas.equalsIgnoreCase("Deficiente")){
            vehiculo.setEstadoFrenos(false);
            revision.setObservaciones("Pastillas Deficientes");
        }
        if (calentamientoFrenos > 350) {
            vehiculo.setEstadoFrenos(false);
            revision.setObservaciones("Sobrecalentamiento de Frenos");
        }

        if (!resultado) {
            revision.aumentarError();
        }
}

    public boolean revisarAgregadosLiviano(VehiculoLiviano vehiculo) {
        return vehiculo.isCinturonSeguridad() && vehiculo.isKitPrimerosAuxilios() && vehiculo.isLlantaEmergencia();
    }
    public boolean revisarAgregadosPesado(VehiculoPesado vehiculo) {
        return vehiculo.isCinturonSeguridad() && vehiculo.isKitPrimerosAuxilios() && vehiculo.isLlantaEmergencia();
    }


    public void revisarAgregadosVehiculo(Vehiculo vehiculo, Revision revision) {
        if(vehiculo instanceof VehiculoLiviano){
            boolean resultado = revisarAgregadosLiviano((VehiculoLiviano) vehiculo);
            if(resultado){
                vehiculo.setEstadoAdicionales(true);
            }else{
                revision.setObservaciones("No tiene los complementos adicionales");
                revision.aumentarError();
            }
        }else{
            boolean resultado = revisarAgregadosPesado((VehiculoPesado) vehiculo);
            if(resultado){
                vehiculo.setEstadoAdicionales(true);
            }else{
                revision.setObservaciones("No tiene los complementos adicionales");
                revision.aumentarError();
            }
        }
    }

    public void realizarRevision(Vehiculo vehiculo, Revision revision) {
        revision.resetar();
        vehiculo.resetear();
        revision.getRevisionPropietario().resetear();
        this.revisarEstadoChasis(vehiculo,revision);
        this.revisarEstadoFrenos(vehiculo,revision);
        this.revisarEstadoLlantas(vehiculo,revision);
        this.revisarLuces(vehiculo,revision);
        this.revisarEstadoTubodeEscape(vehiculo,revision);
        if(!(vehiculo instanceof Moto)){
            this.revisarAgregadosVehiculo(vehiculo,revision);
        }
        this.revisarEstadoMotor(vehiculo,revision);
        revision.setRevisionCompletada(true);
        Ant ant = new Ant(revision);
        ant.generateFine(revision);


    }





}
