package com.svalero.reloj.controller;


import com.svalero.reloj.tasks.ClockTask;
import com.svalero.reloj.tasks.TimerTask;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

public class ShowWatchController implements Initializable {

    TimerTask timerTask;
    Label lbTiempo;
    public ShowWatchController(int numero) {
        this.timerTask = new TimerTask(numero);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.timerTask.messageProperty().addListener((observableValue, oldValue, newValue) -> this.lbTiempo.setText(newValue));
        new Thread(this.timerTask).start();
    }
}
