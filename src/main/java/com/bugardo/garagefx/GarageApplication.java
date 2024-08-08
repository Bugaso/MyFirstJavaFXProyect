package com.bugardo.garagefx;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GarageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GarageApplication.class.getResource("main-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            //scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

            stage.setTitle("Garage App");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(1040);
            stage.setHeight(800);
            stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}