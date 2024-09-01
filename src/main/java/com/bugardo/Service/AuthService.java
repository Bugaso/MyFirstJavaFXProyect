package com.bugardo.Service;

import com.bugardo.controllers.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class AuthService {
    private static Usuario root = new Usuario("Root","Root",0);
    private static ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    private static Usuario usuario;

    public static boolean setRoot(String password){
        if(root.compareTo(password) == 0){
            AlertService.Alerta(Alert.AlertType.WARNING,"Autenticacion","","Se accedio como usuario Root" +
                    " por favor evite hacer cambios perjudiciales.");
            root.setAcceso(3);
            return true;
        }
        AlertService.Alerta(Alert.AlertType.ERROR,"Autenticacion","","La contraseña de usuario Root ingresada " +
                "es erronea.");
        return false;
    }

    public static boolean setUsuario(String Username, String password){
        for(Usuario user : usuarios){
            if(user.getUserName().equals(Username) ){
                if(user.compareTo(password) == 0){
                    AlertService.Alerta(Alert.AlertType.INFORMATION,"Autenticacion","","Se accedio como "+ user.getUserName()+".");
                    usuario = user;
                    return true;
                }else{
                    AlertService.Alerta(Alert.AlertType.ERROR,"Autenticacion","","La contraseña ingresada " +
                            "es erronea.");
                }
            }
        }
        AlertService.Alerta(Alert.AlertType.ERROR,"Autenticacion","","Usuario no registrado");
        return false;
    }

    public static Usuario getUsuario(){
        return usuario;
    }

    public static int getRoot(){
        return root.getAcceso();
    }
    public static void closeSession(){
        usuario = null;
        root.setAcceso(0);
    }
}
