/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business;

import java.util.List;
import java.util.logging.Logger;
import org.everywheretakeaway.actions.RestaurantAction;
import org.everywheretakeaway.business.beans.RestaurantManager;
import org.everywheretakeaway.model.Restaurant;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
public class RestaurantManagerDelegate extends AbstractDelegate {
    
    private static final Logger logger = Logger.getLogger(RestaurantManagerDelegate.class.getName());
    
    public String getServiceName() {
    
        return "java:comp/env/ejb/RestaurantManager";
    
    }    
    
    public void update(Restaurant r) {
    
        ((RestaurantManager)getService()).update(r);
    
    }
    
    public void delete(Restaurant r) {
    
        ((RestaurantManager)getService()).delete(r);
    
    }
    
    public void add(Restaurant r) {
                
        ((RestaurantManager)getService()).add(r);
        
    }
    
    public List<Restaurant> find(User owner) {
                 
        return ((RestaurantManager)getService()).find(owner);
        
    }
    
    public List<Restaurant> find() {
                 
        return ((RestaurantManager)getService()).find();
        
    }
    
    public Restaurant find(Long id) {
                 
        return ((RestaurantManager)getService()).find(id);
        
    }
    
}
