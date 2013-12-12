/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Fede
 */
public class PrintMenu extends SimpleTagSupport {
    
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void doTag() throws JspException,IOException {
        
        JspWriter out = getJspContext().getOut();
        
        /*
                
            
                <li><a href="main.action">index</a></li>
                <li><a href="#">ordine</a></li>
                <li><a href="#">bolla</a></li>
                <li><a href="#">gestione</a></li>
            </ul>
        </div>
        */
        
        out.println("<div class=\"wrapper\">");
        out.println("<ul>");
        
        if(type == null || type.equals("")) {
        

            out.println("<li><a href=\"main.action\">index</a></li>");
            out.println("<li><a href=\"login.action\">login</a></li>");
            out.println("<li><a href=\"register.action\">register</a></li>");

            
        } else if(type.equals("admin")) {            
            
            out.println("<li><a href=\"main.action\">index</a></li>");
            out.println("<li><a href=\"show_categories.action\">categorie</a></li>");
        
        } else if(type.equals("buyer")) {
            
            out.println("<li><a href=\"main.action\">index</a></li>");
        
        
        } else if(type.equals("seller")) {
        
            out.println("<li><a href=\"main.action\">index</a></li>");
            out.println("<li><a href=\"show_user_restaurants.action\">gestione locali</a></li>");
            
        }
        
        out.println("</ul>");
        out.println("</div>");
    }
    
}
