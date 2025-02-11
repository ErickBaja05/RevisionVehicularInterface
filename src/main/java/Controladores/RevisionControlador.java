package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;
import LogicaRevision.*;
import javafx.scene.layout.Pane;
import Alert.Message;
import javafx.stage.Stage;

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
    private final String[] posibleCilindrajes = {"100", "200", "300", "400", "400+"};
    private final String[] posibleTransmision ={"Manual", "Automatico"};

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
    private ComboBox<String> estadoLuzDir;

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
    private ToggleGroup kitEmerg;

    @FXML
    private ComboBox<String> lumLuzDel;

    @FXML
    private ComboBox<String> lumLuzNeb;

    @FXML
    private ComboBox<String> lumLuzDir;

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
    private ComboBox<String> tipoMotor;

    @FXML
    private ComboBox<String> tipoVehiculo;

    @FXML
    private ComboBox<String> nCilindraje;

    //Paneles para habilitar las llantas segun los ejes
    @FXML
    private Pane panelLlantas10;

    @FXML
    private Pane panelLlantas12;

    @FXML
    private Pane panelLlantas2;

    @FXML
    private Pane panelLlantas4;

    @FXML
    private Pane panelLlantas6;

    @FXML
    private Pane panelLlantas8;

    @FXML
    private Tab datosAutoI;

    @FXML
    private Tab datosAuto2;
    //Varios
    @FXML
    private TextField marcaField;
    @FXML
    private TextField modeloField;
    @FXML
    private TextField colorField;
    @FXML
    private ComboBox<String> tipoTransmision;
    @FXML
    private TextField capCargaField;
    @FXML
    private Pane panelAgregados;

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

    // Radio Button



    // Botones

    @FXML
    private Button btnInfoAuto1;

