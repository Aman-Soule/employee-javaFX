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
import sn.iage.isi.employeejavafx.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
        ObservableList<User> users = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        userTable.setItems(users);
    }
}

