/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.integration.dao;

import java.util.List;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Restaurant;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
public interface RestaurantDAO {
    
    public void add(Restaurant r);
    public void update(Restaurant r);
    public void delete(Restaurant r);
    public List<Restaurant> find(User owner);
    public List<Restaurant> find();
    public List<Restaurant> find(Category category);
    public Restaurant find(Long id);
    
}
