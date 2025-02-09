package Controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RevisionControlador implements Initializable {

    @FXML
    private ComboBox<String> provinciasBox;
    private final String[] provincias = {
            "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi",
            "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja",
            "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana",
            "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas",
            "Sucumbíos", "Tungurahua", "Zamora Chinchipe"
    };


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        provinciasBox.getItems().addAll(provincias);
    }
}