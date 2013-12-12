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
import org.everywheretakeaway.model.Category;

/**
 *
 * @author Fede
 */
public class PrintCategories extends SimpleTagSupport {
    
    List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    public void doTag() throws JspException,IOException {
        
        Iterator<Category> iterator = categories.iterator();
        Category current;
        
        JspWriter out = getJspContext().getOut();
        
        out.println("<div id='bolla'>");
        out.println("<a href=\"add_category.action\">Aggiungi una categoria</a><br/><br/>");
        out.println("<table align=\"center\">");
        
        while(iterator.hasNext()) {
            current = iterator.next();
            out.println("<tr><td>" + current.getName() + "</td><td><a href=\"update_category.action?category_id=" + current.getId() + "\"><img src=\"img/edit.png\" style=\"height:15px;\" alt=\"Modifica\"/></a></td><td><a href=\"delete_category.action?category_id=" + current.getId() + "\"><img src=\"img/delete.png\" style=\"height:15px;\" alt=\"Elimina\"/></a></td></tr>");
        }        
        
        out.println("</table>");
        out.println("</div>");
    }
    
}
