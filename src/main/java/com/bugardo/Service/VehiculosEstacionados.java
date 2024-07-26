package com.bugardo.Service;

import com.bugardo.controllers.VehiculoEstacionado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehiculosEstacionados {
    private static ObservableList<VehiculoEstacionado> datos = FXCollections.observableArrayList();

    public static ObservableList<VehiculoEstacionado> getDatos() {
        return datos;
    }

    public static VehiculoEstacionado getVehiculo(VehiculoEstacionado ve){
        for(VehiculoEstacionado aux : getDatos()){
            if(aux.compareTo(ve) == 0){
                return aux;
            }
        }
        return null;
    }
}
