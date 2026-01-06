module sn.iage.isi.employeejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens sn.iage.isi.employeejavafx to javafx.fxml;
    exports sn.iage.isi.employeejavafx;

    exports sn.iage.isi.employeejavafx.controllers;
    opens sn.iage.isi.employeejavafx.controllers to javafx.fxml;
}