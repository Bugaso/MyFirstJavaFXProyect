package com.bugardo.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;



public class MainController {

    @FXML
    private Pane regPane;
    @FXML
    private Pane outPane;
    @FXML
    private Pane viewPane;
    @FXML
    protected void onRegButtonClick() {
        resetPanes();
        regPane.setVisible(true);
        regPane.toFront();
        System.out.println(regPane.toString());
    }
    @FXML
    public void onOutButtonClick(){
        resetPanes();
        outPane.setVisible(true);
        outPane.toFront();
        System.out.println(outPane.toString());

    }

    public void onViewButtonClick(){
        resetPanes();
        viewPane.setVisible(true);
        viewPane.toFront();
        System.out.println(viewPane.toString());
    }
    public void resetPanes(){
        regPane.setVisible(false);
        regPane.toBack();
        outPane.setVisible(false);
        outPane.toBack();
        viewPane.setVisible(false);
        viewPane.toBack();
    }
}