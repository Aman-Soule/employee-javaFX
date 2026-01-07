module sn.iage.isi.employeejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;


    opens sn.iage.isi.employeejavafx to javafx.fxml;
    exports sn.iage.isi.employeejavafx;

    exports sn.iage.isi.employeejavafx.controllers;
    opens sn.iage.isi.employeejavafx.controllers to javafx.fxml;

    exports sn.iage.isi.employeejavafx.models;
    opens sn.iage.isi.employeejavafx.models to javafx.fxml;
}