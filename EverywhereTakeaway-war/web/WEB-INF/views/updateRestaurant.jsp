<%-- 
    Document   : updateRestaurant
    Created on : 11-dic-2013, 14.33.14
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifica locale</title>
        
        <script>
            
            function codeAddress() {
                
                var address = document.getElementById("street").value + ", " + document.getElementById("postalCode").value + " " + document.getElementById("city").value;
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        document.getElementById("latitude").value = results[0].geometry.location.lat();
                        document.getElementById("longitude").value = results[0].geometry.location.lng();
                        document.getElementById("form_update_restaurant").action = "send_update_restaurant.action";
                        document.getElementById("form_update_restaurant").submit();
                    } else {
                        alert("Impossibile geolocalizzare l\'indirizzo inserito per il seguente motivo: " + status);
                    }
                });
             }
        
        
        </script>        
    </head>
    <body>
        <h2>Modifica locale</h2>
        <div id="bolla">
        <!--<form action="send_add_restaurant.action" method="post" action="javascript:codeAddress()">-->
        <form method="post" action="javascript:codeAddress()" id="form_update_restaurant"> 
            
            <input id="restaurant_id" type="hidden" name="restaurant_id" value="${restaurant.getId()}"/>
            
            <table align="center">
                
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name" value="${restaurant.getName()}"/></td></tr>
                <tr><td style="text-align: left;">Via:</td><td><input type="text" id="street" name="street" value="${restaurant.getAddress().getStreet()}"/></td></tr>
                <tr><td style="text-align: left;">CAP:</td><td><input type="text" id="postalCode" name="postalCode" value="${restaurant.getAddress().getPostalCode()}"/></td></tr>
                <tr><td style="text-align: left;">Città:</td><td><input type="text" id="city" name="city" value="${restaurant.getAddress().getCity()}"/></td></tr>
                
                <tr><td style="text-align: left;">Partita IVA:</td><td><input type="text" name="vat" value="${restaurant.getVat()}"/></td></tr>
                
                <tr><td style="text-align: left;">Indirizzo email:</td><td><input type="text" name="email" value="${restaurant.getEmailAddress()}"/></td></tr>  
                <tr><td style="text-align: left;">Numero di telefono:</td><td><input type="text" name="phone" value="${restaurant.getPhone()}"/></td></tr>
                
                <tr><td style="text-align: left;">Intervallo di chilometri di consegna:</td><td><input type="text" name="maxKm" value="${restaurant.getMaxKm()}"/></td></tr>    
                
            </table>    
            <input id="latitude" type="hidden" name="latitude" value="${restaurant.getAddress().getLatitude()}"/>
            <input id="longitude" type="hidden" name="longitude" value="${restaurant.getAddress().getLongitude()}"/>
            
            <br/>
            <table align="center">    
                <tr><td style="text-align: left;">Orari di apertura:</td><td></td></tr>    
                <tr><td style="text-align: left;">Mattino:</td><td></td></tr>    
                <tr><td><input type="text" name="morningOpening" value="${restaurant.getOpeningTimes().getMorningOpening()}"/></td><td><input type="text" name="morningClosing" value="${restaurant.getOpeningTimes().getMorningClosing()}"/></td></tr>      
                <tr><td style="text-align: left;">Pomeriggio:</td><td></td></tr>    
                <tr><td><input type="text" name="afternoonOpening" value="${restaurant.getOpeningTimes().getAfternoonOpening()}"/></td><td><input type="text" name="afternoonClosing" value="${restaurant.getOpeningTimes().getAfternoonClosing()}"/></td></tr> 
            </table>
            
            <br/><input type="submit" value="Modifica"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
