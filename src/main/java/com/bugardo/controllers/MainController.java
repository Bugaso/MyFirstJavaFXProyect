package com.bugardo.controllers;

import com.bugardo.Service.AuthService;
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
    private Pane homePane;
    @FXML
    private Pane regPane;
    @FXML
    private Pane outPane;
    @FXML
    private Pane viewPane;
    @FXML
    private Pane historialPane;
    @FXML
    private ImageView menuBtn;
    @FXML
    private Button homeBtn;
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

    private static ToolBar refBar;

    public static void setEnableBar(){
        for(Node btn : refBar.getItems()){
            System.out.println(btn.getId());
        }
        enableButtons();
    }

    private void disableAll(){
        for(Node btn : refBar.getItems()){
            if(btn.getId() != menuBtn.getId()){
                btn.setDisable(true);
            }
        }
    }
    private static void enableButtons(){
        if(AuthService.getUsuario().getAcceso() == 0){
            for(Node btn : refBar.getItems()){
                if(!btn.getId().equals("showBtn") && !btn.getId().equals("historialBtn")){
                    btn.setDisable(false);
                }
            }
            System.out.println("Sesion de usuario normal");
            return;
        }
        for(Node btn : refBar.getItems()){
            btn.setDisable(false);
        }
    }
    public void onHomeButtonClick(){
        resetPanes();
        homePane.toFront();
        homePane.setVisible(true);
        System.out.println(homePane.toString());
    }

    public void onRegButtonClick() {

        if(AuthService.getUsuario() != null){
            resetPanes();
            regPane.setVisible(true);
            regPane.toFront();
            System.out.println(regPane.toString());
        }

    }

    public void onOutButtonClick(){
        if(AuthService.getUsuario() != null){
            resetPanes();
            outPane.setVisible(true);
            outPane.toFront();
            System.out.println(outPane.toString());
        }


    }

    public void onViewButtonClick(){
        if(AuthService.getUsuario() != null && AuthService.getUsuario().getAcceso() == 1){
            resetPanes();
            viewPane.setVisible(true);
            viewPane.toFront();
            System.out.println(viewPane.toString());
        }

    }

    public void onHistorialButtonClick(){
        if(AuthService.getUsuario() != null && AuthService.getUsuario().getAcceso() == 1){
            resetPanes();
            historialPane.setVisible(true);
            historialPane.toFront();
        }

    }

    public void resetPanes(){
        homePane.setVisible(false);
        homePane.toBack();
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
            extendButton(homeBtn,"Home");
            extendButton(regBtn,"Registrar");
            extendButton(outBtn,"Salida");
            extendButton(showBtn,"Garage");
            extendButton(historialBtn,"Historial");

        }else{
            barraTareas.setPrefWidth(95);
            barraTareas.toBack();
            defaultButton(homeBtn,"");
            defaultButton(regBtn,"");
            defaultButton(outBtn,"");
            defaultButton(showBtn,"");
            defaultButton(historialBtn,"");
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barraTareas.toBack();
        refBar = barraTareas;
        disableAll();
    }
}