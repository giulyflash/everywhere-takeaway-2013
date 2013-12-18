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
public class PrintSearchedRestaurants extends SimpleTagSupport {
    
    List<Restaurant> restaurants;
    List<Double> distances;
    Long category_id;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Double> getDistances() {
        return distances;
    }

    public void setDistances(List<Double> distances) {
        this.distances = distances;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
    
    public void doTag() throws JspException,IOException {
        
        
        
        Iterator<Restaurant> restaurantsIterator = restaurants.iterator();
        Iterator<Double> distancesIterator = distances.iterator();
        
        Restaurant currentRestaurant;
        double currentDistance;
        
        
        JspWriter out = getJspContext().getOut();
        
        
        
        while(restaurantsIterator.hasNext()) {
            
            currentRestaurant = restaurantsIterator.next();
            currentDistance = distancesIterator.next();
            
            
            out.println("<div id='bolla'>");
            
            out.println("<script type=\"text/javascript\">");
            
            out.println("var myLatlng" + currentRestaurant.getId() + " = new google.maps.LatLng(" + currentRestaurant.getAddress().getLatitude() + "," + currentRestaurant.getAddress().getLongitude() + ");");
            
            out.println("function initialize" + currentRestaurant.getId() + "() {");
            out.println("var mapOptions = {");
            //out.println("center: new google.maps.LatLng(" + current.getAddress().getLatitude() + "," + current.getAddress().getLongitude() + "),");
            out.println("center: myLatlng" + currentRestaurant.getId() + ",");
            out.println("zoom: 16");
            out.println("};");
            out.println("var map" + currentRestaurant.getId() + " = new google.maps.Map(document.getElementById(\"map-canvas" + currentRestaurant.getId() + "\"),mapOptions);");
                        
            out.println("var marker" + currentRestaurant.getId() + " = new google.maps.Marker({");
            out.println("position: myLatlng" + currentRestaurant.getId() + ",");
            out.println("map: map" + currentRestaurant.getId() + ",");
            out.println("title: '" + currentRestaurant.getName() + "'");
            out.println("});");            
            
            out.println("}");
            
            out.println("google.maps.event.addDomListener(window, 'load', initialize" + currentRestaurant.getId() + ");");
            
            

            
            //out.println("initialize_bis()");
            out.println("</script>");           
            
            
            out.println("<div id='user_profile'>");
            
            out.println("<div id='photo'>");
            out.println("<div id=\"map-canvas" + currentRestaurant.getId() + "\" style=\"height:200px;width:200px;\"></div>");
            out.println("</div>");
            
            out.println("<div id='user_info'>");
            out.println("<div class=\"center\">");
            out.println("<br/>");
            
            if(category_id != null)
                out.println("<b><a href=\"choose_product.action?restaurant_id=" + currentRestaurant.getId() + "&category_id=" + category_id + "\">" + currentRestaurant.getName() + "</a></b><br/><br/>");
            else
                out.println("<b><a href=\"choose_product.action?restaurant_id=" + currentRestaurant.getId() + "\">" + currentRestaurant.getName() + "</a></b><br/><br/>");
            
            out.println("<b>" + currentRestaurant.getOpeningTimes().getMorningOpening() + " - " + currentRestaurant.getOpeningTimes().getMorningClosing() + ", ");
            out.println("" + currentRestaurant.getOpeningTimes().getAfternoonOpening() + " - " + currentRestaurant.getOpeningTimes().getAfternoonClosing() + "</b>");
            out.println("<br/><br/>");
            out.println("</div>");
            
            out.println("<table id='table_user_info' align='center'>");
            
            out.println("<tr><td>Indirizzo:</td><td>" + currentRestaurant.getAddress().getStreet() + ", " + currentRestaurant.getAddress().getPostalCode() + " " + currentRestaurant.getAddress().getCity() + "</td></tr>");
            out.println("<tr><td>Partita IVA:</td><td>" + currentRestaurant.getVat() + "</td></tr>");
            out.println("<tr><td>Numero di telefono:</td><td>" + currentRestaurant.getPhone() + "</td></tr>");
            out.println("<tr><td>Indirizzo email:</td><td>" + currentRestaurant.getEmailAddress() + "</td></tr>");
            out.println("<tr><td>Distanza:</td><td>" + (Math.floor(currentDistance * 100.0) / 100.0) + " km</td></tr>");
            
            out.println("</table>");
            
            //out.println("<table class='center' align='center'>");
            //out.println("<tr><td><a href=\"#\">Modifica</a></td><td><a href=\"#\">Elimina</a></td></tr>");
            //out.println("</table>");            
            
            
            
            out.println("</div>");
            
            out.println("</div>");
            out.println("</div>");            
        
            
        }
        
        
    }
    
    
}
