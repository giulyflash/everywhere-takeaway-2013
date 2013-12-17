<%-- 
    Document   : updateProfile
    Created on : 7-dic-2013, 16.06.12
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifica profilo</title>
        <script>
            
            function codeAddress() {
                
                var address = document.getElementById("street").value + ", " + document.getElementById("postalCode").value + " " + document.getElementById("city").value;
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        document.getElementById("latitude").value = results[0].geometry.location.lat();
                        document.getElementById("longitude").value = results[0].geometry.location.lng();
                        document.getElementById("form_update_profile").action = "send_update_profile.action";
                        document.getElementById("form_update_profile").submit();
                    } else {
                        alert("Impossibile geolocalizzare l\'indirizzo inserito per il seguente motivo: " + status);
                    }
                });
             }
        
        
        </script>         
    </head>
    
    <body>
        <h2>Modifica profilo</h2>
        <div id="bolla">
        <form action="send_update_profile.action" method="post" id="form_update_profile">
                        
            <table align="center">
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name" value="${user.getName()}"/></td></tr>
                <tr><td style="text-align: left;">Cognome:</td><td><input type="text" name="surname" value="${user.getSurname()}"/></td></tr>
                <tr><td style="text-align: left;">Via:</td><td><input type="text" id="street" name="street" value="${user.getAddress().getStreet()}"/></td></tr>
                <tr><td style="text-align: left;">CAP:</td><td><input type="text" id="postalCode" name="postalCode" value="${user.getAddress().getPostalCode()}"/></td></tr>
                <tr><td style="text-align: left;">Città:</td><td><input type="text" id="city" name="city" value="${user.getAddress().getCity()}"/></td></tr>
                <tr><td style="text-align: left;">Numero di telefono:</td><td><input type="text" name="phone" value="${user.getPhone()}"/></td></tr>
                <tr><td style="text-align: left;">Indirizzo email:</td><td><input type="text" name="email" value="${user.getEmailAddress()}"/></td></tr>    
                <tr><td style="text-align: left;">Codice Fiscale:</td><td><input type="text" name="cf" value="${user.getCf()}"/></td></tr>    
                <tr><td style="text-align: left;">Data di nascita:</td><td><input type="text" name="birthday" value="<everywheretakeaway:format_date date="${user.getBirthday()}"/>"/></td></tr>   
            </table>
            <input id="latitude" type="hidden" name="latitude" value="${user.getAddress().getLatitude()}"/>
            <input id="longitude" type="hidden" name="longitude" value="${user.getAddress().getLongitude()}"/>
            
            <br/><input type="submit" value="Modifica"/>
            
            
            
        </form>
        </div>
    </body>
</html>

