package com.bugardo.controllers;

import com.bugardo.Service.VehiculosEstacionados;
import com.bugardo.celdasCustom.FechaCell;
import com.bugardo.celdasCustom.PagoCell;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        patColm.setCellValueFactory(new PropertyValueFactory<>("patente"));

        fechaColm.setCellValueFactory(new PropertyValueFactory<>("entrada"));
        fechaColm.setCellFactory(fecha -> new FechaCell());

        pagoColm.setCellValueFactory(new PropertyValueFactory<>("pago"));
        pagoColm.setCellFactory(pago -> new PagoCell());
        pagoColm.setStyle("-fx-alignment: CENTER;");
        table.setItems(VehiculosEstacionados.getDatos());
        table.setPlaceholder(new Label("No hay vehiculos estacionados"));

    }

    public static void cargarVehiculo(VehiculoEstacionado ve){
        VehiculosEstacionados.getDatos().add(ve);

    }
}
