module app {
    requires javafx.controls;
    requires javafx.fxml;


    opens AppRevision to javafx.fxml;
    exports AppRevision;
    opens Controladores to javafx.fxml;
    exports Controladores;
}