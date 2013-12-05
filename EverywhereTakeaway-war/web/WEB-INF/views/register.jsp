<%-- 
    Document   : registra
    Created on : 3-dic-2013, 16.00.24
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrazione</title>
    </head>
    <body>
        <form action="send_registration.action" method="post">
            
            <table>
                <tr></tr>
                <tr><td>Tipologia:</td><td><input type="radio" name="type" value="customer"/>Cliente <input type="radio" name="tipo" value="seller"/>Fornitore</td></tr>
                <tr></tr>
                <tr><td>Nome:</td><td><input type="text" name="name"/></td></tr>
                <tr><td>Cognome:</td><td><input type="text" name="surname"/></td></tr>
                <tr><td>Indirizzo:</td><td><input type="text" name="address"/></td></tr>
                <tr><td>Numero di telefono:</td><td><input type="text" name="phone"/></td></tr>
                <tr><td>Indirizzo email:</td><td><input type="text" name="email"/></td></tr>    
                <tr><td>Codice Fiscale:</td><td><input type="text" name="cf"/></td></tr>    
                <tr><td>Data di nascita:</td><td><input type="text" name="birthday"/></td></tr>    
                <tr><td>Immagine:</td><td>TODO</td></tr>    
            </table>
            
            <input type="submit" value="Registrati"/>
            
            
            
            
        </form>
    </body>
</html>
