package com.bugardo.controllers;

import com.bugardo.Service.AlertService;
import com.bugardo.Service.HistorialVehiculos;
import com.bugardo.celdasCustom.FechaCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class HistorialController implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn <VehiculoEstacionado,String> patColm;
    @FXML
    private TableColumn <VehiculoEstacionado, LocalDateTime> fechaColm;
    @FXML
    private TableColumn <VehiculoEstacionado, LocalDateTime> salidaColm;
    @FXML
    private TableColumn <VehiculoEstacionado, LocalDateTime> fechaMin;
    @FXML
    private TableColumn <VehiculoEstacionado, LocalDateTime> fechaMax;
    @FXML
    private DatePicker dateMin;
    @FXML
    private DatePicker dateMax;
    @FXML
    private Button resetBtn;
    @FXML
    private Button filBtn;
    @FXML
    private TextField patText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setItems(HistorialVehiculos.getDatos());
        table.setPlaceholder(new Label("No se registro ninguna salida de vehiculos"));

        patColm.setCellValueFactory(new PropertyValueFactory<>("patente"));

        fechaColm.setCellValueFactory(new PropertyValueFactory<>("entrada"));
        fechaColm.setCellFactory(fecha -> new FechaCell());

        salidaColm.setCellValueFactory(new PropertyValueFactory<>("salida"));
        salidaColm.setCellFactory(fecha -> new FechaCell());

        fechaMin.setCellValueFactory(new PropertyValueFactory<>("entrada"));
        fechaMin.setCellFactory(fecha -> new FechaCell());

        fechaMax.setCellValueFactory(new PropertyValueFactory<>("salida"));
        fechaMax.setCellFactory(fecha -> new FechaCell());

        table.setRowFactory(fila -> {TableRow<VehiculoEstacionado> elem = new TableRow<>();
            elem.setOnMouseClicked(evento ->{
                this.patText.setText(elem.getItem().getPatente());
            });
            return elem;
        });

        patText.focusedProperty().addListener((observable,oldValue,newValue) -> {
            if(patText.getText().equals("Ingrese la patente") && newValue){
                patText.setText("");
            }else if(patText.getText().isBlank()){
                patText.setText("Ingrese la patente");
            }
        });
    }

    public void setFilBtn(){
        LocalDate min = dateMin.getValue();
        LocalDate max = dateMax.getValue();
        if(min == null && max == null){
            AlertService.FechaAlert();
            return;
        }
        ObservableList<VehiculoEstacionado> filtrados = FXCollections.observableArrayList();

        if(min != null && max == null){
            for(VehiculoEstacionado ve : HistorialVehiculos.getDatos()){
                if(ve.getEntrada().compareTo(min.atStartOfDay()) >= 0){
                    filtrados.add(ve);
                }
            }
            table.setItems(filtrados);
            table.refresh();
        }

        if(min == null && max != null){
            for(VehiculoEstacionado ve : HistorialVehiculos.getDatos()){
                if(ve.getSalida().compareTo(max.atStartOfDay()) <= 0){
                    filtrados.add(ve);
                }
            }
            table.setItems(filtrados);
            table.refresh();
        }

        if(min != null && max != null){
            for(VehiculoEstacionado ve : HistorialVehiculos.getDatos()){
                if(ve.getEntrada().compareTo(min.atStartOfDay()) >= 0 && ve.getSalida().compareTo(max.atStartOfDay()) <= 0){
                    filtrados.add(ve);
                }
            }
            table.setItems(filtrados);
            table.refresh();
        }

    }

    public void deleteBtn(){
        if(patText.getText().equalsIgnoreCase("Ingrese la patente")){
            AlertService.PatenteAlert();
            return;
        }

        Optional<ButtonType> resul = AlertService.Alerta("Eliminar","Eliminar vehiculos","Desea eliminar todos los vehiculos con la patente :"+patText.getText()+
                " del historial de vehiculos que salieron del estacionamiento?");

        if(HistorialVehiculos.getDatos().isEmpty()){
            AlertService.Alerta(Alert.AlertType.INFORMATION,"Historial","Historial vacio","El historial de los vehiculos que entraron y" +
                    " salieron del estacionamiento esta vacio.");
            return;
        }
        if(resul.get().getText() == "Sí"){
            HistorialVehiculos.deleteVehiculo(new VehiculoEstacionado(patText.getText()));
        }
    }


}
