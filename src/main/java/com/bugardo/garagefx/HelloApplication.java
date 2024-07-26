package com.bugardo.garagefx;

import com.bugardo.controllers.Vehiculo;
import com.bugardo.controllers.VehiculoEstacionado;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private static ArrayList<VehiculoEstacionado> garage = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            //scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

            stage.setTitle("Garage App");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();


    }

    public static void main(String[] args) {

        launch();
        
    }

    public static void estacionarVehiculo(VehiculoEstacionado ve){
        garage.add(ve);
        for(Vehiculo v : garage){
            System.out.println(v.toString());
        }
    }

}