<%-- 
    Document   : addProduct
    Created on : 16-dic-2013, 16.43.37
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuovo prodotto</title>
    </head>
    <body>
        <h2>Nuovo prodotto</h2>
        <div id="bolla">
        <form action="send_add_product.action" method="post">
            
            <input type="hidden" name="restaurant_id" value="${restaurant_id}"/>
            
            <table align="center">
                <tr><td style="text-align: left;">Categoria:</td><td><everywheretakeaway:print_categories_select list="${categories}"/></td></tr>  
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name"/></td></tr>  
                <tr><td style="text-align: left;">Prezzo:</td><td><input type="text" name="price"/></td></tr> 
                <tr><td style="text-align: left;">Descrizione:</td><td><textarea name="description"></textarea></td></tr> 
            </table>
            
            <br/><input type="submit" value="Aggiungi"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
