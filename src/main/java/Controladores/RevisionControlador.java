package Controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import LogicaRevision.*;

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

    private final String[] tiposDeVehiculo ={"Liviano", "Pesado","Moto"};
    private final String[] estadosDeLuz = {"Ideal", "Aceptable", "Quemadas"};
    private final Integer[] posiblesEjes = {2,3,4,5,6};
    private final String[] estadosGenerales = {"Ideal", "Aceptable", "Deficiente"};
    private final String[] tiposDeMotor ={"Electrico", "Gasolina", "Diesel"};

    @FXML
    private ToggleGroup Alineacion;

    @FXML
    private ToggleGroup Pastillas;

    @FXML
    private ToggleGroup Cinturon;
    @FXML
    private Button continuacionLlenado;

    @FXML
    private ToggleGroup Corrrosion;
    @FXML
    private TextField cedulaField;

    @FXML
    private TextField correoField;
    @FXML
    private Button datosDuenio;

    @FXML
    private TextField emisionField;
    @FXML
    private Button escrituraInfo;

    @FXML
    private ToggleGroup LantasSeg;

    @FXML
    private ToggleGroup Suspension;

    @FXML
    private ComboBox<String> estadoLuzDel;

    @FXML
    private ComboBox<String> estadoLuzNeb;

    @FXML
    private ComboBox<String> estadoLuzPar;

    @FXML
    private ComboBox<String> estadoLuzTras;

    @FXML
    private ToggleGroup fugas;

    @FXML
    private ComboBox<String> labrado1;

    @FXML
    private ComboBox<String> labrado10;

    @FXML
    private ComboBox<String> labrado11;

    @FXML
    private ComboBox<String> labrado12;

    @FXML
    private ComboBox<String> labrado2;

    @FXML
    private ComboBox<String> labrado3;

    @FXML
    private ComboBox<String> labrado4;

    @FXML
    private ComboBox<String> labrado5;

    @FXML
    private ComboBox<String> labrado6;

    @FXML
    private ComboBox<String> labrado7;

    @FXML
    private ComboBox<String> labrado8;

    @FXML
    private ComboBox<String> labrado9;

    @FXML
    private ToggleGroup loquedijo;

    @FXML
    private ComboBox<String> lumLuzDel;

    @FXML
    private ComboBox<String> lumLuzNeb;

    @FXML
    private ComboBox<String> lumLuzPar;

    @FXML
    private ComboBox<String> lumLuzTras;

    @FXML
    private ComboBox<Integer> nEjes;
    @FXML
    private TextField nombreField;

    @FXML
    private TextField placaField;

    @FXML
    private TextField presionField1;

    @FXML
    private TextField presionField10;

    @FXML
    private TextField presionField11;

    @FXML
    private TextField presionField12;

    @FXML
    private TextField presionField2;

    @FXML
    private TextField presionField3;

    @FXML
    private TextField presionField4;

    @FXML
    private TextField presionField5;

    @FXML
    private TextField presionField6;

    @FXML
    private TextField presionField7;

    @FXML
    private TextField presionField8;

    @FXML
    private TextField presionField9;

    @FXML
    private TextField tempMotField;

    @FXML
    private TextField tempFrenoField;

    @FXML
    private TextField telefonoField;

    @FXML
    private ChoiceBox<String> tipoMotor;

    @FXML
    private ComboBox<String> tipoVehiculo;

    @FXML
    private Button validacionProp;

    //Labels de los resultados
    @FXML
    private Label nombreRes;
    @FXML
    private Label cedulaRes;
    @FXML
    private Label tipoVehiculoRes;
    @FXML
    private Label placaRes;
    @FXML
    private Label motorRes;
    @FXML
    private Label llantasRes;
    @FXML
    private Label lucesRes;
    @FXML
    private Label chasisRes;
    @FXML
    private Label frenosRes;
    @FXML
    private Label tuboEscapeRes;
    @FXML
    private Label agregadosRes;

    //Botones de Resultado
    @FXML
    private Button resultadosBoton;
    @FXML
    private Button menuPrincipalBoton;

@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Agregando las opciones necesarias para las provincias
        provinciasBox.getItems().addAll(provincias);
        //Agregando las opciones para el tipo de vehiculo
        tipoVehiculo.getItems().addAll(tiposDeVehiculo);
        //Agregando las opcion para el número de ejes
        nEjes.getItems().addAll(posiblesEjes);
        //Agregando las opciones de labrado para las llantas
        labrado1.getItems().addAll(estadosGenerales);
        labrado2.getItems().addAll(estadosGenerales);
        labrado3.getItems().addAll(estadosGenerales);
        labrado4.getItems().addAll(estadosGenerales);
        labrado5.getItems().addAll(estadosGenerales);
        labrado6.getItems().addAll(estadosGenerales);
        labrado7.getItems().addAll(estadosGenerales);
        labrado8.getItems().addAll(estadosGenerales);
        labrado9.getItems().addAll(estadosGenerales);
        labrado10.getItems().addAll(estadosGenerales);
        labrado11.getItems().addAll(estadosGenerales);
        labrado12.getItems().addAll(estadosGenerales);
        //Agregando las opciones de estados para las luces
        estadoLuzDel.getItems().addAll(estadosDeLuz);
        estadoLuzTras.getItems().addAll(estadosDeLuz);
        estadoLuzPar.getItems().addAll(estadosDeLuz);
        estadoLuzNeb.getItems().addAll(estadosDeLuz);
        //Agregando las opciones para el tipo de motor
        tipoMotor.getItems().addAll(tiposDeMotor);

        //Agregando las opciones de luminosidad para las luces
        lumLuzDel.getItems().addAll(estadosGenerales);
        lumLuzTras.getItems().addAll(estadosGenerales);
        lumLuzPar.getItems().addAll(estadosGenerales);
        lumLuzNeb.getItems().addAll(estadosGenerales);

    }
}