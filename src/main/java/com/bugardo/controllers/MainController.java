package com.bugardo.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;



public class MainController {

    @FXML
    private Pane regPane;
    @FXML
    private Pane outPane;
    @FXML
    private Pane viewPane;
    @FXML
    private Pane historialPane;
    @FXML
    private ImageView iconcito;

    public void onRegButtonClick() {
        resetPanes();
        regPane.setVisible(true);
        regPane.toFront();
        System.out.println(regPane.toString());
    }

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

    public void onHistorialButtonClick(){
        resetPanes();
        historialPane.setVisible(true);
        historialPane.toFront();
    }

    public void resetPanes(){
        regPane.setVisible(false);
        regPane.toBack();
        outPane.setVisible(false);
        outPane.toBack();
        viewPane.setVisible(false);
        viewPane.toBack();
        historialPane.setVisible(false);
        historialPane.toBack();
    }


}