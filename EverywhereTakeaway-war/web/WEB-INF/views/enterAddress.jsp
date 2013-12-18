<%-- 
    Document   : enterAddress
    Created on : 18-dic-2013, 10.48.01
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inserisci il tuo indirizzo</title>
        <script>
            
            
            
            function codeAddress() {
                
                var address = document.getElementById("street").value + ", " + document.getElementById("postalCode").value + " " + document.getElementById("city").value;
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        document.getElementById("user_latitude").value = results[0].geometry.location.lat();
                        document.getElementById("user_longitude").value = results[0].geometry.location.lng();
                        document.getElementById("form_address").action = "choose_restaurant.action";
                        document.getElementById("form_address").submit();
                    } else {
                        alert("Impossibile geolocalizzare l\'indirizzo inserito per il seguente motivo: " + status);
                    }
                });
             }
        
        
        </script>             
    </head>
     <body>
        <h2>Inserisci il tuo indirizzo</h2>
        <div id="bolla">
        <form action="javascript:codeAddress()" method="post" id="form_address">
                        
            <table align="center">
                <tr><td style="text-align: left;">Via:</td><td><input type="text" id="street" name="street"/></td></tr>
                <tr><td style="text-align: left;">CAP:</td><td><input type="text" id="postalCode" name="postalCode"/></td></tr>
                <tr><td style="text-align: left;">Città:</td><td><input type="text" id="city" name="city"/></td></tr> 
            </table>
            <input id="user_latitude" type="hidden" name="user_latitude" value="vuoto"/>
            <input id="user_longitude" type="hidden" name="user_longitude" value="vuoto"/>
            <br/><input type="submit" value="Cerca"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
