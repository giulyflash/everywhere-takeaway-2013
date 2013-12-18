/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.everywheretakeaway.model.Product;

/**
 *
 * @author Fede
 */
public class PrintSearchedProducts extends SimpleTagSupport {
    
    List<Product> list;

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
    
    public void doTag() throws JspException,IOException {
        
        
        
        Iterator<Product> iterator = list.iterator();
        Product current;
        
        JspWriter out = getJspContext().getOut();
        
        
        
        while(iterator.hasNext()) {
            
            current = iterator.next();        
            
            out.println("<div id='bolla'>");
            
            out.println("<div id='user_profile'>");
            
            out.println("<div id='photo'>");
            out.println("<img src=\"" + current.getUrlImage() + "\" alt=\"" + current.getName() + "\"/>");
            out.println("</div>");
            
            out.println("<div id='user_info'>");
            out.println("<div class=\"center\">");
            out.println("<br/>");
            out.println("<b>" + current.getName() + "</b><br/><br/>");
            out.println("<b>" + current.getRestaurant().getName() + "</b>");
            out.println("<br/><br/>");
            out.println("</div>");
            
            out.println("<table id='table_user_info' align='center'>");
            
            out.println("<tr><td>Categoria:</td><td>" + current.getCategory().getName() + "</td></tr>");
            out.println("<tr><td>Prezzo:</td><td>" + current.getPrice() + "</td></tr>");
            out.println("<tr><td>Descrizione:</td><td style=\"max-width: 200px;\">" + current.getDescription() + "</td></tr>");
            
            out.println("</table>");
            
           
            out.println("</div>");
            
            out.println("</div>");
            out.println("</div>");            
        
            
        
        
        }
    }
    
}