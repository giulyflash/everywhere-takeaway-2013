/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.beans;

import java.util.List;
import javax.ejb.Local;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Restaurant;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
@Local
public interface RestaurantManager {
    
    public void add(Restaurant r);
    public void update(Restaurant r);
    public List<Restaurant> find(User owner);
    public List<Restaurant> find();
    public List<Restaurant> find(Category category);
    public void delete(Restaurant r);
    public Restaurant find(Long id);
    
}
