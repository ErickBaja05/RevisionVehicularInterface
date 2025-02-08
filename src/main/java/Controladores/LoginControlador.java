package Controladores;

import Alert.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class LoginControlador {

    @FXML
    private Button login;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField usuario;

    Message msg = new Message();

    @FXML
    void enLogin(ActionEvent event) {

        String usuarioDefecto ="admin";
        String passdDefecto ="Rev2025";

        String usuario = this.usuario.getText();
        String pass = this.pass.getText();

        boolean ingresoValido = false;
        if((usuario.equals(usuarioDefecto)) && (pass.equals(passdDefecto))){
            ingresoValido = true;
            this.login.getScene().getWindow().hide();
            Stage home = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/AppRevision/MenuPrincipal/MenuPrincipal.fxml"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            home.setScene(new Scene(root, 800, 600));
            home.show();
            msg.setMessage("Ingreso Correcto, ¡Bienvenido!");
        } else {
            msg.setMessage("Credenciales Incorrectas, intente nuevamente");
        }

    }

}
