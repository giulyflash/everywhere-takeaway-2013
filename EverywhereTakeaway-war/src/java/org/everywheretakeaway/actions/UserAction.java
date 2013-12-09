/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    //TODO
    //Mettere come unica la colonna email
    
    public User checkLogin(String email,String password) {
    
        User u = um.find(email,password);
        
        if(u != null) {
            
            return u;
            
        } else {
        
            return null;
            
        }
    
    
    }
    
    public ResponseAndView createResponseAndView(RequestObject requestObject) {

        ResponseObject response = ContextObjectFactory.getResponseObject();

        String command = requestObject.getRequestCommmand();
        
        User u;
        
        switch(command) {
            
            case "update_password":
                
                if(requestObject.getSessionValue("id") != null) {
                    
                    return new ResponseAndView(response, "update_password");
                    
                } else {
                
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                    return new ResponseAndView(response, "main");
                
                }
            
            case "send_update_password":
                
                if(requestObject.getSessionValue("id") != null) {
                
                    u = um.find((Long)requestObject.getSessionValue("id"));
                    
                    if(Validation.validatePassword((String)requestObject.getValue("new_password"),(String)requestObject.getValue("confirm_new_password")) &&
                            ((String)u.getPassword()).equals((String)requestObject.getValue("old_password"))) {
                        
                        u.setPassword((String)requestObject.getValue("new_password"));
                    
                        um.update(u);
                        
                        response.setValue("esito", "Password mofiicata correttamente");
                        
                    } else {
                    
                        response.setValue("esito", "Modifica non effettuata, password inserite non corrette");
                    
                    }                  
                    
                } else {
                
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                
                }
                
                return new ResponseAndView(response, "main");
            
            case "update_profile":
                
                if(requestObject.getSessionValue("id") != null) {
                    
                    u = um.find((Long)requestObject.getSessionValue("id"));
                    response.setValue("user",u);
                    return new ResponseAndView(response, "update_profile");
                    
                } else {
                    
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                    return new ResponseAndView(response, "main");
                    
                }
                    
                
            
            case "send_update_profile":
                
                if(requestObject.getSessionValue("id") != null) {
                                    
                    
                    if(Validation.validateName((String)requestObject.getValue("name")) &&
                        Validation.validateSurname((String)requestObject.getValue("surname")) &&
                        Validation.validateAddress((String)requestObject.getValue("address")) &&
                        Validation.validatePhone((String)requestObject.getValue("phone")) &&
                        Validation.validateEmail((String)requestObject.getValue("email")) &&
                        Validation.validateCF((String)requestObject.getValue("cf")) && 
                        Validation.validateBirthday((String)requestObject.getValue("birthday"))
                        ) {
                        
                        u = um.find((Long)requestObject.getSessionValue("id"));
                        
                        u.setName((String)requestObject.getValue("name"));
                        u.setSurname((String)requestObject.getValue("surname"));
                        u.setAddress((String)requestObject.getValue("address"));
                        u.setPhone((String)requestObject.getValue("phone"));
                        u.setEmailAddress((String)requestObject.getValue("email"));
                        u.setCf((String)requestObject.getValue("cf"));
                        try {
                            u.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse((String)requestObject.getValue("birthday")));
                        } catch(ParseException pe) {
                            logger.log(Level.SEVERE, pe.toString());
                        }
                        
                        um.update(u);
                        
                        response.setValueInSession("name", u.getName());
                        response.setValueInSession("email", u.getEmailAddress());
                        
                        response.setValue("esito", "Modifica effettuata correttamente");
                    } else {
                        response.setValue("esito", "Modifica non effettuata. Valori non corretti.");
                    }
                                        
                } else {
                    
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                    
                    
                }
                    
                return new ResponseAndView(response, "main");
            
            case "upload_photo":
                
                //Gestito da servlet
                              
                if(requestObject.getValue("esito_upload") != null && ((String)requestObject.getValue("esito_upload")).equals("true")) {
                    u = um.find((Long)(requestObject.getSessionValue("id")));
                    u.setPictureUrl((String)requestObject.getValue("img_path"));
                    um.update(u);
                    response.setValue("esito", "Immagine modificata correttamente");
                } else {
                    response.setValue("esito", (String)requestObject.getValue("esito_upload"));
                }
                    
                return new ResponseAndView(response, "main");
            
            case "logout":
                
                //Gestito da servlet
                
                if(requestObject.getSessionValue("id") != null)
                
                    response.setValue("esito", "Logout effettuato correttamente");
                
                else
                    
                    response.setValue("esito", "L'utente non era loggato");
                
                return new ResponseAndView(response, "main");
            
            case "login":
                
                return new ResponseAndView(response, "login");
                
            case "send_login":
                
                String email = ((String)requestObject.getValue("email")).trim();
                String password = (String)requestObject.getValue("passwd");
                
                u = checkLogin(email,password);
                
                if(u != null) {

                    response.setValueInSession("email", email);
                    response.setValueInSession("type", u.getType());
                    response.setValueInSession("id", u.getId());
                    response.setValueInSession("name", u.getName());

                    response.setValue("esito", "OK");
                    
                } else {
                
                    response.setValue("esito", "NO");
                
                }
        
                return new ResponseAndView(response, "main");
            
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
                        Validation.validateBirthday((String)requestObject.getValue("birthday")) &&
                        Validation.validateType((String)requestObject.getValue("type")) &&
                        Validation.validatePassword((String)requestObject.getValue("passwd"),(String)requestObject.getValue("confirm_passwd")) 
                        ) {
                    
                    um.add(new User((String)requestObject.getValue("name"),(String)requestObject.getValue("surname"),(String)requestObject.getValue("address"),(String)requestObject.getValue("phone"),(String)requestObject.getValue("email"),(String)requestObject.getValue("cf"),(String)requestObject.getValue("birthday"),(String)requestObject.getValue("type"),(String)requestObject.getValue("passwd")));

                    response.setValue("esito", "OK");
                    
                } else {
                
                    response.setValue("esito", "NO");
                
                }
                
                
                return new ResponseAndView(response, "main");
                
                //break;
                
            case "show_profile":
                
                if(requestObject.getSessionValue("email") != null) {
                
                    response.setValue("user",um.find((String)requestObject.getSessionValue("email")));
                
                    return new ResponseAndView(response, "show_profile");
                    
                } else {
                
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                
                    return new ResponseAndView(response, "main");
                }
                
                
            default:
                
                throw new IllegalArgumentException("Invalid command");
        
        
        
        
        
        }
        
        
        
        
        

        
    }    
    
}
