package com.bugardo.garagefx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;



public class HelloController {

    @FXML
    private Pane regPane;
    @FXML
    private Pane outPane;
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

    public void resetPanes(){
        regPane.setVisible(false);
        regPane.toBack();
        outPane.setVisible(false);
        outPane.toBack();

    }
}