package com.bugardo.controllers;

import com.bugardo.Service.HistorialVehiculos;
import com.bugardo.Service.VehiculosEstacionados;
import com.bugardo.celdasCustom.FechaCell;
import com.bugardo.celdasCustom.PagoCell;
import javafx.event.EventDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
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
    private Alert alert;

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
        this.alert = new Alert(Alert.AlertType.ERROR);

    }


    public void buscarVehiculo(){
        VehiculoEstacionado ve = null;
        if(!patText.getText().isBlank()){
            ve = VehiculosEstacionados.getVehiculo(new VehiculoEstacionado(patText.getText()));
        }

        if(ve == null){
            alert.setTitle("Vehiculo inexistente");
            alert.setHeaderText("Vehiculo no registrado");
            alert.setContentText("El vehiculo que intenta buscar no se encuentra en la tabla de vehiculos registrados" +
                    " asegurese de haber escrito correctamente la patente y que esté registrado");
            alert.show();
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
            alert.show();
            alert.setTitle("Vehiculo inexistente");
            alert.setHeaderText("Vehiculo no registrado");
            alert.setContentText("El vehiculo que intenta buscar no se encuentra en la tabla de vehiculos registrados" +
                    " asegurese de haber escrito correctamente la patente y que esté registrado");
            return;
        }

        if(salidaDate.getValue() == null){

            alert.setTitle("Formato de fecha");
            alert.setContentText("La fecha de salida no fue introducida");
            alert.show();
            return;
        }

        LocalDate aux = salidaDate.getValue();
        LocalDateTime salida = LocalDateTime.of(aux.getYear(),aux.getMonthValue(),aux.getDayOfMonth(),hourText.getValue(),minText.getValue());
        if(ve.getEntrada().compareTo(salida) >= 0){

            alert.setTitle("Formato de fecha");

            alert.setContentText("La fecha de salida introducida es menor o igual a la fecha en que entro el vehiculo" +
                    " por favor ingrese una fecha de salida valida");
            alert.show();
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
