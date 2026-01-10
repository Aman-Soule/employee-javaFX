package sn.iage.isi.employeejavafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import sn.iage.isi.employeejavafx.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleSave() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs !");
            alert.showAndWait();
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Utilisateur ajouté avec succès !");
            alert.showAndWait();

            // Fermer la fenêtre après ajout
            usernameField.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erreur lors de l'ajout de l'utilisateur !");
            alert.showAndWait();
        }
    }
}

