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
import org.everywheretakeaway.model.Restaurant;

/**
 *
 * @author Fede
 */
public class PrintUserRestaurants extends SimpleTagSupport {
    
    List<Restaurant> list;

    public List<Restaurant> getList() {
        return list;
    }

    public void setList(List<Restaurant> list) {
        this.list = list;
    }
    
    public void doTag() throws JspException,IOException {
        
        
        
        Iterator<Restaurant> iterator = list.iterator();
        Restaurant current;
        
        JspWriter out = getJspContext().getOut();
        
        
        
        while(iterator.hasNext()) {
            
            current = iterator.next();
                        
            out.println("<div id='bolla'>");
            
            out.println("<script type=\"text/javascript\">");
            
            out.println("var myLatlng" + current.getId() + " = new google.maps.LatLng(" + current.getAddress().getLatitude() + "," + current.getAddress().getLongitude() + ");");
            
            out.println("function initialize" + current.getId() + "() {");
            out.println("var mapOptions = {");
            //out.println("center: new google.maps.LatLng(" + current.getAddress().getLatitude() + "," + current.getAddress().getLongitude() + "),");
            out.println("center: myLatlng" + current.getId() + ",");
            out.println("zoom: 16");
            out.println("};");
            out.println("var map" + current.getId() + " = new google.maps.Map(document.getElementById(\"map-canvas" + current.getId() + "\"),mapOptions);");
                        
            out.println("var marker" + current.getId() + " = new google.maps.Marker({");
            out.println("position: myLatlng" + current.getId() + ",");
            out.println("map: map" + current.getId() + ",");
            out.println("title: '" + current.getName() + "'");
            out.println("});");            
            
            out.println("}");
            
            out.println("google.maps.event.addDomListener(window, 'load', initialize" + current.getId() + ");");
            
            

            
            //out.println("initialize_bis()");
            out.println("</script>");           
            
            
            out.println("<div id='user_profile'>");
            
            out.println("<div id='photo'>");
            out.println("<div id=\"map-canvas" + current.getId() + "\" style=\"height:200px;width:200px;\"></div>");
            out.println("</div>");
            
            out.println("<div id='user_info'>");
            out.println("<div class=\"center\">");
            out.println("<br/>");
            out.println("<b><a href=\"show_restaurant_products.action?restaurant_id=" + current.getId() + "\">" + current.getName() + "</a></b><br/><br/>");
            out.println("<b>" + current.getOpeningTimes().getMorningOpening() + " - " + current.getOpeningTimes().getMorningClosing() + ", ");
            out.println("" + current.getOpeningTimes().getAfternoonOpening() + " - " + current.getOpeningTimes().getAfternoonClosing() + "</b>");
            out.println("<br/><br/>");
            out.println("</div>");
            
            out.println("<table id='table_user_info' align='center'>");
            
            out.println("<tr><td>Indirizzo:</td><td>" + current.getAddress().getStreet() + ", " + current.getAddress().getPostalCode() + " " + current.getAddress().getCity() + "</td></tr>");
            out.println("<tr><td>Partita IVA:</td><td>" + current.getVat() + "</td></tr>");
            out.println("<tr><td>Numero di telefono:</td><td>" + current.getPhone() + "</td></tr>");
            out.println("<tr><td>Indirizzo email:</td><td>" + current.getEmailAddress() + "</td></tr>");
            out.println("<tr><td>Raggio di consegna:</td><td>" + current.getMaxKm() + " km</td></tr>");
            
            out.println("</table>");
            
            //out.println("<table class='center' align='center'>");
            //out.println("<tr><td><a href=\"#\">Modifica</a></td><td><a href=\"#\">Elimina</a></td></tr>");
            //out.println("</table>");            
            
            out.println("<br/><div style=\"text-align:right;\"><a href=\"update_restaurant.action?restaurant_id=" + current.getId() + "\">Modifica</a> / <a href=\"delete_restaurant.action?restaurant_id=" + current.getId() + "\">Elimina</a></div>");
            
            out.println("</div>");
            
            out.println("</div>");
            out.println("</div>");            
        
            
        
        
        }
    }
    
}
