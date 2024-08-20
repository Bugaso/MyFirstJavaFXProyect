package com.bugardo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    private Pane regPane;
    @FXML
    private Pane outPane;
    @FXML
    private Pane viewPane;
    @FXML
    private Pane historialPane;
    @FXML
    private Button regBtn;
    @FXML
    private Button outBtn;
    @FXML
    private Button showBtn;
    @FXML
    private Button historialBtn;
    @FXML
    private ToolBar barraTareas;

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

    public void extendButton(Button btn, String text){
        btn.setText(text);
        btn.setPrefWidth(290);
        btn.getGraphic().setTranslateX(-105);
        btn.setContentDisplay(ContentDisplay.CENTER);
    }
    public void defaultButton(Button btn, String text){
        btn.setText(text);
        btn.setPrefWidth(64);
        btn.getGraphic().setTranslateX(0);
        btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }
    public void mostrarItems(){
        if(barraTareas.getPrefWidth() == 95.0){
            barraTareas.setPrefWidth(300);
            barraTareas.toFront();
            extendButton(regBtn,"Registrar");
            extendButton(outBtn,"Salida");
            extendButton(showBtn,"Garage");
            extendButton(historialBtn,"Historial");
        }else{
            barraTareas.setPrefWidth(95);
            barraTareas.toBack();
            defaultButton(regBtn,"");
            defaultButton(outBtn,"");
            defaultButton(showBtn,"");
            defaultButton(historialBtn,"");
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barraTareas.toBack();
    }
}