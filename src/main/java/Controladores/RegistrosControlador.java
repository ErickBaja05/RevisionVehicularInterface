package Controladores;

import LogicaRevision.Revision;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistrosControlador implements Initializable {

    // ARRAY LIST DE TODAS LAS REVISIONES HECHAS A LO LARGO DEL PROGRAMA
    ArrayList<Revision> revisiones = new ArrayList<>();
    @FXML
    private TextField buscarField;

    @FXML
    private Button menuPrincipalBoton;

    //TableView
    @FXML
    private TableColumn<Revision, String> placaColumna;

    @FXML
    private TableColumn<Revision, String> propietarioColumna;
    @FXML
    private TableColumn<Revision, String> aproboColumna;
    @FXML
    private TableColumn<Revision, String> observacionesColumna;
    @FXML
    private TableColumn<Revision, String> multaColumna;

    @FXML
    private TableView<Revision> tablaRevisiones;

    //Lista observable para guardar la informacion
    private final ObservableList<Revision> observableRevisiones = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Asignando las celdas de propiedades usando expresiones lambda para acceder a los datos anidados en la revisión
        placaColumna.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getRevisionPropietario().getVehiculoPropietario().getPlaca())
        );

        propietarioColumna.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getRevisionPropietario().getIdPropietario())
        );

        aproboColumna.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNumeroErrores() > 0 ? "NO APROBADO" : "APROBADO")
        );

        observacionesColumna.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getObservaciones().toString())
        );

        multaColumna.setCellValueFactory(cellData -> {
            Revision revision = cellData.getValue();
            String multaText = (revision.getNumeroErrores() > 0 && revision.getRevisionPropietario().getMultaNoPasar() != null)
                    ? revision.getRevisionPropietario().getMultaNoPasar().mostrarCostoMulta()
                    : "SIN MULTA";
            return new SimpleStringProperty(multaText);
        });

        // Leyendo los datos del archivo
        try {
            leerRevisiones();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no hallada");
        }

        // Llenando la lista observable
        observableRevisiones.addAll(revisiones);

        // Asignando los elementos a la tabla
        tablaRevisiones.setItems(observableRevisiones);

        //Creando una FilteredList para englobar a la lista observable
        FilteredList<Revision> filteredData = new FilteredList<>(observableRevisiones, b -> true);
        buscarField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(revision -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String placaBusqueda = newValue.toUpperCase();
                if(revision.getRevisionPropietario().getVehiculoPropietario().getPlaca().toUpperCase().indexOf(placaBusqueda) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        //Englobando toda la informacion en una lista ordenada
        SortedList<Revision> datosOrdenados = new SortedList<>(filteredData);
        //Ordenando el TableView
        datosOrdenados.comparatorProperty().bind(tablaRevisiones.comparatorProperty());
        tablaRevisiones.setItems(datosOrdenados);


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

    public void leerRevisiones() throws IOException , ClassNotFoundException {
        Path archivo = Paths.get(System.getProperty("user.dir"), "archivos", "revisiones.txt");

        if (!Files.exists(archivo)) {
            System.out.println("El archivo no existe. No hay revisiones guardadas.");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo.toFile()))) {
            while (true) {
                try {
                    Revision revision = (Revision) ois.readObject();
                    revisiones.add(revision); // Agrega cada objeto leído a la lista
                } catch (EOFException e) {
                    break; // Fin del archivo, salimos del bucle
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer las revisiones: " + e.getMessage());
        }
    }

}
