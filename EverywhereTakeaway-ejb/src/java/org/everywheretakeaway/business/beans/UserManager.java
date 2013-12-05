/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.beans;

import javax.ejb.Local;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
@Local
public interface UserManager {
    
    public void add(User u);
    
}
