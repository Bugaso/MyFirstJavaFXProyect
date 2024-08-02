package com.bugardo.Service;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;


import java.util.Optional;

public class AlertService {

    private static Alert alerta;

    public static void VehiculoAlert(){
        alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("VehiculoAlert");
        alerta.setHeaderText("Vehiculo inexistente");
        alerta.setContentText("El vehiculo no fue encontrado, puede suceder que no" +
                " se haya registrado correctamente o introdujo una patente incorrecta.");
        alerta.show();
    }

    public static void FechaAlert(){
        alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("FechaAlert");
        alerta.setHeaderText("Fecha incorrecta");
        alerta.setContentText("La fecha no se introdujo en el formato correcto " +
                "(yyyy/mm/dd) o no se introdujo una fecha.");
        alerta.show();
    }

    public static void ExisteAlert(){
        alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Registro de Vehiculo");
        alerta.setHeaderText("Vehiculo ya registrado");
        alerta.setContentText("El vehiculo que quiere registrar ya se encuentra en el garage!!!");
        alerta.show();
    }

    public static void PatenteAlert(){
        alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setHeaderText("Patente Alert");
        alerta.setTitle("Formato de patente incorrecto");
        alerta.setContentText("La patente debe ser ingresada correctamente y no debe estar vacia" +
                ", el formato debe ser como en este ejemplo:\n" + "AB-123-CD");
        alerta.show();
    }

    public static void Alerta(Alert.AlertType type, String t, String h, String c){
        alerta = new Alert(type);
        alerta.setTitle(t);
        alerta.setHeaderText(h);
        alerta.setContentText(c);
        alerta.show();
    }

    public static Optional<ButtonType> Alerta(String t, String h, String c){
        alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(t);
        alerta.setHeaderText(h);
        alerta.setContentText(c);
        alerta.getButtonTypes().setAll(
                new ButtonType("No", ButtonData.NO),
                new ButtonType("Sí", ButtonData.YES)
        );
        return alerta.showAndWait();
    }
}
