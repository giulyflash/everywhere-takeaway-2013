/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.integration.dao;

import java.util.List;
import org.everywheretakeaway.model.Category;

/**
 *
 * @author Fede
 */
public interface CategoryDAO {
    
    public void add(Category c);
    public void update(Category c);
    public void delete(Category c);
    public Category find(Long id);    
    public List<Category> find(); 
    
}
