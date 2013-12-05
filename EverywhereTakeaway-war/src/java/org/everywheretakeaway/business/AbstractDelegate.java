/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.everywheretakeaway.exception.EverywhereTakeawayException;

/**
 *
 * @author Fede
 */
public abstract class AbstractDelegate {

    /**
     * In ogni delegato è necessario implementare
     * questo metodo in modo che ritorni il nome
     * jndi del servizio
     */
    protected abstract String getServiceName();

    /**
     * Accede al servizio
     */
    protected Object getService() {
        InitialContext context;
        try {
            context = new InitialContext();
            Object lookup = context.lookup(getServiceName());
            return lookup;
        } catch (NamingException e) {
            throw new EverywhereTakeawayException(EverywhereTakeawayException.SERVICE_CONNECTION_ERROR, "Non esiste il servizio denominato "+getServiceName(), e);
        }
    }
}