@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Agregando las opciones necesarias para las provincias

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
        estadoLuzDir.getItems().addAll(estadosDeLuz);
        estadoLuzNeb.getItems().addAll(estadosDeLuz);
        //Agregando las opciones para el tipo de motor
        tipoMotor.getItems().addAll(tiposDeMotor);

        //Agregando las opciones de luminosidad para las luces
        lumLuzDel.getItems().addAll(estadosGenerales);
        lumLuzTras.getItems().addAll(estadosGenerales);
        lumLuzDir.getItems().addAll(estadosGenerales);
        lumLuzNeb.getItems().addAll(estadosGenerales);

        //Agregando las opciones para elementos varios del vehiculo
        nCilindraje.getItems().addAll(posibleCilindrajes);
        tipoTransmision.getItems().addAll(posibleTransmision);
        nEjes.setDisable(true);
    }
    //SECCION PROPIETARIO

    //Eventos de asignacion y control en la pestaña de la información del usuario
    Propietario propietarioVehiculo;
    @FXML
    void ingresarPropietario(ActionEvent event) {
        Message msgError = new Message();
        Message msgInfor = new Message();
        try{
            propietarioVehiculo = new Propietario(cedulaField.getText(),nombreField.getText(),telefonoField.getText(),correoField.getText());
            ManagerPropietario.setPropietario(propietarioVehiculo);
            msgInfor.setMessage("Informacion guardada exitosamente");
            datosAutoI.setDisable(false);
        } catch (IllegalArgumentException e){
            msgError.setMessage("Algún valor ingresado como: cédula, teléfono, o correo es inválido.\nIntente nuevamente.");

        } catch (NullPointerException e){
            e.printStackTrace();
            msgError.setMessage("Los campos del propietario no pueden dejarse vacíos");
        }
    }
    //SECCION DATOS VEHICULO I

    //Eventos de asignacion y control en la pestaña de Datos del Vehículo I
    @FXML
    void elegirProvincia(ActionEvent event) {
        tipoVehiculo.setDisable(false);
    }
    @FXML
    void elegirTipoVehiculo(ActionEvent event) {
        btnInfoAuto1.setDisable(false);
        placaField.setDisable(false);
        String tipoVehiculoElegido = tipoVehiculo.getSelectionModel().getSelectedItem();
        if(tipoVehiculoElegido.equals("Moto")){
            nEjes.setDisable(true);
            panelLlantas2.setDisable(false);
            nCilindraje.setDisable(false);
            //Deshabilitando campos innecesarios para la moto
            tipoTransmision.setDisable(true);
            capCargaField.setDisable(true);
            panelAgregados.setDisable(true);
        } else if (tipoVehiculoElegido.equals("Liviano")){
            nEjes.setDisable(true);
            panelLlantas2.setDisable(false);
            panelLlantas4.setDisable(false);
            panelAgregados.setDisable(false);
            tipoTransmision.setDisable(false);
            //Deshabilitando campos innecesarios para el auto
            capCargaField.setDisable(true);
            nCilindraje.setDisable(true);
        } else if (tipoVehiculoElegido.equals("Pesado")){
            nEjes.setDisable(false);
            panelLlantas2.setDisable(true);
            panelLlantas4.setDisable(true);
            panelAgregados.setDisable(false);
            capCargaField.setDisable(false);
            //Deshabilitando campos innecesarios para el Pesado
            nCilindraje.setDisable(true);
            tipoTransmision.setDisable(true);

        }
    }
    @FXML
    void elegirNEjes(ActionEvent event) {
        int ejes = nEjes.getSelectionModel().getSelectedItem();
        switch(ejes){
            case 2: {
                panelLlantas2.setDisable(false);
                panelLlantas4.setDisable(false);
                panelLlantas6.setDisable(true);
                panelLlantas8.setDisable(true);
                panelLlantas10.setDisable(true);
                panelLlantas12.setDisable(true);

                break;
            } case 3: {
                panelLlantas2.setDisable(false);
                panelLlantas4.setDisable(false);
                panelLlantas6.setDisable(false);
                panelLlantas8.setDisable(true);
                panelLlantas10.setDisable(true);
                panelLlantas12.setDisable(true);
                break;
            } case 4: {
                panelLlantas2.setDisable(false);
                panelLlantas4.setDisable(false);
                panelLlantas6.setDisable(false);
                panelLlantas8.setDisable(false);
                panelLlantas10.setDisable(true);
                panelLlantas12.setDisable(true);
                break;
            } case 5: {
                panelLlantas2.setDisable(false);
                panelLlantas4.setDisable(false);
                panelLlantas6.setDisable(false);
                panelLlantas8.setDisable(false);
                panelLlantas10.setDisable(false);
                panelLlantas12.setDisable(true);
                break;
            } case 6: {
                panelLlantas2.setDisable(false);
                panelLlantas4.setDisable(false);
                panelLlantas6.setDisable(false);
                panelLlantas8.setDisable(false);
                panelLlantas10.setDisable(false);
                panelLlantas12.setDisable(false);
            }

        }

    }






    //SECCION RESULTADOS
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

    @FXML
    void guardarInfoAuto1(ActionEvent event) {
        String tipoVehiculoElegido = tipoVehiculo.getSelectionModel().getSelectedItem();
        String cilindrajeElegido = nCilindraje.getSelectionModel().getSelectedItem();
        RadioButton tieneLlantaEmergencia = (RadioButton) LantasSeg.getSelectedToggle();
        RadioButton tieneFugasMotor = (RadioButton) fugas.getSelectedToggle();
        RadioButton tieneKit = (RadioButton) kitEmerg.getSelectedToggle();
        RadioButton estadoCinturones = (RadioButton) Cinturon.getSelectedToggle();
        Message msgError = new Message();
        Message msgConfirmacion = new Message();
        if(tipoVehiculoElegido.equals("Moto")){
            try{
                System.out.println(estadoLuzDel.getSelectionModel().getSelectedItem());
                Moto motoUsuario = new Moto(1,colorField.getText(),marcaField.getText(),modeloField.getText(),placaField.getText(),2,2,ManagerPropietario.getPropietario(),2015,Integer.parseInt(cilindrajeElegido));
                motoUsuario.getLlantas()[0].setEstadoLlanta(labrado1.getSelectionModel().getSelectedItem());
                motoUsuario.getLlantas()[1].setEstadoLlanta(labrado2.getSelectionModel().getSelectedItem());
                motoUsuario.getLlantas()[0].setPresionLlanta(presionField1.getText());
                motoUsuario.getLlantas()[1].setPresionLlanta(presionField2.getText());
                motoUsuario.getLuces()[0].setEstadoLuz(estadoLuzDel.getSelectionModel().getSelectedItem());
                motoUsuario.getLuces()[0].setIntensidadLuz(lumLuzDel.getSelectionModel().getSelectedItem());
                motoUsuario.getLuces()[1].setEstadoLuz(estadoLuzTras.getSelectionModel().getSelectedItem());
                motoUsuario.getLuces()[1].setIntensidadLuz(lumLuzTras.getSelectionModel().getSelectedItem());
                motoUsuario.getLuces()[2].setEstadoLuz(estadoLuzDir.getSelectionModel().getSelectedItem());
                motoUsuario.getLuces()[2].setIntensidadLuz(lumLuzDir.getSelectionModel().getSelectedItem());
                motoUsuario.getLuces()[3].setEstadoLuz(estadoLuzNeb.getSelectionModel().getSelectedItem());
                motoUsuario.getLuces()[3].setIntensidadLuz(lumLuzNeb.getSelectionModel().getSelectedItem());
                motoUsuario.getMotor().setTipoMotor(tipoMotor.getSelectionModel().getSelectedItem());
                motoUsuario.getMotor().setTemperaturaMotor(tempMotField.getText());
                motoUsuario.getMotor().setFugaMotor(tieneFugasMotor.getText());
                ManagerPropietario.getPropietario().setVehiculoPropietario(motoUsuario);
                msgConfirmacion.setMessage("Informacion guardada exitosamente");
                datosAuto2.setDisable(false);
            }catch (IllegalArgumentException e){
                msgError.setMessage("Algun dato del vehiculo como la placa esta no es valido, revise nuevamente");

            }catch (NullPointerException e){
                msgError.setMessage("Debe llenar todos los datos para continuar");
            }

        }else if(tipoVehiculoElegido.equals("Liviano")){
            try {
                VehiculoLiviano vehiculoUsuario = new VehiculoLiviano(1,colorField.getText(),marcaField.getText(),modeloField.getText(),placaField.getText(),4,4,ManagerPropietario.getPropietario(),2015, tieneLlantaEmergencia.getText(),tipoTransmision.getValue(),estadoCinturones.getText(),tieneKit.getText());
                vehiculoUsuario.getLlantas()[0].setEstadoLlanta(labrado1.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLlantas()[1].setEstadoLlanta(labrado2.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLlantas()[2].setEstadoLlanta(labrado3.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLlantas()[3].setEstadoLlanta(labrado4.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLlantas()[0].setPresionLlanta(presionField1.getText());
                vehiculoUsuario.getLlantas()[1].setPresionLlanta(presionField2.getText());
                vehiculoUsuario.getLlantas()[2].setPresionLlanta(presionField3.getText());
                vehiculoUsuario.getLlantas()[3].setPresionLlanta(presionField4.getText());
                vehiculoUsuario.getLuces()[0].setEstadoLuz(estadoLuzDel.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[0].setIntensidadLuz(lumLuzDel.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[1].setEstadoLuz(estadoLuzTras.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[1].setIntensidadLuz(lumLuzTras.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[2].setEstadoLuz(estadoLuzDir.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[2].setIntensidadLuz(lumLuzDir.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[3].setEstadoLuz(estadoLuzNeb.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[3].setIntensidadLuz(lumLuzNeb.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getMotor().setTipoMotor(tipoMotor.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getMotor().setTemperaturaMotor(tempMotField.getText());
                vehiculoUsuario.getMotor().setFugaMotor(tieneFugasMotor.getText());
                ManagerPropietario.getPropietario().setVehiculoPropietario(vehiculoUsuario);
                datosAuto2.setDisable(false);
                msgConfirmacion.setMessage("Informacion guardada exitosamente");
            }catch (IllegalArgumentException e){
                msgError.setMessage("Algun dato del vehiculo como la placa esta no es valido, revise nuevamente");
            }catch (NullPointerException e){
                e.printStackTrace();
                msgError.setMessage("Debe llenar todos los datos para continuar");
            }
        }else{
            try {
                int ejesSeleccionados = nEjes.getSelectionModel().getSelectedItem();
                VehiculoPesado vehiculoUsuario = null;
                switch (ejesSeleccionados) {
                    case 2:
                        VehiculoPesado op1 = new VehiculoPesado(1,colorField.getText(),marcaField.getText(),modeloField.getText(),placaField.getText(),4,4,ManagerPropietario.getPropietario(),2015,Integer.parseInt(capCargaField.getText()),tieneLlantaEmergencia.getText(),estadoCinturones.getText(),tieneKit.getText());
                        op1.getLlantas()[0].setEstadoLlanta(labrado1.getSelectionModel().getSelectedItem());
                        op1.getLlantas()[1].setEstadoLlanta(labrado2.getSelectionModel().getSelectedItem());
                        op1.getLlantas()[2].setEstadoLlanta(labrado3.getSelectionModel().getSelectedItem());
                        op1.getLlantas()[3].setEstadoLlanta(labrado4.getSelectionModel().getSelectedItem());
                        op1.getLlantas()[0].setPresionLlanta(presionField1.getText());
                        op1.getLlantas()[1].setPresionLlanta(presionField2.getText());
                        op1.getLlantas()[2].setPresionLlanta(presionField3.getText());
                        op1.getLlantas()[3].setPresionLlanta(presionField4.getText());
                        vehiculoUsuario = op1;
                        break;
                    case 3:
                        VehiculoPesado op2 = new VehiculoPesado(1,colorField.getText(),marcaField.getText(),modeloField.getText(),placaField.getText(),6,6,ManagerPropietario.getPropietario(),2015,Integer.parseInt(capCargaField.getText()),tieneLlantaEmergencia.getText(),estadoCinturones.getText(),tieneKit.getText());
                        op2.getLlantas()[0].setEstadoLlanta(labrado1.getSelectionModel().getSelectedItem());
                        op2.getLlantas()[1].setEstadoLlanta(labrado2.getSelectionModel().getSelectedItem());
                        op2.getLlantas()[2].setEstadoLlanta(labrado3.getSelectionModel().getSelectedItem());
                        op2.getLlantas()[3].setEstadoLlanta(labrado4.getSelectionModel().getSelectedItem());
                        op2.getLlantas()[4].setEstadoLlanta(labrado5.getSelectionModel().getSelectedItem());
                        op2.getLlantas()[5].setEstadoLlanta(labrado6.getSelectionModel().getSelectedItem());
                        op2.getLlantas()[0].setPresionLlanta(presionField1.getText());
                        op2.getLlantas()[1].setPresionLlanta(presionField2.getText());
                        op2.getLlantas()[2].setPresionLlanta(presionField3.getText());
                        op2.getLlantas()[3].setPresionLlanta(presionField4.getText());
                        op2.getLlantas()[4].setPresionLlanta(presionField5.getText());
                        op2.getLlantas()[5].setPresionLlanta(presionField6.getText());
                        vehiculoUsuario = op2;
                        break;
                    case 4:
                        VehiculoPesado op3 = new VehiculoPesado(1,colorField.getText(),marcaField.getText(),modeloField.getText(),placaField.getText(),8,8,ManagerPropietario.getPropietario(),2015,Integer.parseInt(capCargaField.getText()),tieneLlantaEmergencia.getText(),estadoCinturones.getText(),tieneKit.getText());
                        op3.getLlantas()[0].setEstadoLlanta(labrado1.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[1].setEstadoLlanta(labrado2.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[2].setEstadoLlanta(labrado3.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[3].setEstadoLlanta(labrado4.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[4].setEstadoLlanta(labrado5.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[5].setEstadoLlanta(labrado6.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[6].setEstadoLlanta(labrado7.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[7].setEstadoLlanta(labrado8.getSelectionModel().getSelectedItem());
                        op3.getLlantas()[0].setPresionLlanta(presionField1.getText());
                        op3.getLlantas()[1].setPresionLlanta(presionField2.getText());
                        op3.getLlantas()[2].setPresionLlanta(presionField3.getText());
                        op3.getLlantas()[3].setPresionLlanta(presionField4.getText());
                        op3.getLlantas()[4].setPresionLlanta(presionField5.getText());
                        op3.getLlantas()[5].setPresionLlanta(presionField6.getText());
                        op3.getLlantas()[6].setPresionLlanta(presionField7.getText());
                        op3.getLlantas()[7].setPresionLlanta(presionField8.getText());
                        vehiculoUsuario = op3;
                        break;
                    case 5:
                        VehiculoPesado op4 = new VehiculoPesado(1,colorField.getText(),marcaField.getText(),modeloField.getText(),placaField.getText(),10,10,ManagerPropietario.getPropietario(),2015,Integer.parseInt(capCargaField.getText()),tieneLlantaEmergencia.getText(),estadoCinturones.getText(),tieneKit.getText());
                        op4.getLlantas()[0].setEstadoLlanta(labrado1.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[1].setEstadoLlanta(labrado2.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[2].setEstadoLlanta(labrado3.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[3].setEstadoLlanta(labrado4.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[4].setEstadoLlanta(labrado5.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[5].setEstadoLlanta(labrado6.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[6].setEstadoLlanta(labrado7.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[7].setEstadoLlanta(labrado8.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[8].setEstadoLlanta(labrado9.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[9].setEstadoLlanta(labrado10.getSelectionModel().getSelectedItem());
                        op4.getLlantas()[0].setPresionLlanta(presionField1.getText());
                        op4.getLlantas()[1].setPresionLlanta(presionField2.getText());
                        op4.getLlantas()[2].setPresionLlanta(presionField3.getText());
                        op4.getLlantas()[3].setPresionLlanta(presionField4.getText());
                        op4.getLlantas()[4].setPresionLlanta(presionField5.getText());
                        op4.getLlantas()[5].setPresionLlanta(presionField6.getText());
                        op4.getLlantas()[6].setPresionLlanta(presionField7.getText());
                        op4.getLlantas()[7].setPresionLlanta(presionField8.getText());
                        op4.getLlantas()[8].setPresionLlanta(presionField9.getText());
                        op4.getLlantas()[9].setPresionLlanta(presionField10.getText());
                        vehiculoUsuario = op4;
                        break;
                    case 6:
                        VehiculoPesado op5 = new VehiculoPesado(1,colorField.getText(),marcaField.getText(),modeloField.getText(),placaField.getText(),12,12,ManagerPropietario.getPropietario(),2015,Integer.parseInt(capCargaField.getText()),tieneLlantaEmergencia.getText(),estadoCinturones.getText(),tieneKit.getText());
                        op5.getLlantas()[0].setEstadoLlanta(labrado1.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[1].setEstadoLlanta(labrado2.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[2].setEstadoLlanta(labrado3.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[3].setEstadoLlanta(labrado4.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[4].setEstadoLlanta(labrado5.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[5].setEstadoLlanta(labrado6.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[6].setEstadoLlanta(labrado7.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[7].setEstadoLlanta(labrado8.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[8].setEstadoLlanta(labrado9.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[9].setEstadoLlanta(labrado10.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[10].setEstadoLlanta(labrado11.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[11].setEstadoLlanta(labrado12.getSelectionModel().getSelectedItem());
                        op5.getLlantas()[0].setPresionLlanta(presionField1.getText());
                        op5.getLlantas()[1].setPresionLlanta(presionField2.getText());
                        op5.getLlantas()[2].setPresionLlanta(presionField3.getText());
                        op5.getLlantas()[3].setPresionLlanta(presionField4.getText());
                        op5.getLlantas()[4].setPresionLlanta(presionField5.getText());
                        op5.getLlantas()[5].setPresionLlanta(presionField6.getText());
                        op5.getLlantas()[6].setPresionLlanta(presionField7.getText());
                        op5.getLlantas()[7].setPresionLlanta(presionField8.getText());
                        op5.getLlantas()[8].setPresionLlanta(presionField9.getText());
                        op5.getLlantas()[9].setPresionLlanta(presionField10.getText());
                        op5.getLlantas()[10].setPresionLlanta(presionField10.getText());
                        op5.getLlantas()[11].setPresionLlanta(presionField11.getText());
                        vehiculoUsuario = op5;
                        break;
                }
                vehiculoUsuario.getLuces()[0].setEstadoLuz(estadoLuzDel.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[0].setIntensidadLuz(lumLuzDel.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[1].setEstadoLuz(estadoLuzTras.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[1].setIntensidadLuz(lumLuzTras.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[2].setEstadoLuz(estadoLuzDir.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[2].setIntensidadLuz(lumLuzDir.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[3].setEstadoLuz(estadoLuzNeb.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getLuces()[3].setIntensidadLuz(lumLuzNeb.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getMotor().setTipoMotor(tipoMotor.getSelectionModel().getSelectedItem());
                vehiculoUsuario.getMotor().setTemperaturaMotor(tempMotField.getText());
                vehiculoUsuario.getMotor().setFugaMotor(tieneFugasMotor.getText());
                ManagerPropietario.getPropietario().setVehiculoPropietario(vehiculoUsuario);
                datosAuto2.setDisable(false);
                msgConfirmacion.setMessage("Informacion guardada exitosamente");
            }catch (IllegalArgumentException e){
                msgError.setMessage("Algun dato del vehiculo como la placa esta no es valido, revise nuevamente");
            }catch (NullPointerException e){
                e.printStackTrace();
                msgError.setMessage("Debe llenar todos los datos para continuar");
            }
        }


        System.out.println(ManagerPropietario.getPropietario());
        System.out.println(ManagerPropietario.getPropietario().getVehiculoPropietario());


    }
}