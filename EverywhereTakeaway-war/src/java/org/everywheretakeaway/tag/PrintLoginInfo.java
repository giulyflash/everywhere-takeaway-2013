/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Fede
 */
public class PrintLoginInfo extends SimpleTagSupport {
    
    private String sessionName;

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void doTag() throws JspException,IOException {
        
        if(sessionName != null && !sessionName.trim().equals(""))
            getJspContext().getOut().println("Benvenuto <a href='show_profile.action'>" + sessionName + "!</a><br/><a href='logout.action'>Logout</a>");
        else
            getJspContext().getOut().println("Benvenuto visitatore!<br/><a href='login.action'>Login</a>!");

    }
}
