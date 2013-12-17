/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.integration.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.everywheretakeaway.model.Restaurant;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
@Stateless
public class RestaurantDAOImplementation implements RestaurantDAO {

    @PersistenceContext EntityManager entityManager;
    
    public void add(Restaurant r) {
    
        //entityManager.merge(r);
        entityManager.persist(r);
    
    }
    
    public void update(Restaurant r) {
    
        entityManager.merge(r);
    
    }    
    
    public void delete(Restaurant r) {
    
        Restaurant toBeDeleted = entityManager.merge(r);
        entityManager.remove(toBeDeleted);
    
    }
    
    
    
    public List<Restaurant> find(User owner) {
    
        Query query = entityManager.createQuery("SELECT r FROM Restaurant r WHERE r.owner = :owner");
        query.setParameter("owner", owner);
        List<Restaurant> result = (List<Restaurant>)query.getResultList();
        return result;
    
    }  
    
    public List<Restaurant> find() {
    
        Query query = entityManager.createQuery("SELECT r FROM Restaurant r");
        List<Restaurant> result = (List<Restaurant>)query.getResultList();
        return result;
    
    } 
    
    public Restaurant find(Long id) {
    
        Query query = entityManager.createQuery("SELECT r FROM Restaurant r WHERE r.id = :id");
        query.setParameter("id", id);
        List<Restaurant> result = (List<Restaurant>)query.getResultList();
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    
    }    
    
}
