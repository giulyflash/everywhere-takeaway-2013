<%-- 
    Document   : addRestaurant
    Created on : 10-dic-2013, 11.15.25
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserisci un nuovo locale</title>
        
        <script>
            
            
            
            function codeAddress() {
                
                var address = document.getElementById("street").value + ", " + document.getElementById("postalCode").value + " " + document.getElementById("city").value;
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        document.getElementById("latitude").value = results[0].geometry.location.lat();
                        document.getElementById("longitude").value = results[0].geometry.location.lng();
                        document.getElementById("form_add_restaurant").action = "send_add_restaurant.action";
                        document.getElementById("form_add_restaurant").submit();
                    } else {
                        alert("Impossibile geolocalizzare l\'indirizzo inserito per il seguente motivo: " + status);
                    }
                });
             }
        
        
        </script>
    </head>
    <body>
        <h2>Inserisci un nuovo locale</h2>
        <div id="bolla">
        <!--<form action="send_add_restaurant.action" method="post" action="javascript:codeAddress()">-->
        <form method="post" action="javascript:codeAddress()" id="form_add_restaurant">                
            <table align="center">
                
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name"/></td></tr>
                <tr><td style="text-align: left;">Via:</td><td><input type="text" id="street" name="street"/></td></tr>
                <tr><td style="text-align: left;">CAP:</td><td><input type="text" id="postalCode" name="postalCode"/></td></tr>
                <tr><td style="text-align: left;">Città:</td><td><input type="text" id="city" name="city"/></td></tr>
                
                <tr><td style="text-align: left;">Partita IVA:</td><td><input type="text" name="vat"/></td></tr>
                
                <tr><td style="text-align: left;">Indirizzo email:</td><td><input type="text" name="email"/></td></tr>  
                <tr><td style="text-align: left;">Numero di telefono:</td><td><input type="text" name="phone"/></td></tr>
                
                <tr><td style="text-align: left;">Intervallo di chilometri di consegna:</td><td><input type="text" name="maxKm"/></td></tr>    
                
            </table>    
            <input id="latitude" type="hidden" name="latitude" value="vuoto"/>
            <input id="longitude" type="hidden" name="longitude" value="vuoto"/>
            <br/>
            <table align="center">    
                <tr><td style="text-align: left;">Orari di apertura:</td><td></td></tr>    
                <tr><td style="text-align: left;">Mattino:</td><td></td></tr>    
                <tr><td><input type="text" name="morningOpening"/></td><td><input type="text" name="morningClosing"/></td></tr>      
                <tr><td style="text-align: left;">Pomeriggio:</td><td></td></tr>    
                <tr><td><input type="text" name="afternoonOpening"/></td><td><input type="text" name="afternoonClosing"/></td></tr> 
            </table>
            
            <br/><input type="submit" value="Aggiungi"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
