package com.svalero.reloj.tasks;

import javafx.concurrent.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimerTask extends Task<Integer> {

    int seconds;
    private static final Logger logger = LogManager.getLogger(TimerTask.class);


    public TimerTask(int numero) {
        seconds = numero;

    }

    @Override
    protected Integer call() throws Exception {
        logger.trace("Timer iniciada");

        while (true){
            Thread.sleep(1000);
            seconds--;
            updateMessage(String.valueOf(seconds));
        }
    }
}
