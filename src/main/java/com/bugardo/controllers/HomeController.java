package com.bugardo.controllers;

import com.bugardo.Service.AlertService;
import com.bugardo.Service.AuthService;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HomeController {
    @FXML
    private Group SesionGroup;
    @FXML
    private TextField UserText;
    @FXML
    private PasswordField pasText;
    @FXML
    private Button logBtn;
    @FXML
    private Button nuevoBtn;

    @FXML
    private Group RegistroGroup;

    @FXML
    private TextField mailText;
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passText;
    @FXML
    private PasswordField cpassText;

    public void IniciarSesion(){
        if(AuthService.setUsuario(UserText.getText(),pasText.getText())){
            UserText.setText("");
            pasText.setText("");
            MainController.setEnableBar();
        }
    }

    public void clear(){
        mailText.clear();
        userText.clear();
        passText.clear();
        cpassText.clear();
        userText.setDisable(false);
        mailText.setDisable(false);
        passText.setDisable(false);
        cpassText.setDisable(false);
    }

    public void disableAll(){
        userText.setDisable(true);
        mailText.setDisable(true);
        passText.setDisable(true);
        cpassText.setDisable(true);
    }

    public void RegistroFormulario(){
        SesionGroup.setDisable(true);
        SesionGroup.setVisible(false);
        RegistroGroup.setVisible(true);
    }

    public void SesionFormulario(){
        SesionGroup.setDisable(false);
        SesionGroup.setVisible(true);
        RegistroGroup.setVisible(false);
    }

    public void RegistrarUsuario(){


        if(passText.getText().length() > 12 || passText.getText().length() < 8){
            AlertService.Alerta(Alert.AlertType.INFORMATION,"Contraseña corta","Error de validacion","La contraseña debe ser de 8 a 12 caracteres.");
            return;
        }

        if(!passText.getText().equals(cpassText.getText())){
            AlertService.Alerta(Alert.AlertType.INFORMATION,"Contraseña","Error de validacion","Las constraseñas no coinciden.");
            return;
        }

        if(userText.getText().equals(null) || userText.getText().length() < 8){
            AlertService.Alerta(Alert.AlertType.INFORMATION,"Nombre vacio","Error de validacion","El nombre de usuario debe contener almenos 8 caracteres.");
            return;
        }
        if(mailText.getText().equals(null) || mailText.getText().length() < 8){
            AlertService.Alerta(Alert.AlertType.INFORMATION,"Mail vacio","Error de validacion","El mail debe ser valido!!!.");
            return;
        }

        Usuario user = new Usuario(userText.getText(),mailText.getText(),passText.getText(),0);
        System.out.println(user.toString());
        AuthService.addUsuario(user);
        disableAll();
    }

}
