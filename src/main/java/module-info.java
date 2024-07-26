module com.bugardo.garagefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;


    exports com.bugardo.garagefx;
    exports com.bugardo.controllers;

    opens com.bugardo.controllers to javafx.fxml, javafx.base;
    opens com.bugardo.garagefx to javafx.fxml;
}