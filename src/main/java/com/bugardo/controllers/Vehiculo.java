package com.bugardo.controllers;

import javafx.beans.property.SimpleStringProperty;


public class Vehiculo implements Comparable<Vehiculo>{
    private SimpleStringProperty patente;

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

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente.getValue() + '\'' +
                '}';
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.patente.getValue().compareTo(o.getPatente());
    }
}
