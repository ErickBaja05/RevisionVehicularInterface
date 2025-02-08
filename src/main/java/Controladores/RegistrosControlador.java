package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrosControlador {

    @FXML
    private TextField buscar;

    @FXML
    private Button cargarResultados;

    @FXML
    void cargarArchivo(ActionEvent event) {
        buscar.setDisable(false);
    }

    @FXML
    void buscar(ActionEvent event) {
        System.out.println("HOLA");
    }

}
