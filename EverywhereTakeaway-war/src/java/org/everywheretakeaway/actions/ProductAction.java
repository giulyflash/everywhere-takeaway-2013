/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.actions;

import java.util.List;
import java.util.logging.Logger;
import org.everywheretakeaway.business.CategoryManagerDelegate;
import org.everywheretakeaway.business.ProductManagerDelegate;
import org.everywheretakeaway.business.RestaurantManagerDelegate;
import org.everywheretakeaway.context.ContextObjectFactory;
import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.context.ResponseAndView;
import org.everywheretakeaway.context.ResponseObject;
import org.everywheretakeaway.controller.Action;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Product;
import org.everywheretakeaway.model.Restaurant;
import org.everywheretakeaway.utils.Validation;

/**
 *
 * @author Fede
 */
public class ProductAction implements Action {
    
    private static final Logger logger = Logger.getLogger(ProductAction.class.getName());
    
    public ProductManagerDelegate pm = new ProductManagerDelegate();
    public RestaurantManagerDelegate rm = new RestaurantManagerDelegate();
    public CategoryManagerDelegate cm = new CategoryManagerDelegate();
    
    public ResponseAndView createResponseAndView(RequestObject requestObject) {
    
        ResponseObject response = ContextObjectFactory.getResponseObject();

        String command = requestObject.getRequestCommmand();    
        
        Product p;
        Category c;
        Restaurant r;
        List<Category> categories;
        
        switch(command) {  
            
            case "choose_product":
                
                if(requestObject.getValue("restaurant_id") != null) {
                
                    response.setValue("restaurant_id",(String)requestObject.getValue("restaurant_id"));
                    
                    response.setValue("categories",cm.find());
                    
                    if(requestObject.getValue("category_id") != null && !((String)requestObject.getValue("category_id")).equals("")) {
                        response.setValue("list",pm.find(rm.find(Long.parseLong((String)requestObject.getValue("restaurant_id"))),cm.find(Long.parseLong((String)requestObject.getValue("category_id")))));
                        response.setValue("selected_id",Long.parseLong((String)requestObject.getValue("category_id")));
                    } else {
                        response.setValue("list",pm.find(rm.find(Long.parseLong((String)requestObject.getValue("restaurant_id")))));
                    }                
                    
                    return new ResponseAndView(response, "choose_product");
                                        
                } else {
                
                    response.setValue("esito", "Devi fornire l\'id di un ristorante per utilizzare questa funzione");
                
                    return new ResponseAndView(response, "main");
                }                 
                
                
            
            case "show_restaurant_products":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getValue("restaurant_id") != null) {
                
                    response.setValue("list",pm.find(rm.find(Long.parseLong((String)requestObject.getValue("restaurant_id")))));
                    response.setValue("restaurant_id",(String)requestObject.getValue("restaurant_id"));
                
                    return new ResponseAndView(response, "show_restaurant_products");
                    
                } else if(requestObject.getSessionValue("id") != null) {
                
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                
                    return new ResponseAndView(response, "main");
                    
                } else {
                
                    response.setValue("esito", "Devi fornire l\'id di un ristorante per utilizzare questa funzione");
                
                    return new ResponseAndView(response, "main");
                } 
            
            case "add_product":
                
                categories = cm.find();
                
                if(requestObject.getSessionValue("id") != null && requestObject.getValue("restaurant_id") != null) {
                
                    response.setValue("categories",categories);
                    response.setValue("restaurant_id",(String)requestObject.getValue("restaurant_id"));
                
                    return new ResponseAndView(response, "add_product");
                    
                } else if(requestObject.getSessionValue("id") != null) {
                
                    response.setValue("esito", "Devi fornire l\'id di un ristorante per utilizzare questa funzione");
                    
                    return new ResponseAndView(response, "main");
                    
                } else {
                
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                
                    return new ResponseAndView(response, "main");
                }              
            
            case "send_add_product":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getValue("restaurant_id") != null) {
                    
                    r = rm.find(Long.parseLong((String)requestObject.getValue("restaurant_id")));
                    
                    if(r.getOwner().getId().equals(requestObject.getSessionValue("id")) &&
                            Validation.validateName((String)requestObject.getValue("name")) &&
                            Validation.validatePrice((String)requestObject.getValue("price")) &&
                            Validation.validateDescription((String)requestObject.getValue("description")) &&
                            Validation.validateId((String)requestObject.getValue("category_id")) 
                            ) {
                    
                        c = cm.find(Long.parseLong((String)requestObject.getValue("category_id")));
                        
                        p = new Product(c,(String)requestObject.getValue("name"),Double.parseDouble((String)requestObject.getValue("price")),(String)requestObject.getValue("description"),"img/default_product.jpg",r);
                        pm.add(p);
                        
                        response.setValue("esito", "Prodotto inserito correttamente");
                    
                    } else {
                    
                        response.setValue("esito", "Parametri non corretti");
                    
                    }
                
                    return new ResponseAndView(response, "main");
                    
                } else if(requestObject.getSessionValue("id") != null) {
                
                    response.setValue("esito", "Parametri non corretti");
                
                    return new ResponseAndView(response, "main");
                    
                } else {
                
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                    
                    return new ResponseAndView(response, "main");
                } 
            
