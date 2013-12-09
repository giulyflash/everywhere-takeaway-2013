/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.rmi.PortableRemoteObject;
import org.everywheretakeaway.model.User;
import org.everywheretakeaway.business.beans.UserManager;

/**
 *
 * @author Fede
 */
public class UserManagerDelegate extends AbstractDelegate {
    
    public String getServiceName() {
    
        return "java:comp/env/ejb/UserManager";
    
    }
    
    public User find(String email, String password) {
    
        return ((UserManager)getService()).find(email,password);
    
    }
    
    public User find(String email) {
    
        return ((UserManager)getService()).find(email);
    
    }
    
    public User find(Long id) {
    
        return ((UserManager)getService()).find(id);
    
    }
    
    public void update(User u) {
    
        ((UserManager)getService()).update(u);
    
    }
    
    public void add(User u) {
                
        // Un bug di Java non mi permette di fare il cast. 
        ((UserManager)getService()).add(u);
        
        /*
        //Context ctx = new InitialContext();
        Object ref = getService();
        UserManager bean = (UserManager)PortableRemoteObject.narrow(ref,UserManager.class);
        bean.add(u);
        */
        
        /*
        Object result = getService();
        UserManager home = (UserManager)PortableRemoteObject.narrow(result, UserManager.class);
        home.add(u);
        */
        /*
        // Workaround con la reflection
        Object service = getService();
        try {
            Method m = UserManagerLocal.class.getMethod("add", User.class);
            m.invoke(service, u);
        } catch (Exception ex) {
            Logger.getLogger(UserManagerDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
}
