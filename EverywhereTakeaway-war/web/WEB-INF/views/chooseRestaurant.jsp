<%-- 
    Document   : chooseRestaurant
    Created on : 17-dic-2013, 17.42.58
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Risultato della ricerca</title>
    </head>
    <body>
        <everywheretakeaway:print_searched_restaurants restaurants="${orderedRestaurants}" distances="${orderedDistances}"/>
        
    </body>
</html>
