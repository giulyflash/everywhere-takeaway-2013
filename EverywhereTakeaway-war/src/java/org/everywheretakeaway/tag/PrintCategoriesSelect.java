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
public class PrintCategoriesSelect extends SimpleTagSupport {
    
    List<Category> list;
    Long selected_id;

    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    public Long getSelected_id() {
        return selected_id;
    }

    public void setSelected_id(Long selected_id) {
        this.selected_id = selected_id;
    }
    
    public void doTag() throws JspException,IOException {
        
        Iterator<Category> iterator = list.iterator();
        Category current;
        
        JspWriter out = getJspContext().getOut();
        
        out.println("<select name=\"category_id\">");
        
        while(iterator.hasNext()) {
            
            current = iterator.next();
            
            if(selected_id != null && current.getId().equals(selected_id))
                out.println("<option value=\"" + current.getId() + "\" selected>" + current.getName() + "</option>");
            else
                out.println("<option value=\"" + current.getId() + "\">" + current.getName() + "</option>");
            
        }
        
        out.println("</select>");
            
    }    
    
}
