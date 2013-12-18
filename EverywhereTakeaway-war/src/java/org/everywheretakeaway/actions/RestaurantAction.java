/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.actions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.everywheretakeaway.business.CategoryManagerDelegate;
import org.everywheretakeaway.business.RestaurantManagerDelegate;
import org.everywheretakeaway.business.UserManagerDelegate;
import org.everywheretakeaway.context.ContextObjectFactory;
import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.context.ResponseAndView;
import org.everywheretakeaway.context.ResponseObject;
import org.everywheretakeaway.controller.Action;
import org.everywheretakeaway.model.Address;
import org.everywheretakeaway.model.OpeningTimes;
import org.everywheretakeaway.model.Restaurant;
import org.everywheretakeaway.model.User;
import org.everywheretakeaway.utils.MapsUtils;
import org.everywheretakeaway.utils.Validation;

/**
 *
 * @author Fede
 */
public class RestaurantAction implements Action {
    
    private static final Logger logger = Logger.getLogger(RestaurantAction.class.getName());
    
    public RestaurantManagerDelegate rm = new RestaurantManagerDelegate();
    public UserManagerDelegate um = new UserManagerDelegate();
    public CategoryManagerDelegate cm = new CategoryManagerDelegate();
    
    
    public ResponseAndView createResponseAndView(RequestObject requestObject) {
    
        ResponseObject response = ContextObjectFactory.getResponseObject();

        String command = requestObject.getRequestCommmand();    
        
        Restaurant r;
        User u;
        
        double user_latitude;
        double user_longitude;
        
        Iterator<Restaurant> iterator;
        Restaurant current;
        double currentDistance;
        //List<RestaurantDistance> orderedRestaurants;
        
        List<Restaurant> orderedRestaurants;
        List<Double> orderedDistances;
        
        
        int i;
        
        switch(command) {
            
            case "enter_address":
                
                // Se l'utente non è loggato gli mostro la pagina per inserire l'indirizzo altrimenti vado nel caso successivo
                // dello switch, ovvero choose_restaurant
                if(requestObject.getSessionValue("id") == null)
                    
                    return new ResponseAndView(response, "enter_address");
                
            
            // NON INSERIRE NULLA QUI
            
            case "choose_restaurant":
                                
                // Se l'utente è loggato inserisco latitudine e longitudine in sessione
                if(requestObject.getSessionValue("id") != null && (requestObject.getValue("user_latitude") == null || requestObject.getValue("user_longitude") == null)) {
                    u = um.find((Long)requestObject.getSessionValue("id"));
                    response.setValueInSession("user_latitude",((Double)(u.getAddress().getLatitude())).toString());
                    response.setValueInSession("user_longitude",((Double)(u.getAddress().getLongitude())).toString());
                // Se l'utente non è loggato ma ha già inserito latitudine e longitudine, li inserisco in sessione
                } else if(requestObject.getSessionValue("id") == null && requestObject.getValue("user_latitude") != null && requestObject.getValue("user_longitude") != null) {
                    response.setValueInSession("user_latitude",(String)requestObject.getValue("user_latitude"));
                    response.setValueInSession("user_longitude", (String)requestObject.getValue("user_longitude"));    
                    //logger.log(Level.INFO, "Settati valori in sessione");
                } 
                
                
                if(requestObject.getValue("user_latitude") != null && requestObject.getValue("user_longitude") != null) {
                
                    user_latitude = Double.parseDouble((String)requestObject.getValue("user_latitude"));
                    user_longitude = Double.parseDouble((String)requestObject.getValue("user_longitude"));

                    if(requestObject.getValue("category_id") != null && !((String)requestObject.getValue("category_id")).equals("")) {
                        iterator = rm.find(cm.find(Long.parseLong((String)requestObject.getValue("category_id")))).iterator();
                        response.setValue("selected_id",Long.parseLong((String)requestObject.getValue("category_id")));
                    } else {
                        iterator = rm.find().iterator();
                    }
                    
                    orderedRestaurants = new LinkedList<Restaurant>();
                    orderedDistances = new LinkedList<Double>();

                    // Scorro tutti i ristoranti
                    while(iterator.hasNext()) {

                        current = iterator.next();
                        
                        currentDistance = MapsUtils.distanceBetweenTwoPoints(user_latitude, user_longitude, current.getAddress().getLatitude(), current.getAddress().getLongitude());
                        // Se l'indirizzo dell'utente è nel raggio di consegna del ristorante aggiungo il ristorante in ordine di distanza
                        if(current.getMaxKm() >= currentDistance) {

                            i=0;
                            while(i < orderedDistances.size() && (orderedDistances.get(i) < currentDistance )) {

                                i++;

                            }

                            // Aggiungo il ristorante nella posizione corretta
                            orderedRestaurants.add(i, current);
                            orderedDistances.add(i, currentDistance);

                        }

                    }

                    response.setValue("categories",cm.find());
                    response.setValue("orderedRestaurants", orderedRestaurants);
                    response.setValue("orderedDistances", orderedDistances);

                    return new ResponseAndView(response, "choose_restaurant");
                    
                } else {
                
                    return new ResponseAndView(response, "enter_address");
                
                }
            
            case "show_user_restaurants":
                
                if(requestObject.getSessionValue("id") != null) {
                
                    response.setValue("list",rm.find(um.find((Long)requestObject.getSessionValue("id"))));
                
                    return new ResponseAndView(response, "show_user_restaurants");
                    
                } else {
                
                    response.setValue("esito", "Devi effettuare il login per utilizzare questa funzione");
                
                    return new ResponseAndView(response, "main");
                }
            
            case "add_restaurant":
                                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("seller")) {
                
                    return new ResponseAndView(response, "add_restaurant");
                    
                 } else if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("buyer")) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati come venditori");
                    return new ResponseAndView(response, "main");
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati");
                    return new ResponseAndView(response, "main");
                    
                }
                
                //break;
        
            case "send_add_restaurant":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("seller")) {
                
                    if(MapsUtils.validateAddress((String)requestObject.getValue("street"),(String)requestObject.getValue("postalCode"),(String)requestObject.getValue("city"),Double.parseDouble((String)requestObject.getValue("latitude")),Double.parseDouble((String)requestObject.getValue("longitude"))))
                        logger.log(Level.INFO, "true");
                    else
                        logger.log(Level.INFO, "false");

                    if(Validation.validateName((String)requestObject.getValue("name")) &&
                            MapsUtils.validateAddress((String)requestObject.getValue("street"),(String)requestObject.getValue("postalCode"),(String)requestObject.getValue("city"),Double.parseDouble((String)requestObject.getValue("latitude")),Double.parseDouble((String)requestObject.getValue("longitude"))) &&
                            Validation.validateVat((String)requestObject.getValue("vat")) &&                        
                            Validation.validateOpeningTimes((String)requestObject.getValue("morningOpening"),(String)requestObject.getValue("morningClosing"),(String)requestObject.getValue("afternoonOpening"),(String)requestObject.getValue("afternoonClosing")) &&
                            Validation.validatePhone((String)requestObject.getValue("phone")) &&  
                            Validation.validateEmail((String)requestObject.getValue("email")) &&  
                            Validation.validateMaxKm((String)requestObject.getValue("maxKm")) 
                            ) {

                        Address address = new Address((String)requestObject.getValue("street"),(String)requestObject.getValue("postalCode"),(String)requestObject.getValue("city"),Double.parseDouble((String)requestObject.getValue("latitude")),Double.parseDouble((String)requestObject.getValue("longitude")));
                        OpeningTimes openingTimes = new OpeningTimes((String)requestObject.getValue("morningOpening"),(String)requestObject.getValue("morningClosing"),(String)requestObject.getValue("afternoonOpening"),(String)requestObject.getValue("afternoonClosing"));
                        User owner = um.find((Long)requestObject.getSessionValue("id"));

                        Restaurant restaurant = new Restaurant((String)requestObject.getValue("name"),address,owner,(String)requestObject.getValue("vat"),(String)requestObject.getValue("email"),openingTimes,(String)requestObject.getValue("phone"),Integer.parseInt((String)requestObject.getValue("maxKm")));

                        rm.add(restaurant);

                        //um.add(new User((String)requestObject.getValue("name"),(String)requestObject.getValue("surname"),(String)requestObject.getValue("address"),(String)requestObject.getValue("phone"),(String)requestObject.getValue("email"),(String)requestObject.getValue("cf"),(String)requestObject.getValue("birthday"),(String)requestObject.getValue("type"),(String)requestObject.getValue("passwd")));

                        response.setValue("esito", "Locale inserito correttamente");

                    } else {

                        response.setValue("esito", "Campi non corretti o imcompleti");

                    }
                
                } else if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("buyer")) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati come venditori");
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati");
                    
                }
                    
                    
                return new ResponseAndView(response, "main");
                
            case "delete_restaurant":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("seller") && requestObject.getValue("restaurant_id") != null) {
                    
                    //logger.log(Level.INFO, (String)requestObject.getValue("restaurant_id"));
                    
                    r = rm.find(Long.parseLong((String)requestObject.getValue("restaurant_id")));
                                        
                    if( (r != null) && (r.getOwner().getId().equals((Long)requestObject.getSessionValue("id"))) ) {
                    
                        rm.delete(r);
                        response.setValue("esito", "Ristorante eliminato correttamente");
                    
                    } else {
                        response.setValue("esito", "Ristorante non esistente o non appartenente all\'utente");
                    }
                    
                    
                } else if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("buyer")) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati come venditori");
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire l\'id di un ristorante");
                    
                }
            
                return new ResponseAndView(response, "main");
                
            case "update_restaurant":
                
                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("seller") && requestObject.getValue("restaurant_id") != null) {
                    
                    //logger.log(Level.INFO, (String)requestObject.getValue("restaurant_id"));
                    
                    r = rm.find(Long.parseLong((String)requestObject.getValue("restaurant_id")));
                    
                    if( (r != null) && (r.getOwner().getId().equals((Long)requestObject.getSessionValue("id"))) ) {
                    
                        response.setValue("restaurant",r);
                        return new ResponseAndView(response, "update_restaurant");
                    
                    } else {
                        response.setValue("esito", "Ristorante non esistente o non appartenente all\'utente");
                    }                    
                    
                
                } else if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("buyer")) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati come venditori");
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire l\'id di un ristorante");
                    
                }
                
                return new ResponseAndView(response, "main");
                
            case "send_update_restaurant":

                if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("seller") && requestObject.getValue("restaurant_id") != null) {
                    
                    //logger.log(Level.INFO, (String)requestObject.getValue("restaurant_id"));
                    
                    r = rm.find(Long.parseLong((String)requestObject.getValue("restaurant_id")));
                    
                    if( (r != null) && (r.getOwner().getId().equals((Long)requestObject.getSessionValue("id"))) ) {
                    
                        if(Validation.validateName((String)requestObject.getValue("name")) &&
                            MapsUtils.validateAddress((String)requestObject.getValue("street"),(String)requestObject.getValue("postalCode"),(String)requestObject.getValue("city"),Double.parseDouble((String)requestObject.getValue("latitude")),Double.parseDouble((String)requestObject.getValue("longitude"))) &&
                            Validation.validateVat((String)requestObject.getValue("vat")) &&                        
                            Validation.validateOpeningTimes((String)requestObject.getValue("morningOpening"),(String)requestObject.getValue("morningClosing"),(String)requestObject.getValue("afternoonOpening"),(String)requestObject.getValue("afternoonClosing")) &&
                            Validation.validateEmail((String)requestObject.getValue("email")) &&  
                            Validation.validatePhone((String)requestObject.getValue("phone")) &&  
                            Validation.validateMaxKm((String)requestObject.getValue("maxKm")) 
                            ) {
                            
                            r.setName((String)requestObject.getValue("name"));
                            r.getAddress().setStreet((String)requestObject.getValue("street"));
                            r.getAddress().setPostalCode((String)requestObject.getValue("postalCode"));
                            r.getAddress().setCity((String)requestObject.getValue("city"));
                            r.getAddress().setLatitude(Double.parseDouble((String)requestObject.getValue("latitude")));
                            r.getAddress().setLongitude(Double.parseDouble((String)requestObject.getValue("longitude")));
                            r.setVat((String)requestObject.getValue("vat"));
                            r.getOpeningTimes().setMorningOpening((String)requestObject.getValue("morningOpening"));
                            r.getOpeningTimes().setMorningClosing((String)requestObject.getValue("morningClosing"));
                            r.getOpeningTimes().setAfternoonOpening((String)requestObject.getValue("afternoonOpening"));
                            r.getOpeningTimes().setAfternoonClosing((String)requestObject.getValue("afternoonClosing"));
                            r.setPhone((String)requestObject.getValue("phone"));
                            r.setMaxKm(Integer.parseInt((String)requestObject.getValue("maxKm")));
                            r.setEmailAddress((String)requestObject.getValue("email"));
                            
                            rm.update(r);
                            
                            response.setValue("esito", "Ristorante modificato correttamente");
                            
                            
                        } else {
                        
                            response.setValue("esito", "Campi non corretti");
                        
                        }
                    
                    } else {
                        response.setValue("esito", "Ristorante non esistente o non appartenente all\'utente");
                    }  
                
                } else if(requestObject.getSessionValue("id") != null && requestObject.getSessionValue("type").equals("buyer")) {
                    
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati come venditori");
                    
                } else {
                
                    response.setValue("esito", "Per utilizzare la funzione è necessario essere registrati e fornire l\'id di un ristorante");
                    
                }                
                
                
                return new ResponseAndView(response, "main");
                
            default:
                
                
                
                throw new IllegalArgumentException("Invalid command");
        }        
        
    }
    
}
