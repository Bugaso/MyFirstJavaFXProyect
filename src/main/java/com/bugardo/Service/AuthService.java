package com.bugardo.Service;

import com.bugardo.controllers.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class AuthService {
    private static Usuario root = new Usuario("Root","beelli380@gmai.com","Root",1);
    private static ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    private static Usuario usuario;

    public static boolean setRoot(String User,String password){
        if((root.getUserName().equals(User)) || root.getUserMail().equals(User)){
            if(root.compareTo(password) == 0){
                AlertService.Alerta(Alert.AlertType.WARNING,"Autenticacion","","Se accedio como administrador" +
                        " por favor evite hacer cambios perjudiciales.");
                usuario = root;
                return true;
            }else{
                AlertService.Alerta(Alert.AlertType.ERROR,"Autenticacion","","La contraseña de usuario ingresada " +
                        "es erronea.");
            }
        }

        return false;
    }

    public static boolean setUsuario(String User, String password){
        boolean existe = false;
        if(setRoot(User,password)){
            return true;
        }else{
            for(Usuario user : usuarios){
                if(user.getUserName().equals(User) || user.getUserMail().equals(User)){
                    existe = true;
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

            if(!existe){
                AlertService.Alerta(Alert.AlertType.ERROR,"Autenticacion","","Usuario no registrado");
            }

        }

        return false;
    }

    public static boolean addUsuario(Usuario user){
        if(user.getUserName().equals(root.getUserName()) || user.getUserMail().equals(root.getUserMail())){
            return false;
        }
        for(Usuario us : usuarios){
            if(user.getUserName().equals(us.getUserName()) || user.getUserMail().equals(us.getUserMail())){
                AlertService.Alerta(Alert.AlertType.ERROR,"Autenticacion","","El usuario ingresado " +
                        "ya está registrado.");
                return false;
            }
        }

        usuarios.add(user);
        AlertService.Alerta(Alert.AlertType.INFORMATION,"Registro","","Se registró como "+ user.getUserName()+".");
        return true;
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
