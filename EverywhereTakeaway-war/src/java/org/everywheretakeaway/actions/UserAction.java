/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.actions;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.everywheretakeaway.business.UserManagerDelegate;
import org.everywheretakeaway.context.ContextObjectFactory;
import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.context.ResponseAndView;
import org.everywheretakeaway.context.ResponseObject;
import org.everywheretakeaway.controller.Action;
import org.everywheretakeaway.controller.ActionFactory;
import org.everywheretakeaway.model.User;
import org.everywheretakeaway.utils.Validation;

/**
 *
 * @author Fede
 */
public class UserAction implements Action {
    
    private static final Logger logger = Logger.getLogger(ActionFactory.class.getName());
    
    public UserManagerDelegate um = new UserManagerDelegate();
    
    public boolean validateRegistrationRequest(RequestObject requestObject) {
    
        
        
        return true;
    
    
    }
    
    public ResponseAndView createResponseAndView(RequestObject requestObject) {

        ResponseObject response = ContextObjectFactory.getResponseObject();

        String command = requestObject.getRequestCommmand();
        
        switch(command) {
            
            case "register":
                                
                return new ResponseAndView(response, "register");
                
                //break;
        
            case "send_registration":
                
                //if(requestObject.getValue("name") != null)
                
                logger.log(Level.INFO, "Date: "+(String)requestObject.getValue("birthday"));
                
                if(Validation.validateName((String)requestObject.getValue("name")) &&
                        Validation.validateSurname((String)requestObject.getValue("surname")) &&
                        Validation.validateAddress((String)requestObject.getValue("address")) &&
                        Validation.validatePhone((String)requestObject.getValue("phone")) &&
                        Validation.validateEmail((String)requestObject.getValue("email")) &&
                        Validation.validateCF((String)requestObject.getValue("cf")) && 
                        Validation.validateBirthday((String)requestObject.getValue("birthday"))
                        ) {
                    
                    um.add(new User((String)requestObject.getValue("name"),(String)requestObject.getValue("surname"),(String)requestObject.getValue("address"),(String)requestObject.getValue("phone"),(String)requestObject.getValue("email"),(String)requestObject.getValue("cf"),(String)requestObject.getValue("birthday")));

                    response.setValue("esito", "OK");
                    
                } else {
                
                    response.setValue("esito", "NO");
                
                }
                
                
                return new ResponseAndView(response, "main");
                
                //break;
                
                
            default:
                
                throw new IllegalArgumentException("Invalid command");
        
        
        
        
        
        }
        
        
        
        
        

        
    }    
    
}
