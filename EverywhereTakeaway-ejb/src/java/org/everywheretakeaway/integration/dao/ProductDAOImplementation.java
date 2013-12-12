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
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Product;
import org.everywheretakeaway.model.Restaurant;

/**
 *
 * @author Fede
 */
@Stateless
public class ProductDAOImplementation implements ProductDAO {

    @PersistenceContext EntityManager entityManager;
    
    public void add(Product p) {
    
        //entityManager.merge(r);
        entityManager.persist(p);
    
    }
    
    public void update(Product p) {
    
        entityManager.merge(p);
    
    }    
    
    public void delete(Product p) {
    
        Product toBeDeleted = entityManager.merge(p);
        entityManager.remove(toBeDeleted);
    
    } 
    
    public Product find(Long id) {
    
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        List<Product> result = (List<Product>)query.getResultList();
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    
    } 
    
    
    public List<Product> find(Category category) {
    
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.category = :category");
        query.setParameter("category", category);
        List<Product> result = (List<Product>)query.getResultList();
        return result;
    
    } 
    
    public List<Product> find(Restaurant restaurant) {
    
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.restaurant = :restaurant");
        query.setParameter("restaurant", restaurant);
        List<Product> result = (List<Product>)query.getResultList();
        return result;
    
    } 
    
    public List<Product> find(Restaurant restaurant,Category category) {
    
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.restaurant = :restaurant AND p.category = :category");
        query.setParameter("restaurant", restaurant);
        query.setParameter("category", category);
        List<Product> result = (List<Product>)query.getResultList();
        return result;
    
    } 
    
    
}
