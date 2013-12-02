/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.everywheretakeaway.configuration.Configuration;
import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.exception.EverywhereTakeawayException;

/**
 *
 * @author Fede
 */
public class ActionFactory {

    private static final Logger logger = Logger.getLogger(ActionFactory.class.getName());

    protected static Map actions = new HashMap();

    public static Action createAction(RequestObject requestObject) {

        Action action = (Action) actions.get(requestObject.getRequestCommmand());

        if (action == null) {
            
            String actionClassName = Configuration.getAction(requestObject.getRequestCommmand());
            if (actionClassName == null)
                throw new EverywhereTakeawayException(EverywhereTakeawayException.ACTION_ERROR, "Non esiste nessuna action chiamata "+requestObject.getRequestCommmand());
            try {
                action = (Action) Class.forName(actionClassName).newInstance();
                actions.put(requestObject.getRequestCommmand(), action);
            }
            catch (Throwable t) {
                logger.log(Level.SEVERE, "Impossibile istanziare l'action "+actionClassName);
                throw new EverywhereTakeawayException(EverywhereTakeawayException.ACTION_ERROR, actionClassName, t);
            }
        }

        return action;
    }

}
