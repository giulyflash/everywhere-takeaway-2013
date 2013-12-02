/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.everywheretakeaway.context.ResponseAndView;
import org.everywheretakeaway.context.ResponseObject;

/**
 *
 * @author Fede
 */
public class ViewDispatcher {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(ViewDispatcher.class.getName());



    protected RequestDispatcher dispatcher ;

    public ViewDispatcher(RequestDispatcher requestDispatcher) {
        dispatcher = requestDispatcher;
    }

    public void forward(HttpServletRequest req, HttpServletResponse res, ResponseAndView responseObject) throws ServletException, IOException {

        mergeDataRequest(req, responseObject.getResponseObject());

        dispatcher.forward(req,res);
    }

    private void mergeDataRequest(HttpServletRequest req, ResponseObject responseObject) {

        if (responseObject == null)
            return;

        for (Iterator listaParams = responseObject.getRequestKeys().iterator(); listaParams.hasNext(); ) {
            String key = (String) listaParams.next();
            req.setAttribute(key, responseObject.getValue(key));
            logger.log(Level.INFO, "Mappato attributo nella request: "+key+": "+responseObject.getValue(key));
        }

        for (Iterator listaParams = responseObject.getSessionKeys().iterator(); listaParams.hasNext(); ) {
            String key = (String) listaParams.next();
            req.getSession().setAttribute(key, responseObject.getValue(key));
            logger.log(Level.INFO, "Mappato attributo nella session: "+key+": "+responseObject.getValue(key));
        }
    }
}

