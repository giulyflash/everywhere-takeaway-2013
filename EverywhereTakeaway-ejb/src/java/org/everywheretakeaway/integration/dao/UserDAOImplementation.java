/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.integration.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
@Stateless
public class UserDAOImplementation implements UserDAO {
    
    @PersistenceContext EntityManager entityManager;
    
    public void add(User u) {
    
        //entityManager.merge(u);
        entityManager.persist(u);
    
    }
    
    public void update(User u) {
    
        entityManager.merge(u);
    
    }
    
    public User find(String email, String password) {
    
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.emailAddress = :email AND u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> result = (List<User>)query.getResultList();
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    
    }
    
    public User find(String email) {
    
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.emailAddress = :email");
        query.setParameter("email", email);
        List<User> result = (List<User>)query.getResultList();
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    
    }
    
    public User find(Long id) {
    
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        List<User> result = (List<User>)query.getResultList();
        if(result.isEmpty())
            return null;
        else
            return result.get(0);
    
    }

}
