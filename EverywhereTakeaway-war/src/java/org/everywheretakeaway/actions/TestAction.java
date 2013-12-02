/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.actions;

import org.everywheretakeaway.context.ContextObjectFactory;
import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.context.ResponseAndView;
import org.everywheretakeaway.context.ResponseObject;
import org.everywheretakeaway.controller.Action;

/**
 *
 * @author Fede
 */
public class TestAction implements Action {
    
    public ResponseAndView createResponseAndView(RequestObject requestObject) {

        ResponseObject response = ContextObjectFactory.getResponseObject();

        String titolo = (String) requestObject.getValue("titolo");
        if (titolo == null)
                titolo = "PaginaPrincipale";

        String body = "Questa è la pagina principale";

        response.setValue("titolo",titolo);
        response.setValue("contenuto",body);

        return new ResponseAndView(response, "main");
    }
    
}
