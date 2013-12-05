/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.integration.dao;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
@Stateless
public class UserDAOImplementation implements UserDAO {
    
    @PersistenceContext EntityManager entityManager;
    
    public void add(User u) {
    
        entityManager.merge(u);
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
