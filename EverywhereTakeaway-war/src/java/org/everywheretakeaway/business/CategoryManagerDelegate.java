/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business;

import java.util.List;
import java.util.logging.Logger;
import org.everywheretakeaway.business.beans.CategoryManager;
import org.everywheretakeaway.model.Category;

/**
 *
 * @author Fede
 */
public class CategoryManagerDelegate extends AbstractDelegate {

    private static final Logger logger = Logger.getLogger(CategoryManagerDelegate.class.getName());
    
    public String getServiceName() {
    
        return "java:comp/env/ejb/CategoryManager";
    
    }    
    
    public void add(Category c) {
    
        ((CategoryManager)getService()).add(c);
    
    }
    
    public void update(Category c) {
    
        ((CategoryManager)getService()).update(c);
    
    }
    
    public void delete(Category c) {
    
        ((CategoryManager)getService()).delete(c);
    
    }    
    
    public Category find(Long id) {
    
        return ((CategoryManager)getService()).find(id);
    
    }
    
    public List<Category> find() {
    
        return ((CategoryManager)getService()).find();
    
    }
    
    
}
