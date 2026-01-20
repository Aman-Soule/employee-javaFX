package sn.iage.isi.employeejavafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import sn.iage.isi.employeejavafx.models.User;
import sn.iage.isi.employeejavafx.services.UserService;
import sn.iage.isi.employeejavafx.services.impl.UserServiceImpl;
import sn.iage.isi.employeejavafx.tools.Utils;
import sn.iage.isi.employeejavafx.config.DB;
import sn.iage.isi.employeejavafx.controllers.AddController;



import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleSave() {
        try {
            // Récupérer les valeurs des champs
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs !");
                alert.showAndWait();
                return;
            }

            // Créer un nouvel utilisateur
            UserService userService = new UserServiceImpl();
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);

            // Ajouter l'utilisateur via ton service
            userService.createUser(newUser); // Assure-toi que userService est bien instancié

//            // Recharger le tableau pour afficher le nouvel utilisateur
//            loadUsers();

            // Optionnel : vider les champs après ajout
            usernameField.clear();
            passwordField.clear();
            usernameField.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

