package com.bugardo.celdasCustom;

import com.bugardo.controllers.VehiculoEstacionado;
import javafx.scene.control.TableCell;

import java.time.LocalDateTime;

public class FechaCell  extends TableCell<VehiculoEstacionado, LocalDateTime> {
    @Override
    protected void updateItem(LocalDateTime localDateTime, boolean b) {
        super.updateItem(localDateTime, b);
        if (b || localDateTime == null) {
            setText(null);
        } else {
            setText(localDateTime.getDayOfMonth()+"/"+localDateTime.getMonthValue()+"/"+localDateTime.getYear()+hora_min(localDateTime)); // Muestra "*" si es verdadero, vacío si es falso
        }
    }

    protected String hora_min(LocalDateTime time){
        String T = " ";
        if(time.getHour()<10){
            T +="0"+time.getHour();
        }else{
            T += time.getHour();
        }
        T += ":";
        if(time.getMinute() < 10){
            T+= "0"+time.getMinute();
        }else{
            T+= time.getMinute();
        }
        return T;
    }
}
