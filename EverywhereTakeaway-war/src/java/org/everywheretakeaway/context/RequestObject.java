/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Fede
 */
public class RequestObject {

    protected Map request = new HashMap();
    protected Map session = new HashMap();

    protected String requestCommmand;

    protected RequestObject() {

    }

    /**
     * Imposta una chiave-valore nella richiesta corrente
     * @param key
     * @param value
     */
    public void setValue(String key, Object value) {
        request.put(key,value);
    }

    /**
     * Imposta chiave-valore nella sessione corrente
     * @param key
     * @param value
     */
    public void setValueInSession(String key, Object value) {
        session.put(key,value);
    }


    /**
     * Ritorna il valore associato ad una chiave, cercandolo prima nella
     * richiesta corrente e poi nella sessione
     * @param key
     * @return
     */
    public Object getValue(String key) {
        Object value = request.get(key);

        if (value == null)
            return value = session.get(key);

        if (value instanceof Object[])
            value = ((Object[]) value)[0];

        return value;
    }
    
    /**
     * Ritorna il valore associato ad una chiave, cercandolo nella
     * sessione
     * @param key
     * @return
     */
    public Object getSessionValue(String key) {
        
        return session.get(key);

    }


    /**
     * Ritorna tutte le chiavi a cui sono associati dei valori
     * nella richiesta corrente
     * @return
     */
    public Set getRequestKeys() {
        return request.keySet();
    }

    /**
     * Ritorna tutte le chiavi a cui sono associati dei valori
     * nella sessione corrente
     * @return
     */
    public Set getSessionKeys() {
        return session.keySet();
    }


    public String getRequestCommmand() {
        return requestCommmand;
    }

    public void setRequestCommmand(String requestCommmand) {
        this.requestCommmand = requestCommmand;
    }

}
