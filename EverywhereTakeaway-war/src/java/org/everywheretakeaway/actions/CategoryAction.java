/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.actions;

import java.util.List;
import java.util.logging.Logger;
import org.everywheretakeaway.business.CategoryManagerDelegate;
import org.everywheretakeaway.context.ContextObjectFactory;
import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.context.ResponseAndView;
import org.everywheretakeaway.context.ResponseObject;
import org.everywheretakeaway.controller.Action;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.utils.Validation;

/**
 *
 * @author Fede
 */
public class CategoryAction implements Action {
    
    private static final Logger logger = Logger.getLogger(CategoryAction.class.getName());
    
    public CategoryManagerDelegate cm = new CategoryManagerDelegate();
        
    public ResponseAndView createResponseAndView(RequestObject requestObject) {
    
        ResponseObject response = ContextObjectFactory.getResponseObject();

        String command = requestObject.getRequestCommmand();    
        
        Category c;
        
        switch(command) {
            
            case "show_categories":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("admin")) {
                    
                    List<Category> list = cm.find();
                    
                    response.setValue("categories",list);
                    
                    return new ResponseAndView(response, "show_categories");
                    
                    
                 } else if(requestObject.getSessionValue("id") != null && !(requestObject.getSessionValue("type").equals("admin"))) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere amministratori");
                    return new ResponseAndView(response, "main");
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati");
                    return new ResponseAndView(response, "main");
                    
                }
            
            case "add_category":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("admin")) {
                    
                    return new ResponseAndView(response, "add_category");
                    
                    
                 } else if(requestObject.getSessionValue("id") != null && !(requestObject.getSessionValue("type").equals("admin"))) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere amministratori");
                    return new ResponseAndView(response, "main");
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati");
                    return new ResponseAndView(response, "main");
                    
                }
            
            case "send_add_category":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("admin")) {
                    
                    if(Validation.validateName((String)requestObject.getValue("name"))) {
                    
                        cm.add(new Category((String)requestObject.getValue("name")));
                        response.setValue("esito", "Categoria inserita correttamente");
                    
                    } else {

                        response.setValue("esito", "Campi non corretti o imcompleti");

                    }
                    
                    
                 } else if(requestObject.getSessionValue("id") != null && !(requestObject.getSessionValue("type").equals("admin"))) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere amministratori");
                    
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati");
                    
                }
                    
                return new ResponseAndView(response, "main");
                
            case "delete_category":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("admin") && requestObject.getValue("category_id") != null) {
                    
                    cm.delete(cm.find(Long.parseLong((String)requestObject.getValue("category_id"))));
                    
                    response.setValue("esito", "Categoria eliminata correttamente");
                           
                    
                 } else if(requestObject.getSessionValue("id") != null && !(requestObject.getSessionValue("type").equals("admin"))) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere amministratori");
                    
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire un id di categoria");
                    
                }
                    
                return new ResponseAndView(response, "main");         
                
            case "update_category":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("admin") && requestObject.getValue("category_id") != null) {
                    
                    response.setValue("category",cm.find(Long.parseLong((String)requestObject.getValue("category_id"))));
                
                    return new ResponseAndView(response, "update_category");  
                    
                 } else if(requestObject.getSessionValue("id") != null && !(requestObject.getSessionValue("type").equals("admin"))) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere amministratori");
                    return new ResponseAndView(response, "main");  
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire un id di categoria");
                    return new ResponseAndView(response, "main");  
                    
                }
                    
            case "send_update_category":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("admin") && requestObject.getValue("category_id") != null) {
                    
                    if(Validation.validateName((String)requestObject.getValue("name"))) {
                        
                        c = cm.find(Long.parseLong((String)requestObject.getValue("category_id")));
                        
                        c.setName((String)requestObject.getValue("name"));
                        
                        cm.update(c);
                        
                        response.setValue("esito", "Categoria modificata correttamente");
                        
                    } else {
                    
                        response.setValue("esito", "Campi non corretti");
                        
                    }
                           
                    
                 } else if(requestObject.getSessionValue("id") != null && !(requestObject.getSessionValue("type").equals("admin"))) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere amministratori");
                    
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire un id di categoria");
                    
                }
                    
                return new ResponseAndView(response, "main");            
                                
                
            
            default:                     
                
                throw new IllegalArgumentException("Invalid command");
        }
        
    }
}
