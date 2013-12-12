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

/**
 *
 * @author Fede
 */
@Stateless
public class CategoryDAOImplementation implements CategoryDAO {

    @PersistenceContext EntityManager entityManager;
    
    public void add(Category c) {
    
        entityManager.persist(c);
    
    }
    
    public void update(Category c) {
    
        entityManager.merge(c);
    
    }    
    
    public void delete(Category c) {
    
        Category toBeDeleted = entityManager.merge(c);
        entityManager.remove(toBeDeleted);
    
    }
      
    
    public Category find(Long id) {
    
        Query query = entityManager.createQuery("SELECT c FROM Category c WHERE c.id = :id");
        query.setParameter("id", id);
        List<Category> result = (List<Category>)query.getResultList();
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    
    } 
    
    public List<Category> find() {
    
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        List<Category> result = (List<Category>)query.getResultList();
        
        return result;
    
    } 
}
