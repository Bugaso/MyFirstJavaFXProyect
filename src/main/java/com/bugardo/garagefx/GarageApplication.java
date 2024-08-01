package com.bugardo.garagefx;

import com.bugardo.controllers.Vehiculo;
import com.bugardo.controllers.VehiculoEstacionado;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GarageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GarageApplication.class.getResource("main-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            //scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

            stage.setTitle("Garage App");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(520);
            stage.setHeight(400);
            stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}