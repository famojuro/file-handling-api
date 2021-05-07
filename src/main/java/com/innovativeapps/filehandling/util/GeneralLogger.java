package com.innovativeapps.filehandling.util;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class GeneralLogger {

    private Logger logger = Logger.getLogger(GeneralLogger.class.getName());

    public GeneralLogger getLogger(String className){
        logger = Logger.getLogger(className);

        return this;
    }

    public void log(String message) {
        this.logger.info(message);
    }

}
