package com.svalero.reloj.controller;

import com.svalero.reloj.tasks.CronometroTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowCronometroController implements Initializable {

    CronometroTask cronometroTask;

    @FXML
    Label lbTiempo;
    @FXML
    Button btParar;

    public ShowCronometroController(){
        this.cronometroTask = new CronometroTask();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.cronometroTask.messageProperty().addListener((observableValue, oldvalue, newValue) -> this.lbTiempo.setText(newValue));
        new Thread(this.cronometroTask).start();
    }

    @FXML
    public void stop(ActionEvent event) {
        cronometroTask.cancel();
    }
}
