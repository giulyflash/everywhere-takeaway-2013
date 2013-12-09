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
    </head>
    
    <body>
        <h2>Modifica profilo</h2>
        <div id="bolla">
        <form action="send_update_profile.action" method="post">
                        
            <table align="center">
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name" value="${user.getName()}"/></td></tr>
                <tr><td style="text-align: left;">Cognome:</td><td><input type="text" name="surname" value="${user.getSurname()}"/></td></tr>
                <tr><td style="text-align: left;">Indirizzo:</td><td><input type="text" name="address" value="${user.getAddress()}"/></td></tr>
                <tr><td style="text-align: left;">Numero di telefono:</td><td><input type="text" name="phone" value="${user.getPhone()}"/></td></tr>
                <tr><td style="text-align: left;">Indirizzo email:</td><td><input type="text" name="email" value="${user.getEmailAddress()}"/></td></tr>    
                <tr><td style="text-align: left;">Codice Fiscale:</td><td><input type="text" name="cf" value="${user.getCf()}"/></td></tr>    
                <tr><td style="text-align: left;">Data di nascita:</td><td><input type="text" name="birthday" value="<everywheretakeaway:format_date date="${user.getBirthday()}"/>"/></td></tr>   
            </table>
            
            <br/><input type="submit" value="Modifica"/>
            
            
            
        </form>
        </div>
    </body>
</html>

