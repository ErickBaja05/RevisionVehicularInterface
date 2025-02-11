package Alert;

import javafx.scene.control.Alert;

public class Message {
    public void setMessage(String message,String title,String tipo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(tipo);
        alert.setContentText(message);
        alert.show();
    }
    public void setErrorMessage(String message,String title, String tipo) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(tipo);
        alert.setContentText(message);
        alert.show();
    }
}
