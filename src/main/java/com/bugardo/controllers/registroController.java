package com.bugardo.controllers;

import com.bugardo.Service.VehiculosEstacionados;
import com.bugardo.Validar;
import com.bugardo.garagefx.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;



public class registroController implements Initializable {
    @FXML
    private TextField patText;
    @FXML
    private Spinner<Integer> hourText;
    @FXML
    private Spinner<Integer> minText;
    @FXML
    private CheckBox pagCheck;
    @FXML
    private Button regBtn;

    private Alert alert;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.alert = new Alert(null);
    }

    public void Salvar(){

        if(patText.getText().isBlank()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Patente Vacia");
            alert.setTitle("Patente no fue ingresada");
            alert.setContentText("Debe ingresar una patente para que el vehiculo sea registrado correctamente");
            alert.show();

            return;
        }
        if(patText.getText().length() < 9 || patText.getText().length() > 9){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("El formato de la patente es erroneo, debe tener una longitud de 9 caracteres");
            alert.setHeaderText("Error de Formato de patente");
            alert.setTitle("Formato Incorrecto");
            alert.show();

            return;
        }if(!Validar.validarPat(patText.getText())){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Error de Formato de patente");
            alert.setTitle("Formato Incorrecto");
            alert.setContentText("El formato de la patente es erroneo, debe ser como en este ejemplo:\n" + "AB-123-CD");

            alert.show();
            return;
        }

        VehiculoEstacionado ve = new VehiculoEstacionado();
        ve.setPatente(patText.getText());
        LocalDate date = LocalDate.now();

        ve.setEntrada(LocalDateTime.of(date.getYear(),date.getMonthValue(),date.getDayOfMonth(),hourText.getValue(),minText.getValue()));

        ve.setPago(pagCheck.isSelected());

        if(VehiculosEstacionados.getVehiculo(ve) == null){
            VehiculosEstacionados.getDatos().add(ve);
            HelloApplication.estacionarVehiculo(ve);
        }else{
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Registro de Vehiculo");
            alert.setHeaderText("Vehiculo ya registrado");
            alert.setContentText("El vehiculo que quiere registrar ya se encuentra en el garage!!!");
            alert.show();
        }

        patText.clear();
        pagCheck.setSelected(false);
    }
}
