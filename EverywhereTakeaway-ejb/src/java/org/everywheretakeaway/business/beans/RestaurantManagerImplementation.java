/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.beans;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.everywheretakeaway.business.utils.MapsUtils;
import org.everywheretakeaway.integration.dao.RestaurantDAO;
import org.everywheretakeaway.model.Category;
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
    
    public List<Restaurant> find() {
    
        return dao.find();
    
    }  
    
    public Restaurant find(Long id) {
    
        return dao.find(id);
    
    }    
    
    public List<Restaurant> find(Category category) {
    
        return dao.find(category);
    
    }
    
    public List<Restaurant> findAvailable(User user) {
    
        return findAvailable(user.getAddress().getLatitude(),user.getAddress().getLongitude());
    
    }
    
    public List<Restaurant> findAvailable(User user, Category category) {
    
        return findAvailable(user.getAddress().getLatitude(),user.getAddress().getLongitude(),category);
    
    }
    
    public List<Restaurant> findAvailable(Double latitude, Double longitude) {
        
        Iterator<Restaurant> iterator = find().iterator();
        
        return findAvailableAux(latitude, longitude, iterator);
        
    }  

    
    public List<Restaurant> findAvailable(Double latitude, Double longitude, Category category) {
    
        Iterator<Restaurant> iterator = find(category).iterator();
        
        return findAvailableAux(latitude, longitude, iterator);
    
    }
    
    private List<Restaurant> findAvailableAux(Double latitude, Double longitude, Iterator<Restaurant> iterator) {
                
        List<Restaurant> orderedRestaurants = new LinkedList<Restaurant>();
        List<Double> orderedDistances = new LinkedList<Double>();
        
        Restaurant current;
        Double currentDistance;
        int i;

        // Scorro tutti i ristoranti
        while(iterator.hasNext()) {

            current = iterator.next();

            currentDistance = MapsUtils.distanceBetweenTwoPoints(latitude, longitude, current.getAddress().getLatitude(), current.getAddress().getLongitude());
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
    
        return orderedRestaurants;
    
    }    
    
}
