package com.bugardo.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Vehiculo implements Comparable<Vehiculo>{
    private SimpleStringProperty patente;
    private SimpleStringProperty tipo;

    public Vehiculo() {
        this.patente = new SimpleStringProperty();
    }

    public Vehiculo(String patente) {
        this.patente = new SimpleStringProperty(patente);
    }

    public String getPatente() {
        return patente.get();
    }

    public SimpleStringProperty patenteProperty() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente.set(patente);
    }

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente=" + patente +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.patente.getValue().compareTo(o.getPatente());
    }
}
