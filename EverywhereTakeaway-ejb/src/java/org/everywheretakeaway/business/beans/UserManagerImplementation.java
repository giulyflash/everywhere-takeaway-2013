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
}
