<%-- 
    Document   : addCategory
    Created on : 12-dic-2013, 10.52.35
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuova categoria</title>
    </head>
    <body>
        <h2>Nuova categoria</h2>
        <div id="bolla">
        <form action="send_add_category.action" method="post">
                        
            <table align="center">
                <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name"/></td></tr>  
            </table>
            
            <br/><input type="submit" value="Aggiungi"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
