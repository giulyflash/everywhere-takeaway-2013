<%-- 
    Document   : updatePassword
    Created on : 9-dic-2013, 12.22.59
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifica password</title>
    </head>
    <body>
        <h2>Modifica password</h2>
        <div id="bolla">
        <form action="send_update_password.action" method="post">
                        
            <table align="center">
                <tr><td style="text-align: left;">Vecchia password:</td><td><input type="password" name="old_password"/></td></tr>
                <tr><td style="text-align: left;">Nuova password:</td><td><input type="password" name="new_password"/></td></tr>
                <tr><td style="text-align: left;">Conferma nuova password:</td><td><input type="password" name="confirm_new_password"/></td></tr>
            </table>
            
            <br/><input type="submit" value="Modifica"/>
            
            
            
        </form>
        </div>
    </body>
</html>
