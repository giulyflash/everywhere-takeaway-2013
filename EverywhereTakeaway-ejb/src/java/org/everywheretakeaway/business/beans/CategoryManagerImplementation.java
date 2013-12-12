/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.everywheretakeaway.integration.dao.CategoryDAO;
import org.everywheretakeaway.model.Category;

/**
 *
 * @author Fede
 */
@Stateless
public class CategoryManagerImplementation implements CategoryManager {

    @EJB public CategoryDAO dao;
    
    public void add(Category c) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale inserito da RestaurantManager");
        System.out.println("Categoria inserita da CategoryManager");
    
        dao.add(c);
    
    }
    
    public void delete(Category c) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale inserito da RestaurantManager");
        System.out.println("Categoria eliminata da CategoryManager");
    
        dao.delete(c);
    
    }
    
    public void update(Category c) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Locale inserito da RestaurantManager");
        System.out.println("Categoria modificata da CategoryManager");
    
        dao.update(c);
    
    }
    
    public Category find(Long id) {
    
        return dao.find(id);
    
    }
    
    public List<Category> find() {
    
        return dao.find();
    
    }
}
