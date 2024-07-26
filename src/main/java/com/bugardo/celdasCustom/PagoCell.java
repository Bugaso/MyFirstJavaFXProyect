package com.bugardo.celdasCustom;
import com.bugardo.controllers.VehiculoEstacionado;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class PagoCell extends TableCell<VehiculoEstacionado, Boolean> {

    private CheckBox checkBox;

    public PagoCell() {
        checkBox = new CheckBox();
        checkBox.setStyle("-fx-alignment: CENTER;");
        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (!isEmpty()) {
                commitEdit(isNowSelected);
            }
        });
        setGraphic(checkBox);
        checkBox.setDisable(true);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
        } else {
            checkBox.setSelected(item);
            setGraphic(checkBox);
        }
    }
}