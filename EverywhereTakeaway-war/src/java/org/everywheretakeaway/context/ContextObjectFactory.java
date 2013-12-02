/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.context;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Fede
 */
public class ContextObjectFactory {

    public static RequestObject getRequestObject(HttpServletRequest request) {
        RequestObject rObj = new RequestObject();

        //estrae il nome dell'action
        String path = request.getServletPath().split(".action")[0];
        if (path.startsWith("/"))
            path = path.substring(1);
        rObj.setRequestCommmand(path);

        //mappa i parametri della request
        Map pMap = request.getParameterMap();
        for (Iterator listaParams = pMap.keySet().iterator(); listaParams.hasNext(); ) {
            String key = (String) listaParams.next();
            rObj.request.put(key, pMap.get(key));
        }
        //mappa i parametri della sessione
        for (Enumeration listaSession = request.getSession().getAttributeNames(); listaSession.hasMoreElements(); ) {
            String key = (String) listaSession.nextElement();
            rObj.session.put(key, request.getSession().getAttribute(key));
        }

        return rObj;
    }

    public static ResponseObject getResponseObject() {
        return new ResponseObject();
    }
}

