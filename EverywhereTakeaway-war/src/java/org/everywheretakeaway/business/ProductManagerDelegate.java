/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business;

import java.util.List;
import java.util.logging.Logger;
import org.everywheretakeaway.business.beans.ProductManager;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Product;
import org.everywheretakeaway.model.Restaurant;

/**
 *
 * @author Fede
 */
public class ProductManagerDelegate extends AbstractDelegate {
    
private static final Logger logger = Logger.getLogger(ProductManagerDelegate.class.getName());
    
    public String getServiceName() {
    
        return "java:comp/env/ejb/ProductManager";
    
    }    
    /*
        public void add(Product p);
    public void update(Product r);
    public void delete(Product r);
    public List<Product> find(Category category);
    public List<Product> find(Restaurant restaurant);
    public List<Product> find(Restaurant restaurant, Category category);
    public Product find(Long id);  
    */
    public void add(Product p) {
    
        ((ProductManager)getService()).add(p);
    
    }
    
    public void update(Product p) {
    
        ((ProductManager)getService()).update(p);
    
    }
    
    public void delete(Product p) {
    
        ((ProductManager)getService()).delete(p);
    
    }
       
    public List<Product> find(Category category) {
    
        return ((ProductManager)getService()).find(category);
    
    }
    
    public List<Product> find(Restaurant restaurant) {
    
        return ((ProductManager)getService()).find(restaurant);
    
    }
    
    public List<Product> find(Restaurant restaurant, Category category) {
    
        return ((ProductManager)getService()).find(restaurant,category);
    
    }
    
    public Product find(Long id) {
    
        return ((ProductManager)getService()).find(id);
    
    }
    
}
