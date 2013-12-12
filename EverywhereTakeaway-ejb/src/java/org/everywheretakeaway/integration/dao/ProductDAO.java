/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.integration.dao;

import java.util.List;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Product;
import org.everywheretakeaway.model.Restaurant;

/**
 *
 * @author Fede
 */
public interface ProductDAO {
    
    public void add(Product p);
    public void update(Product r);
    public void delete(Product r);
    public List<Product> find(Category category);
    public List<Product> find(Restaurant restaurant);
    public List<Product> find(Restaurant restaurant, Category category);
    public Product find(Long id);    
    
}
