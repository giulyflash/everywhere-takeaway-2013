<%-- 
    Document   : chooseProduct
    Created on : 18-dic-2013, 10.31.00
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Seleziona il prodotto</title>
    </head>
    <body>
        
        <everywheretakeaway:print_category_filter categories="${categories}" action="choose_product.action?restaurant_id=${restaurant_id}" selected_id="${selected_id}"/>
        
        <everywheretakeaway:print_searched_products list="${list}"/>
        
    </body>
</html>
