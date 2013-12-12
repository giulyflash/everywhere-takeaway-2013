<%-- 
    Document   : updateCategory
    Created on : 12-dic-2013, 12.08.13
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifica categoria</title>
    </head>
    <body>
        <h2>Modifica categoria</h2>
        <div id="bolla">
        <form action="send_update_category.action" method="post">
                        
            <input type="hidden" name="category_id" value="${category.getId()}"/>
            <table align="center">
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name" value="${category.getName()}"/></td></tr>
            </table>
            
            <br/><input type="submit" value="Modifica"/>
            
            
            
        </form>
        </div>
    </body>
</html>
