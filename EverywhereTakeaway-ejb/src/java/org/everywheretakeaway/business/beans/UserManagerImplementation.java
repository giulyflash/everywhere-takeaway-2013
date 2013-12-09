/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.beans;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.everywheretakeaway.integration.dao.UserDAO;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
@Stateless
public class UserManagerImplementation implements UserManager {
    
    @EJB public UserDAO dao;

    public void add(User u) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, "Utente inserito da UserManager");
        System.out.println("Utente inserito da UserManager");
    
        dao.add(u);
    
    }
    
    public void update(User u) {
    
        //Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, "Utente inserito da UserManager");
        System.out.println("Utente modificato da UserManager");
    
        dao.update(u);
    
    }
    
    public User find(String email, String password) {
    
        return dao.find(email, password);
    
    }
    
    public User find(String email) {
    
        return dao.find(email);
    
    }
    
    public User find(Long id) {
    
        return dao.find(id);
    
    }
}
