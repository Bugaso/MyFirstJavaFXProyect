package com.bugardo.controllers;

import com.bugardo.Service.AlertService;
import com.bugardo.Service.VehiculosEstacionados;
import com.bugardo.Validar;
import com.bugardo.garagefx.GarageApplication;
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
            AlertService.PatenteAlert();
            return;
        }
        if(patText.getText().length() < 9 || patText.getText().length() > 9){
            AlertService.PatenteAlert();
            return;
        }if(!Validar.validarPat(patText.getText())){
            AlertService.PatenteAlert();
            return;
        }

        VehiculoEstacionado ve = new VehiculoEstacionado();
        ve.setPatente(patText.getText());
        LocalDate date = LocalDate.now();

        ve.setEntrada(LocalDateTime.of(date.getYear(),date.getMonthValue(),date.getDayOfMonth(),hourText.getValue(),minText.getValue()));

        ve.setPago(pagCheck.isSelected());

        if(VehiculosEstacionados.getVehiculo(ve) == null){
            VehiculosEstacionados.getDatos().add(ve);

        }else{
            AlertService.ExisteAlert();
        }

        patText.clear();
        pagCheck.setSelected(false);
    }
}
