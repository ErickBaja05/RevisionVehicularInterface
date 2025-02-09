package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrosControlador {

    @FXML
    private TextField buscar;

    @FXML
    private Button cargarResultados;
    @FXML
    private Button menuPrincipalBoton;

    @FXML
    void cargarArchivo(ActionEvent event) {
        buscar.setDisable(false);
    }

    @FXML
    void buscar(ActionEvent event) {
        System.out.println("HOLA");
    }

    @FXML
    void irMenuPrincipal(ActionEvent event) {
        this.menuPrincipalBoton.getScene().getWindow().hide();
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/AppRevision/MenuPrincipal/MenuPrincipal.fxml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        home.setResizable(false);
        home.setScene(new Scene(root, 800, 600));
        home.show();
    }

}
