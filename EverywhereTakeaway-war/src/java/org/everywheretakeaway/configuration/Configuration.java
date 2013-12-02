/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;

/**
 *
 * @author Fede
 */
public class Configuration {

private static final Logger logger = Logger.getLogger(Configuration.class.getName());

protected static Properties views;
protected static Properties actions;

public static void init(ServletConfig config) {
    String actionFile = config.getServletContext().getRealPath("WEB-INF/actions.properties");
    String viewFile = config.getServletContext().getRealPath("WEB-INF/views.properties");

    views = new Properties();
    actions = new Properties();

    try {
        views.load(new FileInputStream(viewFile));
        actions.load(new FileInputStream(actionFile));
    } catch (FileNotFoundException e) {
        logger.log(Level.SEVERE, "File di configurazione non trovato");
        //e.printStackTrace();
    } catch (IOException e) {
        logger.log(Level.SEVERE, "Impossibile leggere il file di configurazione");
        //e.printStackTrace();
    }
    
    logger.log(Level.INFO, "Caricate "+actions.size()+" actions e "+views.size()+" views");
}

public static String getViewPage(String view) {
    return views.getProperty(view);
}

public static String getAction(String action) {
    return actions.getProperty(action);
}




}
