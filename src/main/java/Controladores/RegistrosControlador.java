package Controladores;

import LogicaRevision.Revision;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RegistrosControlador {

    // ARRAY LIST DE TODAS LAS REVISIONES HECHAS A LO LARGO DEL PROGRAMA
    ArrayList<Revision> revisiones = new ArrayList<>();
    @FXML
    private TextField buscar;

    @FXML
    private Button cargarResultados;
    @FXML
    private Button menuPrincipalBoton;

    @FXML
    void cargarArchivo(ActionEvent event) throws IOException, ClassNotFoundException {
        leerRevisiones();
        for(Revision revision : revisiones) {
            System.out.println(revision);
        }
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
