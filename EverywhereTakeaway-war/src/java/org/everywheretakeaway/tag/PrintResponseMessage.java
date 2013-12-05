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
public class PrintResponseMessage extends SimpleTagSupport {
    
    private String responseMessage;
    
    public String getResponseMessage() {
        return responseMessage;
    }
    
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    
    public void doTag() throws JspException,IOException {
        
        getJspContext().getOut().println("<h2 class='responseMessage'>" + responseMessage + "</h2>");

    }
    
    
    
}
