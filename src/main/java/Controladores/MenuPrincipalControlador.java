package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuPrincipalControlador {

    @FXML
    private Button regBoton;

    @FXML
    private Button revBoton;

    @FXML
    void irRegistros(ActionEvent event) {
        this.revBoton.getScene().getWindow().hide();
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/AppRevision/Registros/Registros.fxml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        home.setScene(new Scene(root, 800, 600));
        home.show();

    }

    @FXML
    void irRevision(ActionEvent event) {
        this.revBoton.getScene().getWindow().hide();
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/AppRevision/Revision/Revision.fxml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        home.setScene(new Scene(root, 800, 600));
        home.show();

    }

}
