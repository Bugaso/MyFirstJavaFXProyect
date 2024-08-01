package com.bugardo.controllers;

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
import java.util.Optional;
import java.util.ResourceBundle;

public class EstacionController implements Initializable {
    @FXML
    private TableView table;
    @FXML
    private TableColumn<VehiculoEstacionado,String> patColm;
    @FXML
    private TableColumn<VehiculoEstacionado, LocalDateTime> fechaColm;
    @FXML
    private TableColumn<VehiculoEstacionado,Boolean> pagoColm;
    @FXML
    private Group group;
    @FXML
    private TextField patText;
    @FXML
    private Spinner<Integer> hourText;
    @FXML
    private Spinner<Integer> minText;
    @FXML
    private Button saveBtn;
    @FXML
    private CheckBox pagoCheck;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patColm.setCellValueFactory(new PropertyValueFactory<>("patente"));

        fechaColm.setCellValueFactory(new PropertyValueFactory<>("entrada"));
        fechaColm.setCellFactory(fecha -> new FechaCell());

        pagoColm.setCellValueFactory(new PropertyValueFactory<>("pago"));
        pagoColm.setCellFactory(pago -> new PagoCell(true));

        table.setItems(VehiculosEstacionados.getDatos());
        table.setPlaceholder(new Label("No hay vehiculos estacionados"));

        table.setRowFactory(fila -> {
            TableRow<VehiculoEstacionado> elem = new TableRow<>();
            elem.setOnMouseClicked( mouseEvent -> {if(!elem.isEmpty()){
                cargarVehiculo(elem.getItem());}
            });
            return elem;
        });
    }

    public void cargarVehiculo(VehiculoEstacionado elem){
        group.setDisable(false);

        if(elem.getPatente().compareToIgnoreCase(patText.getText()) != 0){
            patText.setText(elem.getPatente());
            hourText.getValueFactory().setValue(elem.getEntrada().getHour());
            minText.getValueFactory().setValue(elem.getEntrada().getMinute());
            pagoCheck.setSelected(elem.isPago());
        }
    }

    public void onSaveClick(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modificacion");
        alert.setHeaderText("Modificacion de datos");
        alert.setContentText("Esta seguro que quiere realizar estos cambios?\n"+"Vehiculo a modificar: "+patText.getText());
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK && result.isPresent()){

            VehiculoEstacionado ve = VehiculosEstacionados.getVehiculo(new VehiculoEstacionado(patText.getText()));

            LocalDate date = (LocalDate) LocalDate.from(ve.getEntrada());
            ve.setEntrada(LocalDateTime.of(date.getYear(),date.getMonthValue(),date.getDayOfMonth(),hourText.getValue(),minText.getValue()));
            ve.setPago(pagoCheck.isSelected());
        }
    }
}
