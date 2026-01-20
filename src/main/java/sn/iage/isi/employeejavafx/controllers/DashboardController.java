package sn.iage.isi.employeejavafx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sn.iage.isi.employeejavafx.models.User;
import sn.iage.isi.employeejavafx.config.DB;
import sn.iage.isi.employeejavafx.services.impl.UserServiceImpl;
import sn.iage.isi.employeejavafx.services.UserService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    private String currentUser;

    @FXML
    private Button addUserButton;

    @FXML private Button reloadButton;

    @FXML
    private void handleReload() {
        loadUsers(); // recharge la liste depuis la base }
    }
    public void setCurrentUser(String username) {
        this.currentUser = username;
        welcomeLabel.setText("Bienvenue, " + username + " !");
        loadUsers();
    }

    @FXML
    private void handleAddUser() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/addUser.fxml"));
            Parent root = loader.load();

            // Récupérer le contrôleur si besoin
            AddController addController = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Ajouter un utilisateur");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        UserService userService = new UserServiceImpl();
        // Récupérer tous les utilisateurs depuis ta méthode existante
        List<User> userList = userService.getAllUsers();

        // Convertir en ObservableList pour JavaFX
        ObservableList<User> users = FXCollections.observableArrayList(userList);

        // Associer les colonnes aux propriétés de la classe User
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        // Charger les données dans le tableau
        userTable.setItems(users);


    }
}

