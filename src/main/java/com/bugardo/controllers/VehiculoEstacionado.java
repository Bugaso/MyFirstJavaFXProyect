package com.bugardo.controllers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDateTime;

public class VehiculoEstacionado extends Vehiculo {
    private SimpleObjectProperty<LocalDateTime> entrada;
    private SimpleObjectProperty<LocalDateTime> salida;
    private SimpleBooleanProperty pago;
    public VehiculoEstacionado() {
        super();
        this.entrada = new SimpleObjectProperty<>();
        this.salida = new SimpleObjectProperty<>();
        this.pago = new SimpleBooleanProperty();
    }

    public VehiculoEstacionado(String patente, LocalDateTime entrada, LocalDateTime salida,boolean pago) {
        super(patente);
        this.entrada = new SimpleObjectProperty<>(entrada);
        this.salida = new SimpleObjectProperty<>(salida);
        this.pago = new SimpleBooleanProperty(pago);
    }

    public LocalDateTime getEntrada() {
        return entrada.get();
    }

    public SimpleObjectProperty<LocalDateTime> entradaProperty() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada.set(entrada);
    }

    public LocalDateTime getSalida() {
        return salida.get();
    }

    public SimpleObjectProperty<LocalDateTime> salidaProperty() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida.set(salida);
    }

    public boolean isPago() {
        return pago.get();
    }

    public SimpleBooleanProperty pagoProperty() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago.set(pago);
    }

    @Override
    public String toString() {
        return "VehiculoEstacionado{" +
                "entrada=" + entrada.toString() +
                "} " + super.toString();
    }
    @Override
    public int compareTo(Vehiculo o) {
        return super.compareTo(o);
    }
}
