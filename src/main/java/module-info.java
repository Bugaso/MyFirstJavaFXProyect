module com.bugardo.garagefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.maven.plugin;
    requires javafx.graphics;
    requires java.base;
    requires java.desktop;


    exports com.bugardo.garagefx;
    exports com.bugardo.controllers;
    opens com.bugardo.controllers to javafx.fxml, javafx.base;
    opens com.bugardo.garagefx to javafx.fxml;

}