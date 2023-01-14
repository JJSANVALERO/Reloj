package com.svalero.reloj.tasks;

import javafx.concurrent.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

public class CronometroTask extends Task<Integer> {

    int numCronometro;
    private static final Logger logger = LogManager.getLogger(CronometroTask.class);

    public CronometroTask(){}

    @Override
    protected Integer call() throws Exception {
        logger.trace("Cronometro iniciado");

        while (true){
            Thread.sleep(1000);
            numCronometro++;
            updateMessage(String.valueOf(numCronometro));
        }
    }

}



