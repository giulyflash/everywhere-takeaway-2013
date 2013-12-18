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
public class PrintCategoryFilter extends SimpleTagSupport {
    
    List<Category> categories;
    String action;
    Long selected_id;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getSelected_id() {
        return selected_id;
    }

    public void setSelected_id(Long selected_id) {
        this.selected_id = selected_id;
    }
        
    public void doTag() throws JspException,IOException {
        
        Iterator<Category> iterator = categories.iterator();
        Category current;
        
        JspWriter out = getJspContext().getOut();
        
        out.println("<div id=\"bolla\">");
        
        out.println("<form method=\"post\" action=\"" + action + "\">");
        
        out.println("<table>");
        
        out.println("<tr><td>Categorie</td>");
        
        out.println("<td><select name=\"category_id\">");
        
        out.println("<option value=\"\">Tutte</option>");
        
        while(iterator.hasNext()) {
            
            current = iterator.next();
            
            if(selected_id != null && current.getId().equals(selected_id))
                out.println("<option value=\"" + current.getId() + "\" selected>" + current.getName() + "</option>");
            else
                out.println("<option value=\"" + current.getId() + "\">" + current.getName() + "</option>");
            
        }
        
        out.println("</select></td>");
        
        out.println("<td><input type=\"submit\" value=\"Filtra\"/></td>");
        
        out.println("</table>");
        
        out.println("</div>");
        
        out.println("<div class='clear'></div>");
            
    }    
    
}