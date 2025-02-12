package AppRevision;
// DESAROLLADO POR:
/*
* BAJAÑA  ALEXIS
* CAMINO ADRIAN
* CARCELEN JOSUE
* TIPANTUñA FRANCIEL
* */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppRevision extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AppRevision/Login/Login.fxml"));
            Scene scene = new Scene(root, 800, 600);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
