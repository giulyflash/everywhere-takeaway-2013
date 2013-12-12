/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.everywheretakeaway.integration.dao.ProductDAO;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Product;
import org.everywheretakeaway.model.Restaurant;

/**
 *
 * @author Fede
 */
@Stateless
public class ProductManagerImplementation implements ProductManager {

    /*
        public void add(Product p);
    public void update(Product r);
    public void delete(Product r);
    public List<Product> find(Category category);
    public List<Product> find(Restaurant restaurant);
    public List<Product> find(Restaurant restaurant, Category category);
    public Product find(Long id);  
    */
    
    @EJB public ProductDAO dao;

    public void add(Product p) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale inserito da RestaurantManager");
        System.out.println("Prodotto inserito da ProductManager");
    
        dao.add(p);
    
    }
    
    public void update(Product p) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale inserito da RestaurantManager");
        System.out.println("Prodotto modificato da ProductManager");
    
        dao.update(p);
    
    }
    
    public void delete(Product p) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale inserito da RestaurantManager");
        System.out.println("Prodotto eliminato da ProductManager");
    
        dao.delete(p);
    
    }
        
    public Product find(Long id) {
    
        return dao.find(id);
    
    }
    
    public List<Product> find(Category category) {
        
        return dao.find(category);
    
    }
    
    public List<Product> find(Restaurant restaurant) {
        
        return dao.find(restaurant);
    
    }
    
    public List<Product> find(Restaurant restaurant, Category category) {
    
        return dao.find(restaurant,category);
    
    }    
}
