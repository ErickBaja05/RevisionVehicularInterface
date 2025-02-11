package LogicaRevision;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Propietario {

    private String idPropietario;
    private String nombrePropietario;
    private String telefonoPropietario;
    private String correoPropietario;
    private Vehiculo vehiculoPropietario;

    public Propietario(String idPropietario, String nombrePropietario, String telefonoPropietario, String correoPropietario) throws NullPointerException{
        if((idPropietario!= null && !idPropietario.isEmpty()) && (nombrePropietario != null && !nombrePropietario.isEmpty()) && (telefonoPropietario != null && !telefonoPropietario.isEmpty()) && (correoPropietario != null && !correoPropietario.isEmpty()) ) {
            setIdPropietario(idPropietario);
            this.nombrePropietario = nombrePropietario;
            setTelefonoPropietario(telefonoPropietario);
            setCorreoPropietario(correoPropietario);
            this.vehiculoPropietario = null;
        } else {
            throw new NullPointerException("Los campos del propietario no pueden dejarse vacíos");
        }
    }
    public Propietario() {
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) throws IllegalArgumentException {
        if (validarCedula(idPropietario)){
            this.idPropietario = idPropietario;
        } else{
            throw new IllegalArgumentException("El id del Ingresado no es válido");
        }
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getTelefonoPropietario() {
        return telefonoPropietario;
    }

    public void setTelefonoPropietario(String telefonoPropietario) {
        if(validarTelefono(telefonoPropietario)){
            this.telefonoPropietario = telefonoPropietario;
        } else{
            throw new IllegalArgumentException("El número telefónico ingresado no es válido");
        }
    }

    public String getCorreoPropietario() {
        return correoPropietario;
    }

    public void setCorreoPropietario(String correoPropietario) throws IllegalArgumentException {
        if(validarCorreo(correoPropietario)){
            this.correoPropietario = correoPropietario;
        } else {
            throw new IllegalArgumentException("El correo ingresado no es válido");
        }
    }

    public Vehiculo getVehiculoPropietario() {
        return vehiculoPropietario;
    }

    public void setVehiculoPropietario(Vehiculo vehiculoPropietario) {
        this.vehiculoPropietario = vehiculoPropietario;
    }

    public boolean validarCedula(String cedula) {
        //Algortimo para la verificación de cedula tomado de Legion-Developers por Juan Pinzón

        int suma = 0;
        if (cedula.length() == 9) {
            System.out.println("Ingrese su cedula de 10 digitos");
            return false;
        } else {
            int a[] = new int[cedula.length() / 2];
            int b[] = new int[(cedula.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < cedula.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(cedula.charAt(c)));
                c = c + 2;
                if (i < (cedula.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(cedula.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1))))
                return true;
            else if (suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }


        }
    }
    public boolean validarCorreo (String correo) {
        //Algoritmo de validacion de correo tomado de mailtrap
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(correo);
        return coincidencia.matches();
    }
    public boolean validarTelefono (String telefono) {
        String regex = "^09\\d{8}$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(telefono);
        return coincidencia.matches();
    }

    @Override
    public String toString(){
        return String.format("%s%n%s%n%s%n%s%n",this.idPropietario,this.nombrePropietario,this.telefonoPropietario,this.correoPropietario);
    }
}
