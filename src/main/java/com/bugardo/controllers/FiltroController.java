package com.bugardo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleButton;

public class FiltroController {
    @FXML
    private DatePicker minDate;
    @FXML
    private DatePicker maxDate;
    @FXML
    private ToggleButton esBtn;

    public void OnActionBtn(){
        if(esBtn.isSelected()){
            esBtn.setText("Salida");
        }else{
            esBtn.setText("Entrada");
        }

    }
}
