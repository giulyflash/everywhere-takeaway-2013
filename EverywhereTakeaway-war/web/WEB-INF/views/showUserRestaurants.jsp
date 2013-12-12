<%-- 
    Document   : showUserRestaurants
    Created on : 10-dic-2013, 19.32.54
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Visualizza ristoranti</title>
    </head>
    <body>
        <everywheretakeaway:print_user_restaurants list="${list}"/>
        
        <div id="bolla" style="height:204px;">
            
            <a href="add_restaurant.action"><img src="img/plus.png" style="height:200px;width:200px;" alt="Aggiungi un locale"/></a>
            
        </div>
    </body>
</html>
