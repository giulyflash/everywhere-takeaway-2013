<%-- 
    Document   : registra
    Created on : 3-dic-2013, 16.00.24
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrazione</title>
        <script>
            
            
            
            function codeAddress() {
                
                var address = document.getElementById("street").value + ", " + document.getElementById("postalCode").value + " " + document.getElementById("city").value;
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        document.getElementById("latitude").value = results[0].geometry.location.lat();
                        document.getElementById("longitude").value = results[0].geometry.location.lng();
                        document.getElementById("form_register").action = "send_registration.action";
                        document.getElementById("form_register").submit();
                    } else {
                        alert("Impossibile geolocalizzare l\'indirizzo inserito per il seguente motivo: " + status);
                    }
                });
             }
        
        
        </script>        
    </head>
    
    <body>
        <h2>Registrati!</h2>
        <div id="bolla">
        <form action="javascript:codeAddress()" method="post" id="form_register">
                        
            <table align="center">
                <tr><td style="text-align: left;">Tipologia:</td><td><input type="radio" name="type" value="buyer"/>Cliente <input type="radio" name="type" value="seller"/>Fornitore</td></tr>
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name"/></td></tr>
                <tr><td style="text-align: left;">Cognome:</td><td><input type="text" name="surname"/></td></tr>
                <tr><td style="text-align: left;">Via:</td><td><input type="text" id="street" name="street"/></td></tr>
                <tr><td style="text-align: left;">CAP:</td><td><input type="text" id="postalCode" name="postalCode"/></td></tr>
                <tr><td style="text-align: left;">Città:</td><td><input type="text" id="city" name="city"/></td></tr>
                <tr><td style="text-align: left;">Numero di telefono:</td><td><input type="text" name="phone"/></td></tr>
                <tr><td style="text-align: left;">Indirizzo email:</td><td><input type="text" name="email"/></td></tr>    
                <tr><td style="text-align: left;">Codice Fiscale:</td><td><input type="text" name="cf"/></td></tr>    
                <tr><td style="text-align: left;">Data di nascita:</td><td><input type="text" name="birthday"/></td></tr>   
                <tr><td style="text-align: left;">Password:</td><td><input type="password" name="passwd"/></td></tr>   
                <tr><td style="text-align: left;">Conferma password:</td><td><input type="password" name="confirm_passwd"/></td></tr>   
            </table>
            <input id="latitude" type="hidden" name="latitude" value="vuoto"/>
            <input id="longitude" type="hidden" name="longitude" value="vuoto"/>
            <br/><input type="submit" value="Registrati"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
