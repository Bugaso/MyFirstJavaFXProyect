package com.bugardo.Service;

import com.bugardo.controllers.VehiculoEstacionado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HistorialVehiculos {

    private static ObservableList<VehiculoEstacionado> historial = FXCollections.observableArrayList();

    public static ObservableList<VehiculoEstacionado> getDatos() {
        return historial;
    }

    public static VehiculoEstacionado getVehiculo(VehiculoEstacionado ve){
        for(VehiculoEstacionado aux : getDatos()){
            if(aux.compareTo(ve) == 0){
                return aux;
            }
        }
        return null;
    }


    public static VehiculoEstacionado deleteVehiculo(VehiculoEstacionado ve){

        boolean b;
        do{
            b = false;
            for(VehiculoEstacionado aux : getDatos()){
                if(aux.compareTo(ve) == 0){
                    getDatos().remove(aux);
                    b = true;
                    break;
                }
            }
        }while(b);

        return ve;
    }
}
