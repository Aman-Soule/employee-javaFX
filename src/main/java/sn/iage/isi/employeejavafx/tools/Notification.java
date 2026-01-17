package sn.iage.isi.employeejavafx.tools;

import javafx.scene.control.Alert;
import javafx.util.Duration;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
public class Notification {
    public static void showNotification(NotificationType notificationType, String titre, String message){
        NotificationType type = notificationType;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(titre);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(2));
    }

    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText("null");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
