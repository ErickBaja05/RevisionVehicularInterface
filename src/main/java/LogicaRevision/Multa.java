package LogicaRevision;



import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Multa implements Serializable {
    private static int contadorMultas = 1;
    private final int idMulta;
    private double costoMulta;
    private final LocalDate fechaMulta;


    private String typeFine;
    public Multa() {
        this.idMulta = contadorMultas;
        this.typeFine = "SIN MULTAS";
        this.costoMulta = 0.0;
        this.fechaMulta = LocalDate.now();
        contadorMultas++;
    }
    public void setTipoMulta()
    {
        this.typeFine = "MULTA POR NO APROBACION DEL PROCESO DE REVISION";
    }
    public void setCostoMulta(double penalty)
    {
        costoMulta = penalty;
    }
    public int getIdMulta() {
        return idMulta;
    }
    public String getTipoMulta() {
        return this.typeFine;
    }
    public double getCostoMulta() {
        return this.costoMulta;
    }
    public String getFechaMulta() {
        //This object and method will set the date in the right format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.fechaMulta.format(formatter);
    }

    // Returns a String with the explicit information of the fine
    public String showFine(){
        StringBuilder multa = new StringBuilder();
        multa.append("Multa N ").append(this.idMulta).append("\n");
        multa.append("Fecha emision: ").append(this.getFechaMulta()).append("\n");
        multa.append("Tipo de Multa: ").append(this.getTipoMulta()).append("\n");
        multa.append("Valor a Pagar: ").append(this.getCostoMulta()).append("\n");
        return multa.toString();
    }
}