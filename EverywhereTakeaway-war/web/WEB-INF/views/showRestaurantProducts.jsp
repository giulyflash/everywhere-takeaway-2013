<%-- 
    Document   : showRestaurantProducts
    Created on : 16-dic-2013, 16.28.11
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Visualizza prodotti</title>
    </head>
    <body>
        <everywheretakeaway:print_restaurant_products list="${list}"/>
        
        <div id="bolla" style="height:204px;">
            
            <a href="add_product.action?restaurant_id=${restaurant_id}"><img src="img/plus.png" style="height:200px;width:200px;" alt="Aggiungi un prodotto"/></a>
            
        </div>
    </body>
</html>
