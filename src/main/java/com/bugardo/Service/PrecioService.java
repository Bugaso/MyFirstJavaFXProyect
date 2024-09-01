package com.bugardo.Service;

import com.bugardo.controllers.Vehiculo;
import com.bugardo.controllers.VehiculoEstacionado;

import java.time.Duration;

public class PrecioService {
    private static double pagoMotocicleta;
    private static double pagoAutomovil;
    private static double pagoCamioneta;

    public PrecioService() {
        pagoMotocicleta = 300;
        pagoAutomovil = 500;
        pagoCamioneta = 650;
    }

    public static double getPagoMotocicleta() {
        return pagoMotocicleta;
    }

    public static void setPagoMotocicleta(double precio) {
          pagoMotocicleta = precio;
    }

    public static double getPagoAutomovil() {
        return pagoAutomovil;
    }

    public static void setPagoAutomovil(double precio) {
        pagoAutomovil = precio;
    }

    public static double getPagoCamioneta() {
        return pagoCamioneta;
    }

    public static void setPagoCamioneta(double precio) {
        pagoCamioneta = precio;
    }

    public static double getPrecio(Vehiculo v){
        if(v.getTipo().equalsIgnoreCase("Automovil")){
            return getPagoAutomovil();
        }
        if(v.getTipo().equalsIgnoreCase("Motocicleta")){
            return getPagoMotocicleta();
        }
        if(v.getTipo().equalsIgnoreCase("Camioneta")){
            return getPagoCamioneta();
        }
        return -1;
    }

    public static double getPrecioPorHora(VehiculoEstacionado ve){
        if(ve.getTipo().equalsIgnoreCase("Automovil")){
            return getPagoAutomovil() * (Duration.between(ve.getEntrada(), ve.getSalida())).toHours();
        }
        if(ve.getTipo().equalsIgnoreCase("Motocicleta")){
            return getPagoMotocicleta() * (Duration.between(ve.getEntrada(), ve.getSalida())).toHours();
        }
        if(ve.getTipo().equalsIgnoreCase("Camioneta")){
            return getPagoCamioneta() * (Duration.between(ve.getEntrada(), ve.getSalida())).toHours();
        }
        return -1;
    }
}
