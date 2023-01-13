package com.svalero.reloj.controller;


import com.sun.javafx.scene.control.LabeledText;
import com.svalero.reloj.tasks.ClockTask;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    private ClockTask clockTask;
//    private numStopWatches;
//    private int numTimers;

    @FXML
    public Label lbReloj;
//    public TextField tfCuentaAtras;
//    public Button btCuentaAtras;
//    public Button btCronometro;
//    public TabPane tpTemporizadores;
//    public Tab tab = new Tab();

//    private Map<String, ShowWatchController> allWatchControler;

//    public AppController(){
//        allWatchControler = new HashMap<>();
//    }

    public AppController(){

//        Calendar calendar = Calendar.getInstance();
//
//        String hora = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
//
//        lbReloj = hora;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.clockTask = new ClockTask();
        this.clockTask.messageProperty().addListener((observableValue, oldValue, newValue) -> this.lbReloj.setText(newValue));
        new Thread(this.clockTask).start();
    }



}
