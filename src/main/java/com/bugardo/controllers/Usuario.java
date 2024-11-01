package com.bugardo.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usuario implements Comparable<String>{
    private SimpleStringProperty userName;
    private SimpleStringProperty userMail;
    private SimpleStringProperty password;
    private SimpleIntegerProperty acceso;

    public Usuario() {
        this.userName = new SimpleStringProperty();
        this.userMail = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.acceso = new SimpleIntegerProperty();
    }

    public Usuario(String userName,String userMail, String password,int acceso) {
        this.userName = new SimpleStringProperty();
        this.userMail = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.acceso = new SimpleIntegerProperty();
        setUserName(userName);
        setUserMail(userMail);
        setPassword(password);
        setAcceso(acceso);
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getUserMail() {
        return userMail.get();
    }

    public SimpleStringProperty userMailProperty() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail.set(userMail);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public int getAcceso() {
        return acceso.get();
    }

    public SimpleIntegerProperty accesoProperty() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso.set(acceso);
    }

    @Override
    public int compareTo(String o) {
        return getPassword().compareTo(o);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userName=" + userName.getValue() +
                ", userMail=" + userMail.getValue() +
                ", password=" + password.getValue() +
                ", acceso=" + acceso.get() +
                '}';
    }
}
