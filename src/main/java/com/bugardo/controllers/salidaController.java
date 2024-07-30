package com.bugardo.controllers;

import com.bugardo.Service.AlertService;
import com.bugardo.Service.HistorialVehiculos;
import com.bugardo.Service.VehiculosEstacionados;
import com.bugardo.celdasCustom.FechaCell;
import com.bugardo.celdasCustom.PagoCell;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


public class salidaController implements Initializable{
    @FXML
    private TableView<VehiculoEstacionado> table;
    @FXML
    private TableColumn<VehiculoEstacionado,String> patColm;
    @FXML
    private TableColumn<VehiculoEstacionado, LocalDateTime> fechaColm;
    @FXML
    private TableColumn<VehiculoEstacionado,Boolean> pagoColm;
    @FXML
    private Button cargarBtn;
    @FXML
    private Group salidaGroup;
    @FXML
    private TextField patText;
    @FXML
    private Button sacarBtn;
    @FXML
    private DatePicker salidaDate;
    @FXML
    private Spinner<Integer> hourText;
    @FXML
    private Spinner<Integer> minText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        patColm.setCellValueFactory(new PropertyValueFactory<>("patente"));

        fechaColm.setCellValueFactory(new PropertyValueFactory<>("entrada"));
        fechaColm.setCellFactory(fecha -> new FechaCell());

        pagoColm.setCellValueFactory(new PropertyValueFactory<>("pago"));
        pagoColm.setCellFactory(pago -> new PagoCell());

        table.setItems(VehiculosEstacionados.getDatos());
        table.setPlaceholder(new Label("No hay vehiculos estacionados"));

        table.setRowFactory(fila -> {TableRow<VehiculoEstacionado> elem = new TableRow<>();
                    elem.setOnMouseClicked( mouseEvent -> {if(!elem.isEmpty()){
                        cargarVehiculo(elem.getItem());}
                    });
            return elem;
        });


    }


    public void buscarVehiculo(){
        VehiculoEstacionado ve;
        ve = VehiculosEstacionados.getVehiculo(new VehiculoEstacionado(patText.getText()));
        if(ve == null){
            AlertService.VehiculoAlert();
            return;
        }
        cargarVehiculo(ve);
    }

    public void cargarVehiculo(VehiculoEstacionado ve){
        patText.setText(ve.getPatente());
        salidaGroup.setDisable(false);
    }

    public void SacarVehiculo(){
        VehiculoEstacionado ve = VehiculosEstacionados.getVehiculo(new VehiculoEstacionado(patText.getText()));

        if(ve == null){
            AlertService.VehiculoAlert();
            return;
        }

        if(salidaDate.getValue() == null){
            AlertService.FechaAlert();
            return;
        }

        LocalDate aux = salidaDate.getValue();
        LocalDateTime salida = LocalDateTime.of(aux.getYear(),aux.getMonthValue(),aux.getDayOfMonth(),hourText.getValue(),minText.getValue());
        if(ve.getEntrada().compareTo(salida) >= 0){

            String s = ("La fecha de salida introducida es menor o igual a la fecha en que entro el vehiculo" +
                    " por favor ingrese una fecha de salida valida");
            AlertService.Alerta(Alert.AlertType.INFORMATION,"SalidaAlert,","Fecha incorrecta",s);
            return;
        }
        ve.setSalida(salida);
        VehiculosEstacionados.getDatos().remove(ve);
        HistorialVehiculos.getDatos().add(ve);
        System.out.println(HistorialVehiculos.getDatos().getLast().toString()+HistorialVehiculos.getDatos().getLast().getSalida().toString());
    }

    public void resetBtn(){
        patText.clear();
        salidaDate.setValue(null);
        salidaGroup.setDisable(true);
    }
}
