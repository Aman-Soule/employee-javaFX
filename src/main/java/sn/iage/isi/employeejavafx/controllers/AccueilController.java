package sn.iage.isi.employeejavafx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sn.iage.isi.employeejavafx.tools.Notification;
import tray.notification.NotificationType;

import java.io.IOException;

public class AccueilController {

    @FXML
    private void dashboard() {
        //Charger la page Dashboard.fxml
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/dashboard.fxml"));
            Parent root = loader.load();
            // Récupérer le contrôleur si besoin
            DashboardController dashboardController = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(new Scene(root));
            stage.show();
            Notification.showNotification(NotificationType.SUCCESS, "Succés", "Bienvenue dans votre Dahboard");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
