package sn.iage.isi.employeejavafx.controllers;

import com.mysql.cj.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sn.iage.isi.employeejavafx.models.User;
import sn.iage.isi.employeejavafx.tools.Notification;
import tray.notification.NotificationType;

import java.io.IOException;

public class AccueilController {

//    @FXML
//    private void dashboard() {
//        //Charger la page Dashboard.fxml
//        try{
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/dashboard.fxml"));
//            Parent root = loader.load();
//            // Récupérer le contrôleur si besoin
//            DashboardController dashboardController = loader.getController();
//            Stage stage = new Stage();
//            stage.setTitle("Dashboard");
//            stage.setScene(new Scene(root));
//            stage.show();
//            Notification.showNotification(NotificationType.SUCCESS, "Succés", "Bienvenue dans votre Dahboard");
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @FXML
    private BorderPane mainPane; // défini dans accueil.fxml

    @FXML
    private void dashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/dashboard.fxml"));
            Parent dashboardView = loader.load();

            // Remplacer le centre du BorderPane par le dashboard
            mainPane.setCenter(dashboardView);

            Notification.showNotification(NotificationType.SUCCESS, "Succès", "Bienvenue dans votre Dashboard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void profile() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/profile.fxml"));
            Parent profileView = loader.load();

            // Remplacer le centre du BorderPane par le dashboard
            mainPane.setCenter(profileView);

            Notification.showNotification(NotificationType.SUCCESS, "Succès", "Bienvenue dans votre Profile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
