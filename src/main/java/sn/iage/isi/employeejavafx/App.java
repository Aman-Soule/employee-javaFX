package sn.iage.isi.employeejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sn.iage.isi.employeejavafx.models.User;
import sn.iage.isi.employeejavafx.services.UserService;
import sn.iage.isi.employeejavafx.services.impl.UserServiceImpl;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent =  FXMLLoader.load(getClass().getResource("/pages/login.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Connexion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUsername("youssou");
        user.setPassword("1234");
        userService.createUser(user);
        launch();
        launch(args);
    }
}