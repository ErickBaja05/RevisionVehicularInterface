package Alert;

import javafx.scene.control.Alert;

public class Message {
    public void setMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
