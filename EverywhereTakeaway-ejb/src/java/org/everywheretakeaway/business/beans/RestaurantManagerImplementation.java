/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.everywheretakeaway.integration.dao.RestaurantDAO;
import org.everywheretakeaway.model.Restaurant;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
@Stateless
public class RestaurantManagerImplementation implements RestaurantManager {

    @EJB public RestaurantDAO dao;

    public void add(Restaurant r) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale inserito da RestaurantManager");
        System.out.println("Locale inserito da RestaurantManager");
    
        dao.add(r);
    
    }
    
    public void update(Restaurant r) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale modificato da RestaurantManager");
        System.out.println("Locale modificato da RestaurantManager");
    
        dao.update(r);
    
    }
    
    public void delete(Restaurant r) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale modificato da RestaurantManager");
        System.out.println("Locale eliminato da RestaurantManager");
    
        dao.delete(r);
    
    }
    
    public List<Restaurant> find(User owner) {
    
        return dao.find(owner);
    
    }    
    
    public Restaurant find(Long id) {
    
        return dao.find(id);
    
    }    
}