            case "delete_product":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getValue("product_id") != null) {
                    
                    //logger.log(Level.INFO, (String)requestObject.getValue("restaurant_id"));
                    
                    p = pm.find(Long.parseLong((String)requestObject.getValue("product_id")));
                    
                    if( (p != null) && (p.getRestaurant().getOwner().getId().equals(requestObject.getSessionValue("id"))) ) {
                    
                        pm.delete(p);
                        response.setValue("esito", "Prodotto eliminato correttamente");
                    
                    } else {
                        response.setValue("esito", "Prodotto non esistente o non appartenente all\'utente");
                    }
                    
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire l\'id di un ristorante");
                    
                }
            
                return new ResponseAndView(response, "main"); 
                
            case "update_product":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getValue("product_id") != null) {
                    
                    //logger.log(Level.INFO, (String)requestObject.getValue("restaurant_id"));
                    
                    p = pm.find(Long.parseLong((String)requestObject.getValue("product_id")));
                    
                    if( (p != null) && (p.getRestaurant().getOwner().getId().equals(requestObject.getSessionValue("id"))) ) {
                        
                        categories = cm.find();                    
                        response.setValue("categories",categories);
                        
                        response.setValue("product",p);
                        return new ResponseAndView(response, "update_product");
                    
                    } else {
                        response.setValue("esito", "Prodotto non esistente o non appartenente all\'utente");
                    }                    
                    
                
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire l\'id di un prodotto");
                    
                }
                
                return new ResponseAndView(response, "main");   
                
            case "send_update_product":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getValue("product_id") != null) {
                    
                    //logger.log(Level.INFO, (String)requestObject.getValue("restaurant_id"));
                    
                    p = pm.find(Long.parseLong((String)requestObject.getValue("product_id")));
                    
                    if( (p != null) && (p.getRestaurant().getOwner().getId().equals(requestObject.getSessionValue("id"))) ) { 
                        
                        if(Validation.validateName((String)requestObject.getValue("name")) &&
                                Validation.validatePrice((String)requestObject.getValue("price")) &&
                                Validation.validateDescription((String)requestObject.getValue("description")) &&
                                Validation.validateId((String)requestObject.getValue("category_id")) 
                                ) {                        
                            
                            c = cm.find(Long.parseLong((String)requestObject.getValue("category_id")));
                            
                            p.setName((String)requestObject.getValue("name"));
                            p.setPrice(Double.parseDouble((String)requestObject.getValue("price")));
                            p.setDescription((String)requestObject.getValue("description"));
                            p.setCategory(c);
                            
                            pm.update(p);
                            
                            response.setValue("esito", "Prodotto modificato correttamente");
                            
                        } else {
                    
                            response.setValue("esito", "Impossibile modificare il prodotto, parametri non corretti");
                    
                        }    
                        
                    } else {
                        response.setValue("esito", "Prodotto non esistente o non appartenente all\'utente");
                    }                    
                    
                
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire l\'id di un prodotto");
                    
                }
                
                return new ResponseAndView(response, "main");  
                
            case "upload_product_picture":
                
                
                if(requestObject.getSessionValue("id") != null && requestObject.getValue("product_id") != null) {
                
                    //Gestito da servlet

                    p = pm.find(Long.parseLong((String)(requestObject.getValue("product_id"))));

                    if(requestObject.getValue("esito_upload") != null && ((String)requestObject.getValue("esito_upload")).equals("true") && p != null && (p.getRestaurant().getOwner().getId().equals(requestObject.getSessionValue("id")))) {

                        p.setUrlImage((String)requestObject.getValue("img_path"));
                        pm.update(p);
                        response.setValue("esito", "Immagine modificata correttamente");
                        
                    } else {
                        response.setValue("esito", (String)requestObject.getValue("esito_upload"));
                    }
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire l\'id di un prodotto");
                
                }
                    
                return new ResponseAndView(response, "main");                
                
            default:               
                
                throw new IllegalArgumentException("Invalid command");                
            
        }  
        
    }
    
        
}
