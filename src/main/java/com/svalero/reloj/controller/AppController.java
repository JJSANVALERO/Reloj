package com.svalero.reloj.controller;

import com.svalero.reloj.tasks.ClockTask;
import com.svalero.reloj.util.R;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    private ClockTask clockTask;
    private int numero;
    private int numStopWatches;
    private int numTimers;

    @FXML
    public Label lbReloj;
    @FXML
    public TextField tfCuentaAtras;
    @FXML
    public Button btCuentaAtras;
//    public Button btCronometro;
    @FXML
    public TabPane tpTemporizadores;
    @FXML
    public Tab tab = new Tab();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.clockTask = new ClockTask();
        this.clockTask.messageProperty().addListener((observableValue, oldValue, newValue) -> this.lbReloj.setText(newValue));
        new Thread(this.clockTask).start();
    }

    @FXML
    public void launchCuenta(ActionEvent event){
        numero = Integer.parseInt(tfCuentaAtras.getText());
        tfCuentaAtras.clear();
        if (numero <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Para hacer una cuenta debes poner un número mayor a 1");
            alert.show();
        } else {
            launch();
        }

    }

    private void launch() {
        try {
            numTimers++;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(R.getUi("timer.fxml"));

            ShowWatchController showWatchController = new ShowWatchController(numero);
            loader.setController(showWatchController);
            VBox downloadBox = loader.load();

            String filename = "Cuenta atras " + this.numTimers;
            tpTemporizadores.getTabs().add(new Tab(filename, downloadBox));

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void launchCronometro(ActionEvent event){
        try {
            numStopWatches++;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(R.getUi("timer.fxml"));

            ShowCronometroController showCronometroController = new ShowCronometroController();
            loader.setController(showCronometroController);
            VBox downloadBox = loader.load();

            String filename = "Cronometro " + this.numStopWatches;
            tpTemporizadores.getTabs().add(new Tab(filename, downloadBox));

        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
