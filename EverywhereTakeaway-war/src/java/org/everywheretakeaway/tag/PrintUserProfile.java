/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.tag;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.everywheretakeaway.model.User;

/**
 *
 * @author Fede
 */
public class PrintUserProfile extends SimpleTagSupport {
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void doTag() throws JspException,IOException {
        
        JspWriter out = getJspContext().getOut();
        
        
        
        if(user == null) {
            
            out.println("<div id='bolla'>");
            out.println("Nessun profilo selezionato"); 
            out.println("</div>");
        
        } else {
            
            out.println("<div id='bolla'>");
            out.println("<div id='user_profile'>");
            
            out.println("<div id='photo'>");
            out.println("<img src='" + user.getPictureUrl() + "'>");
            out.println("</div>");
            
            out.println("<div id='user_info'>");
            out.println("<br/><br/>");
            out.println("<b>" + user.getType() + "</b><br/>");
            out.println(user.getName() + " " + user.getSurname());
            out.println("<br/><br/>");
            
            out.println("<table id='table_user_info' align='center'>");
            
            out.println("<tr><td>Indirizzo:</td><td>" + user.getAddress() + "</td></tr>");
            out.println("<tr><td>Numero di telefono:</td><td>" + user.getPhone() + "</td></tr>");
            out.println("<tr><td>Indirizzo email:</td><td>" + user.getEmailAddress() + "</td></tr>");
            out.println("<tr><td>Codice fiscale:</td><td>" + user.getCf() + "</td></tr>");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            out.println("<tr><td>Data di nascita:</td><td>" + df.format(user.getBirthday()) + "</td></tr>");
            
            out.println("</table>");
            
                        
            out.println("</div>");
            
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class='clear'></div>");
            out.println("<br/><br/>");
            
            out.println("<div id='bolla_left'>");
            out.println("<b>Modifica immagine personale</b>");
            out.println("<form action='upload_photo.action' method='post' enctype='multipart/form-data'>");
            out.println("<input type='file' name='file' size='50' />");
            out.println("<br/>");
            out.println("<input type='submit' value='Carica' />");
            out.println("</form>");
            out.println("</div>");
            
            out.println("<div id='bolla'>");
            out.println("<form action='update_profile.action' method='post'>");
            out.println("<input type='submit' value='Modifica il profilo' />");
            out.println("</form>");
            out.println("<form action='update_password.action' method='post'>");
            out.println("<input type='submit' value='Modifica la password' />");
            out.println("</form>");
            out.println("</div>");
            
            
            
            /*
        
            out.println("<div id='container_photo_name'>");
            
            out.println("<div id='photo'>");
            out.println("<img src='" + user.getPictureUrl() + "'>");
            out.println("</div>");
            
            out.println("<div id='name_surname'>");
            out.println("<b>" + user.getType() + "</b><br/>");
            out.println(user.getName() + " " + user.getSurname());
            out.println("</div>");
            
            out.println("<div id='container_photo_name'>");
            
            out.println("<div class='clear'></div>");
            
            out.println("<div id='user_info'>");
            out.println("Indirizzo: " + user.getAddress() + "<br/>");
            out.println("Numero di telefono: " + user.getPhone() + "<br/>");
            out.println("Indirizzo email: " + user.getEmailAddress() + "<br/>");
            out.println("Codice fiscale: " + user.getCf() + "<br/>");
            out.println("Data di nascita: " + user.getBirthday() + "<br/>");
            
            out.println("</div>");
                    
                    */
        
        }
        
        
        
        
    }
    
}
