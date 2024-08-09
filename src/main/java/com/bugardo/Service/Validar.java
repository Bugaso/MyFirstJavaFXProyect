package com.bugardo.Service;

public class Validar {
    public static boolean validarPat(String s){

        if(s.charAt(2) != '-' || s.charAt(6) != '-'){
            return false;
        }

        try{
            int num = Integer.parseInt(s.substring(3,5));
            if(num < 0){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
