package sn.iage.isi.employeejavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sn.iage.isi.employeejavafx.config.DB;
import javafx.event.ActionEvent;
import sn.iage.isi.employeejavafx.models.User;
import sn.iage.isi.employeejavafx.services.UserService;
import sn.iage.isi.employeejavafx.services.impl.UserServiceImpl;
import sn.iage.isi.employeejavafx.tools.Notification;
import sn.iage.isi.employeejavafx.tools.Outils;
import sn.iage.isi.employeejavafx.tools.Utils;
import tray.notification.NotificationType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    private UserService userService = new UserServiceImpl();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.isEmpty() || password.isEmpty()){
            //Notification.showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez remplir tous les champs");
            Notification.showNotification(NotificationType.ERROR, "Erreur", "Veuillez remplir tous les champs");
        } else {
            try {
                User user = userService.getUserByUsername(username);
                if (user != null && Utils.checkPassword(password, user.getPassword())) {
                    Outils.load(event, "Accueil", "/pages/accueil.fxml");
                    Notification.showNotification(NotificationType.SUCCESS, "Succés", "Bienvenue, " + user.getUsername());
                } else
                    Notification.showNotification(NotificationType.ERROR, "Erreur", "Username et/ou Password incorrects");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
