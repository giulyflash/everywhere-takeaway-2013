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
    </head>
    
    <body>
        <h2>Registrati!</h2>
        <div id="bolla">
        <form action="send_registration.action" method="post">
                        
            <table align="center">
                <tr><td style="text-align: left;">Tipologia:</td><td><input type="radio" name="type" value="buyer"/>Cliente <input type="radio" name="type" value="seller"/>Fornitore</td></tr>
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name"/></td></tr>
                <tr><td style="text-align: left;">Cognome:</td><td><input type="text" name="surname"/></td></tr>
                <tr><td style="text-align: left;">Indirizzo:</td><td><input type="text" name="address"/></td></tr>
                <tr><td style="text-align: left;">Numero di telefono:</td><td><input type="text" name="phone"/></td></tr>
                <tr><td style="text-align: left;">Indirizzo email:</td><td><input type="text" name="email"/></td></tr>    
                <tr><td style="text-align: left;">Codice Fiscale:</td><td><input type="text" name="cf"/></td></tr>    
                <tr><td style="text-align: left;">Data di nascita:</td><td><input type="text" name="birthday"/></td></tr>   
                <tr><td style="text-align: left;">Password:</td><td><input type="password" name="passwd"/></td></tr>   
                <tr><td style="text-align: left;">Conferma password:</td><td><input type="password" name="confirm_passwd"/></td></tr>   
            </table>
            
            <br/><input type="submit" value="Registrati"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
